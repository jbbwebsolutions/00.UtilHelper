package com.jbbwebsolutions.excel.test;

import static com.jbbwebsolutions.excel._Num.isGreaterThan;
import static com.jbbwebsolutions.excel._Num.isLessThan;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class IsTest {
	
	@DisplayName("isGreaterThan")
	@ParameterizedTest(name = "\"{0}\" should be {1}")
	@CsvSource({"true, 102, 100",
				"true, 32.40002, 32.4",
				"false, 32.4, 132.4",
				"true ,44.3, 32.5"})
	
	void isEqualToOrGreaterThan(boolean result, float value1, float value2) {	
		
		boolean status = isGreaterThan(value1, value2);		
		assertTrue(status == result); 
	}
	
	@DisplayName("isLessThan")
	@ParameterizedTest(name = "\"{0}\" should be {1}")
	@CsvSource({"true, 77, 100",
				"true, 2.002, 32.4",
				"true, 3.4, 132.4",
				"false, 40, 40",
				"true ,4.3, 32.5"})
	
	void isLessThanTest(boolean result, float value1, float value2) {
		
		boolean status = isLessThan(value1, value2);		
		assertTrue(status == result); 
	}
	

}
