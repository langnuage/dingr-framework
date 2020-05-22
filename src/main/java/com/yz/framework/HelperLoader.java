package com.yz.framework;

import com.yz.framework.helper.BeanHelper;
import com.yz.framework.helper.ClassHepler;
import com.yz.framework.helper.ConfigHelper;
import com.yz.framework.helper.ControllerHelper;
import com.yz.framework.helper.IocHelper;
import com.yz.framework.util.ClassUtil;

public final class HelperLoader {
	
	public static void init() {
		Class<?>[] classlist = {
			ConfigHelper.class,
			ClassHepler.class,
			BeanHelper.class,
			IocHelper.class,
			ControllerHelper.class
		};
		
		for(Class<?> cls : classlist) {
			ClassUtil.loadClass(cls.getName());
		}
	}
	
	

}
