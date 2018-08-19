package com.jbbwebsolutions.utils;

public abstract class StringUtility {
	public  static String removeLastChar(final String str) {
		if (str.length() == 0 || str == null) return "";
	    return str.substring(0, str.length() - 1);
	}	
	
	private static final String regex = "-?\\d+(\\.\\d+)?";
	
	public static boolean isNumber(String data) {				
		return data.matches(regex);		
	}
	
	public static boolean isNaN(String data ) {
		return !isNaN(data);
	}
}
