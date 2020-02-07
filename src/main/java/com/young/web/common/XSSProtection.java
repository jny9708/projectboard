package com.young.web.common;

public class XSSProtection {
	
	public String replaceParameter(String param) {
		String result = param;
		if(param != null) {
			result = result.replaceAll("<","&lt;");
			result = result.replaceAll(">","&gt;");
			result = result.replaceAll("[(]","&#40;");
			result = result.replaceAll("[)]","&#41;");
		}
		return result;
	}
}
