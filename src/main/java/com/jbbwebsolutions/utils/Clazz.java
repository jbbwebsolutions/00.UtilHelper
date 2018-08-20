package com.jbbwebsolutions.utils;

import java.lang.reflect.*;

public abstract class Clazz {
	
	/** 
	 * <p>The objective is to create execute a <b>method</b>
	 * by knowing the name of the class and method names.
	 * </p> 
	 * 
	 *  String className = "edu.citytech.cst.business.Foo";
	 *  String method = "getNum";
	 *  Class<?>[] parameterTypes = {String.class, Integer.TYPE};
	 *  bject[] arguments =  {"all", 5}  ;
	 *  String i = Clazz.execute(className, method, parameterTypes, arguments  );
	 *  int i2 = Clazz.execute(className, method );
	 *  System.out.println(i);
	 *  System.out.println(i2);
	 *  
	 *  @author  jbbwebsolutions of Jean Boulet
	 *  @see     n/a
	 *  @since   JDK8.0		 
	 * 
	 */	
	
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
}