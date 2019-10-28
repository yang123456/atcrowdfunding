package com.atguigu.atcrowdfunding.concurrency;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cglib.beans.BeanCopier;
 
public class BeanCopierUtils {
 
	public static Map<String, BeanCopier> beanCopierMap = new HashMap<String, BeanCopier>();  
      
    /**  
    * @Title: copyProperties  
    * @Description: TODO(bean属性转换)  
    * @param source 资源类 
    * @param target  目标类  
    * @author 050083
    * @date 2018年8月25日下午4:56:44
    */  
    public static void copyProperties(Object source,Object target){  
        String beanKey = generateKey(source.getClass(),target.getClass());  
        BeanCopier copier = null;  
        if (!beanCopierMap.containsKey(beanKey)) {  
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);  
            beanCopierMap.put(beanKey, copier);  
        }else {  
            copier = beanCopierMap.get(beanKey);  
        }  
        copier.copy(source, target, null);  
    }  
    
    private static String generateKey(Class<?>class1,Class<?>class2){  
        return class1.toString() + class2.toString();  
    }  
}