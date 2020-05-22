package com.yz.framework.helper;

import java.util.Properties;

import com.yz.framework.ConfigConstant;
import com.yz.framework.util.PropsUtil;

/**
 * @ClassName ConfigHelper 
 * @author 20411
 * @Description get the element in property file
 */
public final class ConfigHelper {
	
	private static final Properties CONFIG_PROS = 
			PropsUtil.loadProperties(ConfigConstant.CONFIG_FILE);
	
	
	public static String getJDBCDriver() {
		return PropsUtil.getString(CONFIG_PROS, ConfigConstant.JDBC_DRIVER);
	}
	
	public static String getJDBCURL() {
		return PropsUtil.getString(CONFIG_PROS, ConfigConstant.JDBC_URL);
	}
	
	public static String getJDBCUSERNAME() {
		return PropsUtil.getString(CONFIG_PROS, ConfigConstant.JDBC_USERNAME);
	}
	
	public static String getJDBCPASSWORD() {
		return PropsUtil.getString(CONFIG_PROS, ConfigConstant.JDBC_PASSWORD);
	}
	
	public static String getAppBasePackage() {
		return PropsUtil.getString(CONFIG_PROS, ConfigConstant.APP_BASE_PACKAGE);
	}
	
	public static String getAppJspPath() {
		return PropsUtil.getString(CONFIG_PROS, ConfigConstant.APP_JSP_PATH);
	}
	
	public static String getAppUploadLimit() {
		return PropsUtil.getString(CONFIG_PROS, ConfigConstant.APP_UPLOAD_LIMIT);
	}
	
	public static String getAppAssertPath() {
		return PropsUtil.getString(CONFIG_PROS, ConfigConstant.APP_ASSERT_PATH);
	}
	
}
