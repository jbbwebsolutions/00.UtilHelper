package com.jbbwebsolutions.utils;

import java.lang.reflect.*;

public abstract class Clazz {
	
	
	public static <T> T execute(String className, String method) {	
		Class<?>[] parameterTypes = {};		
		T t  =execute(className, method, parameterTypes);		
		return t;
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> T execute(String className, String method, Class<?>[] parameterTypes, Object... args) {
		T t = null;
		try {
			Class<?> c = Class.forName(className);			
			Method m = c.getDeclaredMethod(method, parameterTypes);			
			t = (T)m.invoke(null, args);			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return t;
	}

	public static void main(String[] args) {
		String className = "edu.citytech.cst.business.Foo";
		String method = "getNum";
		Class<?>[] parameterTypes = {String.class, Integer.TYPE};
		
		Object[] arguments =  {"all", 5}  ;
		String i = Clazz.execute(className, method, parameterTypes, arguments  );
		int i2 = Clazz.execute(className, method );
		System.out.println(i);
		System.out.println(i2);
	}
}
