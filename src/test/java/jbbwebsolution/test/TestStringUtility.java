package jbbwebsolution.test;

import static com.jbbwebsolutions.utils.StringUtility.isNumber;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestStringUtility {

	@Test
	void test() {
		boolean x = isNumber("4423");	
		assertTrue(x);		
	}

}
