package com.jbbwebsolutions.excel;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

/**
 * 
 * <h1>ExcelRange</h1>
 * <p><b>gradeStatus</b> will return the value Very good</>
 * 
 * <pre>
 * float grade = 82;
 * 
 * ExcelRange<String> range = new ExcelRange<String>(); 		
 * 		
 * range.build(90,    "Excellent")	     
 *       .build(95.5f,"Excellent With Honors")
 *       .build(80,  "Very Good")
 *       .build(70, "Average")
 *       .build(75, "Better than Average")
 *       .build(65, "Passing")
 *       .build(60, "BorderLine Passing")
 *       .build(0f, "Failing");
 *       
 *  String gradeStatus = Calculate.vLookup(grade, range);
 *      
 *  </pre>     
 *   
 * 
 * @author jbbwe
 * 
 */

public class ExcelRange<T> {

	private Map<Number, T> map = new TreeMap<>(new DescendingOrder());
	private Map<String, T> mapCode = new HashMap<>();
	private Number number = 0;

	private Predicate<Number> process = e -> {
		boolean status = NumberComparator
				        .instanceOf()
						.is(number).greaterThanOrEqualTo(e);
		return status;
	};
	private String code;

	public ExcelRange<T> build(final Number n, final T type) {
		map.put(n, type);
		return this;
	}
	
	public ExcelRange<T> build(String  n, final T type) {
		mapCode.put(n, type);
		return this;
	}

	T calculate(final Number number) {
		this.number = number;		
		Number key = map.keySet().stream().filter(process).findFirst().get();
		T returnValue = map.get(key);
		return returnValue;
	}

	T calculate(final String code) {
		this.code = code;		
		T returnValue = mapCode.get(code);
		return returnValue;
	}
	
	
	@Override
	public String toString() {
		return "ExcelRange [map=" + map + ", mapCode=" + mapCode + ", number=" + number + ", process=" + process
				+ ", code=" + code + "]";
	}
}