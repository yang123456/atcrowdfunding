package com.atguigu.atcrowdfunding.demo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

public class ObjectUtil {
	/**
	 * map转化为对象
	 * 
	 * @param map
	 * @param beanClass
	 * @return
	 * @throws Exception
	 */
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
		if (map == null)
			return null;
		Object obj = beanClass.newInstance();
		BeanUtils.populate(obj, map);
		return obj;
	}

	// 对象转换成map
	public static Map<String, String> objectToMap(Object obj) {
		Map<String, String> map = new HashMap<String, String>();
		Field[] fields = obj.getClass().getDeclaredFields();
		for (int i = 0, len = fields.length; i < len; i++) {
			String varName = fields[i].getName();
			System.out.println("varName=" + varName);
			try {
				boolean accessFlag = fields[i].isAccessible();
				fields[i].setAccessible(true);
				Object o = fields[i].get(obj);
				if (o != null) {
					map.put(varName, o.toString());
				}
				fields[i].setAccessible(accessFlag);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserVo user = new UserVo();
		user.setSex("11");
		user.setId(11);
		user.setPrice(11f);
		user.setName("zhuxuewen");
		map.put("id", user.getId());
		map.put("sex", user.getSex());
		map.put("name", user.getName());
		map.put("aa", user.getName());
		try {
			Object object = ObjectUtil.mapToObject(map, UserVo.class);
			if (object instanceof UserVo) {
				UserVo vo = (UserVo) object;
				System.out.println(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		UserVo user = new UserVo();
//		user.setSex("11");
//		user.setName("zhuxuewen");
//		user.setPassWd("22222");
//		user.setId(11);
//		user.setPrice(11f);
//		Map<String,String> map = ObjectUtil.objectToMap(user);
//		if (null!= map && map.size()!=0){
//			Set<Entry<String,String>> set = map.entrySet();
//			for(Entry<String,String> en:set){
//				System.out.println(en.getKey()+"   "+en.getValue());
//			}
//		}
	}

}
