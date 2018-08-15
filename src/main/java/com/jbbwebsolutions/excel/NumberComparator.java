package com.jbbwebsolutions.excel;

import java.util.HashMap;
import java.util.Map;

public class NumberComparator extends _Num {

	private Map<String, Number> map = new HashMap<>();
	private static final String FIRST = "first";

	public NumberComparator is(Number number) {
		map.put(FIRST, number);
		return this;
	}

	public boolean lessThan(Number secondNumber) {
		Number firstNumber = map.get(FIRST);
		return !isGreaterThan(firstNumber, secondNumber);
	}

	public boolean greaterThan(Number secondNumber) {
		Number firstNumber = map.get(FIRST);
		return isGreaterThan(firstNumber, secondNumber);
	}

	public boolean greaterThanOrEqualTo(Number secondNumber) {
		Number firstNumber =  map.get(FIRST);
		return isGreaterThanOrEqualTo(firstNumber, secondNumber);
	}

	public static NumberComparator create() {
		return new NumberComparator();
	}
	
	public static NumberComparator instanceOf() {
		return new NumberComparator();
	}	
	
	public boolean between(Number start, Number end) {
		Number firstNumber = map.get(FIRST);
		boolean status = isGreaterThanOrEqualTo(firstNumber, start) && 
				         isLessThanOrEqualTo(start, end); 
		return status;
	}	
}