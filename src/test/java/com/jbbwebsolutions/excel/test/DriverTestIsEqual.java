package com.jbbwebsolutions.excel.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jbbwebsolutions.excel.NumberComparator;
import static com.jbbwebsolutions.excel.NumberComparator.isBetween;


class DriverTestIsEqual {
	
	@DisplayName("isEqualToOrGreaterThan")
	@ParameterizedTest(name = "\"{0}\" should be {1}")
	@CsvSource({"true, 100, 100",
				"true, 32.4, 32.4",
				"false, 32.4, 132.4",
				"true ,44.3, 32.5"})
	
	void isEqualToOrGreaterThan(boolean result, float value1, float value2) {	
		
		boolean status = NumberComparator
		        .instanceOf()
				.is(value1).greaterThanOrEqualTo(value2);
		
		assertTrue(status == result);
	}
	
	
	@DisplayName("isBetween.1")
	@ParameterizedTest(name = "\"status {0}\" 1st value: {1} range1: {2} and range2: {3}")
	@CsvSource({"true, 75, 30, 100",
				"false, 29, 30, 100",
				"true, 101, 100.01, 5100",
				"true, 42, 33, 77",
				"true, 42, 33, 100",
				})
	
	void isBetween2(boolean result, float value, float start, float end) {	
		
		boolean status = NumberComparator
		        .instanceOf()
				.is(value).between(start, end);
		
		assertTrue(status == result);
	}
	
	@DisplayName("isBetween.2")
	@ParameterizedTest(name = "\"status {0}\" 1st value: {1} range1: {2} and range2: {3}")
	@CsvSource({"true, 75, 30, 100",
				"false, 29, 30, 100",
				"true, 99.001, 7.243, 5100",
				"true, 42, 33, 77",
				"true, 42, 42, 111",
				})
	
	void isBetweenTest(boolean result, float value, float start, float end) {		
		boolean status = isBetween(value, start, end); 
		System.out.println("between test" + status);
		assertTrue(status == result);
	}

}
