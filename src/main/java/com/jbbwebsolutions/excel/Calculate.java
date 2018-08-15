package com.jbbwebsolutions.excel;

public class Calculate {

	public static <T> T vLookup(final Number number, ExcelRange<T> range, Boolean... exactMatch) {		
		return range.calculate(number);			
	}
	
	public static <T> T vLookup(final String code, ExcelRange<T> range, Boolean... exactMatch) {		
		return range.calculate(code);			
	}

}
