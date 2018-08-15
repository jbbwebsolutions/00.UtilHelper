package com.jbbwebsolutions.excel.driver;

import com.jbbwebsolutions.excel.NumberComparator;

public class DriverNumberComp {

	public static void main(String[] args) {
				
		Number a = 333_100f, b=44_000f;
		NumberComparator x = NumberComparator.create();
		
		boolean status = x.is(a).greaterThan(b);
		System.out.println("01.status: " + status);
		
		status = x.is(421f).greaterThan(22241.999f);
		System.out.println("02.status: " + status);
	}
}