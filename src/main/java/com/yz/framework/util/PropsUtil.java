package com.yz.framework.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName:PropsUtil
 * @Dessription:load the property file and get the elementin it
 * @author zi_yang
 *
 */

public final class PropsUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);
	
	/**
	 * @Title: loadProperty
	 * @Description: load the property file under the classpath
	 * @param fileName
	 * @return Properties pro
	 */
	public static Properties loadProperties(String fileName) {
		Properties pro = null;
		InputStream input = null;
		try {
			
			//这里是通过getResourceAsStream方法获得当前项目的classpath进而找到properties的位置
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			
			if(input == null) {
				throw new FileNotFoundException(fileName + " file is not found");
			}
			pro = new Properties();
			pro.load(input);
			
		}
		catch(Exception e) {
			LOGGER.error("Load properties file failure",e);
		}
		finally {
			if(input != null){
				try{
					input.close();
				}catch (IOException e) {
					LOGGER.error("close input stream failure",e);
				}
			}
		}
		return pro;
	}
	
	
	/**
	 * @Title: getString
	 * @Description: get the String element from properties file
	 * @param Properties pro
	 * @param String key
	 * @return String
	 * @apiNote defaultValue is null here
	 */
	public static String getString(Properties pro, String key) {
		return getString(pro, key, "");
	}
	/**
	 * @Title: getString
	 * @Description: get the String element from properties file
	 * @param Properties pro
	 * @param String key
	 * @param String defaultValue
	 * @return String
	 */
	public static String getString(Properties pro, String key, String defaultValue) {
		String value = defaultValue;
		if(pro.containsKey(key)) {
			value = pro.getProperty(key);
		}
		return value;
	}
	
	

}
