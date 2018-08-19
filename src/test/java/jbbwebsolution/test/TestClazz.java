package jbbwebsolution.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jbbwebsolutions.utils.Clazz;

class TestClazz {
	
	
	@DisplayName("String, and Integer Method Call")
	@Test
	void theIsNumberTest() {
		String className = "com.jbbwebsolutions.utils.StringUtility";
		String method = "isNumber";
		Class<?>[] parameterTypes = {String.class};
		
		Object[] arguments =  {"4"}  ;
		boolean i = Clazz.execute(className, method, parameterTypes, arguments  );
		
		assertTrue(i == true);	
		
	}
	

	@DisplayName("String, and Integer Method Call")
	@Test
	void test() {
		String className = "com.jbbwebsolutions.pseudo.model.Foo";
		String method = "getNum";
		Class<?>[] parameterTypes = {String.class, Integer.TYPE};
		
		Object[] arguments =  {"fab-", 5}  ;
		String i = Clazz.execute(className, method, parameterTypes, arguments  );
		
		assertTrue(i.equals("fab-5"));	
		
	}
	
	
	@DisplayName("-String, and Integer Method Call")
	@Test
	void test2() {
		String className = "com.jbbwebsolutions.pseudo.model.Foo";
		String method = "getNum";
		Class<?>[] parameterTypes = {String.class, Integer.TYPE};
		
		Object[] arguments =  {"fab-", 5}  ;
		String i = Clazz.execute(className, method, parameterTypes, arguments  );
		
		assertFalse(i.equals("3fab-5"));	
		
	}
	
	@DisplayName("Integer Method Call")
	@Test
	void test3() {
		String className = "com.jbbwebsolutions.pseudo.model.Foo";
		String method = "getNum";
		Class<?>[] parameterTypes = {Integer.TYPE};
		
		Object[] arguments =  {5}  ;
		int i = Clazz.execute(className, method, parameterTypes, arguments  );		
		assertTrue(i == 25, "value is..: " + i);	
		
	}
	
	
	
	@DisplayName("Method Calls")
	@ParameterizedTest(name = " method name {0}  calculate {1} and {2} = {3}")
	@CsvSource( {
		"mult, 5,10,50",
		"add, 5,10,15",
		"add, 5,10,15",
		"mult, 50,10,500",
	})
	public void testDynamicMethods(String method, int a, int b, int result) {	
		
		String className = "com.jbbwebsolutions.pseudo.model.Foo";	
		Class<?>[] parameterTypes = {Integer.TYPE, Integer.TYPE};		
		Object[] arguments =  {a,b}  ;
		int expectedValue = Clazz.execute(className, method, parameterTypes, arguments  );	
		assertTrue(expectedValue == result, "value is..: " + result);

	}


}
