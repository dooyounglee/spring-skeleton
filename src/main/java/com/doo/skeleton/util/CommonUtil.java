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
	
	public static String lpad(String str, int length, String fill) {
		int len = str.length();
		if (str.length() < length) {
			for (int i=0; i<length-len;i++) str = fill + str;
			return str;
		}
		return str.substring(0, length);
	}
	
}
