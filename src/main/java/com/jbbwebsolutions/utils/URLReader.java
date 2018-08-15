package com.jbbwebsolutions.utils;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import static com.jbbwebsolutions.utils.StringUtility.removeLastChar;

import com.google.gson.Gson;

public abstract class URLReader {
		
	public static boolean isValidURL(String url) {
		return false;
	}

	public static <T> T getURL(String sURL, Class<T> clazz, Map<String, Object> keyAndValue) {
		
		String paremeters = getParameters(keyAndValue);
		
		T dto = null;
		try {
			URL url = new URL(sURL+paremeters);
			InputStreamReader reader = new InputStreamReader(url.openStream());
			dto = new Gson().fromJson(reader, clazz);
		} catch (Exception e) {			
			e.printStackTrace();
		}

		return dto;                  
	}

	private static String getParameters(Map<String, Object> keyAndValue) {
		
		if (keyAndValue == null || keyAndValue.size() ==  0) return "";
		
		StringBuilder sb = new StringBuilder("?");
		keyAndValue.forEach((k,v) -> {
			sb.append(k)
			  .append("=")
			  .append(v)
			  .append("&");
		});

		return removeLastChar(sb.toString());
	}

	public static <T> T getURL(String sURL, Class<T> clazz) {
		return getURL(sURL, clazz, new HashMap<>());
	}

}
