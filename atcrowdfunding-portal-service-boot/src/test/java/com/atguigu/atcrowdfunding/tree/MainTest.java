package com.atguigu.atcrowdfunding.tree;

import java.io.File;

/**
 * The type Main Test.
 */
public class MainTest {
 
    public static void main(String[] args) {
        final File generateFile = new File("D:\\github\\atcrowdfunding\\atcrowdfunding-portal-service-boot");
        final String generate = DirectoryTreeV1.create(generateFile)
                .setDeep(20)
                .setFileFilter(pathname -> (!(pathname.isHidden() || pathname.getName().contains("target"))))
                /*.showLength()
                .showModify()
                .showPermission()
                .addAppendContent(new DirectoryTreeV1.AppendContent() {
                    @Override
                    public String appendContent(File file) {
                        return "[" + file.getPath() + "]";
                    }
                })*/
                .generate(generateFile);
        System.out.println(generate);
 
    }
 
}