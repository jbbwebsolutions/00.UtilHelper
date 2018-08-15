package com.jbbwebsolutions.excel;

import java.util.Comparator;

class DescendingOrder implements Comparator<Number> {

	@Override
	public int compare(Number o1, Number o2) {
		int x = _Num.compare(o1, o2) * -1;
		return x;
	}
}
