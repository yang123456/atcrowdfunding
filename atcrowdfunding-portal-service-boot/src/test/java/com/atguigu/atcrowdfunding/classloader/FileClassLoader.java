package com.atguigu.atcrowdfunding.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 七、开发自己的类加载器
一般来说，自己开发的类加载器只需要覆写findClass(String name)方法即可。java.lang.ClassLoader类的方法loadClass()封装了双亲委派模型的实现。
该方法会首先调用findLoadedClass()方法来检查该类是否已经被加载过；
如果没有加载过的话，会调用父类加载器的 loadClass()方法来尝试加载该类；如果父类加载器无法加载该类的话，就调用findClass()方法来查找该类。
因此，为了保证类加载器都正确实现代理模式，在开发自己的类加载器时，最好不要覆写 loadClass()方法，而是覆写findClass()方法。示例如下：
 *
 */
public class FileClassLoader extends ClassLoader {
    private String rootDir;

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    /**
     * 编写findClass方法的逻辑
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 获取类的class文件字节数组
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            //直接生成class对象
            return defineClass(name, classData, 0, classData.length);
        }
    }

    /**
     * 编写获取class文件并转换为字节码流的逻辑
     * @param className
     * @return
     */
    private byte[] getClassData(String className) {
        // 读取类文件的字节
        String path = classNameToPath(className);
        System.out.println("path="+path);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            // 读取类文件的字节码
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 类文件的完全路径
     * @param className
     * @return
     */
    private String classNameToPath(String className) {
        return rootDir + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        String rootDir="/Users/zejian/Downloads/Java8_Action/src/main/java/";
        String rootDir="D:\\github\\atcrowdfunding\\atcrowdfunding-portal-service-boot\\src\\test\\java";
        //创建自定义文件类加载器
        FileClassLoader loader = new FileClassLoader(rootDir);
        FileClassLoader loader2 = new FileClassLoader("D:\\github\\atcrowdfunding\\atcrowdfunding-portal-service-boot\\target\\test-classes");
        try {
            //加载指定的class文件
            Class<?> object1=loader.loadClass("com.atguigu.atcrowdfunding.classloader.DemoObj");
            Class<?> object2 = loader2.findClass("com.atguigu.atcrowdfunding.classloader.DemoObj");

            System.out.println(object1.newInstance().toString());
            System.out.println(object2.newInstance().toString());
            System.out.println(object1 == object2);

            //输出结果:I am DemoObj
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
