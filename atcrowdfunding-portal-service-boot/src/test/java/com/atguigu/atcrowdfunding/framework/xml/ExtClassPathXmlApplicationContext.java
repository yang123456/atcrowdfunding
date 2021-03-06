package com.atguigu.atcrowdfunding.framework.xml;
/**
 * 手写Spring专题 XML方式注入bean
 */

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ExtClassPathXmlApplicationContext {
	// xml路径地址
	private String xmlPath;

	public ExtClassPathXmlApplicationContext(String xmlPath) {
		this.xmlPath = xmlPath;
	}

//	public Object getBean(String beanId) throws Exception {
//		// 1. 读取配置文件
//		List<Element> elements = readerXml();
//		if (elements == null) {
//			throw new Exception("该配置文件没有子元素");
//		}
//		// 2. 使用beanId查找对应的class地址
//		String beanClass = findXmlByIDClass(elements, beanId);
//		if (StringUtils.isEmpty(beanClass)) {
//			throw new Exception("未找到对应的class地址");
//		}
//		// 3. 使用反射机制初始化，对象
//		Class<?> forName = Class.forName(beanClass);
//		return forName.newInstance();
//	}

	/*
	 * dom4j解析
	 */
	public Object getBean(String id) throws Exception {
		// 1. 读取配置文件
		List<Element> list = readerXml();
		if (list == null) {
			throw new Exception("该配置文件没有子元素");
		}
		Object obj = null;
		for (Element element : list) {
			String idString = element.attributeValue("id");
			if (!id.equals(idString)) {
				continue;
			}
			// 获取bean的class地址
			String classString = element.attributeValue("class");
			// 发射实例化bean
			Class<?> class1 = Class.forName(classString);
			obj = class1.newInstance();
			// 获取子类对象
			List<Element> elements = element.elements();
			if (elements.size() <= 0) {
				return null;
			}
			for (Element element2 : elements) {
				String name = element2.attributeValue("name");
				System.out.println(name);
				String value = element2.attributeValue("value");
				// 使用反射为对象赋值
				Field field = class1.getDeclaredField(name);
				field.setAccessible(true);
				field.set(obj, value);
			}
		}
		return obj;

	}

	// 读取配置文件信息
	public List<Element> readerXml() throws DocumentException {
		SAXReader saxReader = new SAXReader();
		if (StringUtils.isEmpty(xmlPath)) {
			new Exception("xml路径为空...");
		}
		Document read = saxReader.read(getClassXmlInputStream(xmlPath));
		// 获取根节点信息
		Element rootElement = read.getRootElement();
		// 获取子节点
		List<Element> elements = rootElement.elements();
		if (elements == null || elements.isEmpty()) {
			return null;
		}
		return elements;
	}

	// 使用beanid查找该Class地址
	public String findXmlByIDClass(List<Element> elements, String beanId) throws Exception {
		for (Element element : elements) {
			// 读取节点上是否有value
			String beanIdValue = element.attributeValue("id");
			if (beanIdValue == null) {
				throw new Exception("使用该beanId为查找到元素");
			}
			if (!beanIdValue.equals(beanId)) {
				continue;
			}
			// 获取Class地址属性
			String classPath = element.attributeValue("class");
			if (!StringUtils.isEmpty(classPath)) {
				return classPath;
			}
		}
		return null;
	}

	// 读取xml配置文件
	public InputStream getClassXmlInputStream(String xmlPath) {
		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(xmlPath);
		return resourceAsStream;
	}

}
