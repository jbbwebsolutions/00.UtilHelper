package com.jbbwebsolutions.excel.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jbbwebsolutions.excel.Calculate;
import com.jbbwebsolutions.excel.ExcelRange;

<<<<<<< HEAD

/*
 * We are in the master 
 * branch
 */

=======
/*
 * added the @BeforeAll occurs only once
 * and must be static
 * 
 */
>>>>>>> alternate
public class TestNeedAssistance {
	
	static ExcelRange<String> range = new ExcelRange<String>();
	
	//@BeforeEach
	@BeforeAll
	static void  _before() {
		System.out.println("BeforeEach");
		range.build(90,"Excellent")
		     .build(80,"Passing")
		     .build(50,"Need Assistance")
		     .build(0, "Failing");		
	}
	
	
	@DisplayName("Failing78")
	@ParameterizedTest(name = "\"{0}\" should be {1}")
	@CsvSource({"Failing, 49.9999",
				"Failing, 45",
				"Failing, 40",				
				"Failing, 30", 					
				})
	
	void isFailing(String result, float grade) {			
		String gradeStatus = Calculate.vLookup(grade, range);		
		assertTrue(gradeStatus.equals(result));
	}
	
	
	@DisplayName("Passing")
	@ParameterizedTest(name = "\"{0}\" should be {1}")
	@CsvSource({"Passing, 81",
				"Passing, 82",
				"Passing, 83",				
				"Passing, 89.99",					
				})
	
	void isExcellent(String result, float grade) {			
		String gradeStatus = Calculate.vLookup(grade, range);		
		assertTrue(gradeStatus.equals(result));
	}	
	
	@DisplayName("Excellent")
	@ParameterizedTest(name = "\"{0}\" should be {1}")
	@CsvSource({
				"Excellent, 92",				
				"Excellent, 90",
				"Excellent, 90",	
				"Excellent, 92",
				"Excellent, 91"
				})
	
	void isPassing(String result, float grade) {			
		String gradeStatus = Calculate.vLookup(grade, range);		
		assertTrue(gradeStatus.equals(result));
	}
}