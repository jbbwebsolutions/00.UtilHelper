package jbbwebsolution.test;

import static com.jbbwebsolutions.utils.URLReader.*;

public class TestNetwork {

	public static void main(String[] args) {
		String url = "https://www1.nyc.gov/311/index.page";
		String value = getURL(url, String.class);
		System.out.println(value);
	}
	
}
