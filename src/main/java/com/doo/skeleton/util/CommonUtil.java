package com.doo.skeleton.util;

public class CommonUtil {

	public static boolean isNull(Object param) {
		if (param == null) return true;
		
		if (param instanceof String) {
			String str = (String) param;
			if (str.trim().equals("")) return true;
		}
		
		return false;
	}
	
	public static boolean isNotNull(Object param) {
		return !isNull(param);
	}
	
}
