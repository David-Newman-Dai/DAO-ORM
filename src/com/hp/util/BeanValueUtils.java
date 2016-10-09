package com.hp.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BeanValueUtils {
	private BeanValueUtils() {}
	public static void setValue(Object obj,String attributeName,Object value) {
		try {
			Field field = obj.getClass().getDeclaredField(attributeName) ;
			Method setMethod = obj.getClass().getMethod("set" + StringUtils.initcap(attributeName),field.getType());
			setMethod.invoke(obj, value) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public static <T> T getValue(Object obj, String attributeName, Class<T> cls) {
		try {
			Method getMethod = obj.getClass().getMethod("get" + StringUtils.initcap(attributeName));
			return (T) getMethod.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
}
