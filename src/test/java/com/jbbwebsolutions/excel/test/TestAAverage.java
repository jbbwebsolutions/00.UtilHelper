package com.jbbwebsolutions.excel.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jbbwebsolutions.excel.Calculate;
import com.jbbwebsolutions.excel.ExcelRange;

class TestAAverage {
	
	
	@DisplayName("Grade Status")
	@ParameterizedTest(name = "\"{0}\" should be {1}")
	@CsvSource({"Excellent, 90",
				"Excellent, 92",
				"Excellent, 93.4",
				"Excellent, 95.444",
				"Failing, 59.9444",
				"Passing, 65.0",
				"Average, 71.0",
				"Average, 74.99",
				"Excellent With Honors, 105.99",
				"Very Good, 80.001",
				})
	
	void isEqualToOrGreaterThan(String status, float grade) {	
		
		
		ExcelRange<String> range = new ExcelRange<String>();
		
		range.build(90,"Excellent")
		     .build(95.5f,"Excellent With Honors")
		     .build(80,"Very Good")
		     .build(70, "Average")
		     .build(75, "Better than Average")
		     .build(65, "Passing")
		     .build(60, "BorderLine Passing")
		     .build(0f, "Failing");		
		
		String gradeStatus = Calculate.vLookup(grade, range);
		
		assertTrue(gradeStatus.equals(status));		
	}
}