package com.jbbwebsolutions.excel;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class _Num {	
	/* made the is methods public */
	
	public static boolean isLessThan(Number i, Number j) {
		return compare(i, j) == -1;
	}
	
	public static boolean isLessThanOrEqualTo(Number i, Number j) {
		return compare(i, j) == -1 || compare(i, j) == 0;
	}
	
	public static boolean isGreaterThan(Number i, Number j) {
		return compare(i, j) == 1;
	}

	protected static boolean isGreaterThanOrEqualTo(Number i, Number j) {
		return compare(i, j) == 0 || compare(i, j) == 1;
	}

	protected static int compare(Number x, Number y) {
		if (isSpecial(x) || isSpecial(y))
			return Double.compare(x.doubleValue(), y.doubleValue());
		else
			return toBigDecimal(x).compareTo(toBigDecimal(y));
	}
	
	
	public static boolean isBetween(Number value, Number start, Number end) {
		System.out.println("start " + start + " end: " + end);
		boolean status1 = isGreaterThanOrEqualTo(value, start);
		boolean status2=  isLessThanOrEqualTo(value, end);		
		System.out.println("status1 " + status1 + " status2 " + status2);
		return status1 && status2;
	}
	

	protected static boolean isSpecial(Number x) {
		boolean specialDouble = x instanceof Double && (Double.isNaN((Double) x) || Double.isInfinite((Double) x));
		boolean specialFloat = x instanceof Float && (Float.isNaN((Float) x) || Float.isInfinite((Float) x));
		return specialDouble || specialFloat;
	}

	protected static BigDecimal toBigDecimal(Number number) {
		if (number instanceof BigDecimal)
			return (BigDecimal) number;
		if (number instanceof BigInteger)
			return new BigDecimal((BigInteger) number);
		if (number instanceof Byte || number instanceof Short || number instanceof Integer || number instanceof Long)
			return new BigDecimal(number.longValue());
		if (number instanceof Float || number instanceof Double)
			return new BigDecimal(number.doubleValue());

		try {
			return new BigDecimal(number.toString());
		} catch (final NumberFormatException e) {
			throw new RuntimeException("The given number (\"" + number + "\" of class " + number.getClass().getName()
					+ ") does not have a parsable string representation", e);
		}
	}	
} 