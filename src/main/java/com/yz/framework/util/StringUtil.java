package com.yz.framework.util;

import org.apache.commons.lang3.StringUtils;

public final class StringUtil {
	
	public static final String SEPARATOR = String.valueOf((char) 29);
	
	public static boolean isEmpty(String str){
		if(str != null){
			//É¾³ýÍ·Î²¿Õ°×·û
			str = str.trim();
		}
		return StringUtils.isEmpty(str);
	}
	
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	
	public static String[] splitString(String body, String separator) {
		if(StringUtil.isNotEmpty(separator) && StringUtil.isNotEmpty(body)){
			String[] result = body.split(separator);
			return result;
		}else{
			return null;
		}
	}

}
