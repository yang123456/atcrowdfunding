package com.atguigu.atcrowdfunding.guava.classPath;

import java.io.IOException;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;

public class ClassPathTest {
	@Test
	public void classPathTest() {
		try {
			ClassPath classpath = ClassPath.from(ClassPathBase.class.getClassLoader());
			// getTopLevelClassesRecursive
			ImmutableSet<ClassPath.ClassInfo> topClassList = classpath
					.getTopLevelClassesRecursive("com.atguigu.atcrowdfunding");
			if (topClassList != null && !topClassList.isEmpty()) {
				for (ClassPath.ClassInfo classInfoItem : topClassList) {
					System.out.println(classInfoItem.toString());
				}
			}
			// getResources
			ImmutableSet<ClassPath.ResourceInfo> resourceList = classpath.getResources();
			if (resourceList != null && !resourceList.isEmpty()) {
				for (ClassPath.ResourceInfo resourceItem : resourceList) {
					System.out.println(resourceItem.url().toString());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static class ClassPathBase {

	}

}

