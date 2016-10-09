package com.hp.util;

public class StringUtils {
	public static String initcap(String str) {
		if (str == null || "".equals(str)) {
			return str;
		}
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
} 
