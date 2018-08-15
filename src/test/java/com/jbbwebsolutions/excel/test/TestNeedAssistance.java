package com.jbbwebsolutions.excel.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jbbwebsolutions.excel.Calculate;
import com.jbbwebsolutions.excel.ExcelRange;


public class TestNeedAssistance {
	
	@DisplayName("isEqualToOrGreaterThan")
	@ParameterizedTest(name = "\"{0}\" should be {1}")
	@CsvSource({"Passing, 81",
				"Passing, 82",
				"Passing, 83",
				"Excellent, 92",
				"Passing, 89.99",
				"Excellent, 90",
				"Excellent, 90"	
				})
	
	void isPassing(String result, float grade) {	
		
		ExcelRange<String> range = new ExcelRange<String>();
		
		range.build(90,"Excellent")
		     .build(80,"Passing")
		     .build(50,"Need Assistance")
		     .build(0, "Failing");
		     
		String gradeStatus = Calculate.vLookup(grade, range);
		
		assertTrue(gradeStatus.equals(result));
	}

}
