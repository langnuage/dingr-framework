package com.yz.framework.helper;


import java.util.HashSet;
import java.util.Set;

import com.yz.framework.annotation.Controller;
import com.yz.framework.annotation.Service;
import com.yz.framework.util.ClassUtil;

public class ClassHepler {
	
	private static final Set<Class<?>> classSet;
	
	static {
		String basePackage = ConfigHelper.getAppBasePackage();
		classSet = ClassUtil.getClassSet(basePackage);
	}
	
	public static Set<Class<?>> getClassSet() {
		return classSet;
	}
	
	public static Set<Class<?>> getServiceClass() {
		Set<Class<?>> sc = new HashSet<Class<?>>();
		for(Class<?> cls:classSet) {
			if(cls.isAnnotationPresent(Service.class)) {
				sc.add(cls);
			}
		}
		return sc;
	}
	
	public static Set<Class<?>> getControllerClass() {
		Set<Class<?>> sc = new HashSet<Class<?>>();
		for(Class<?> cls:classSet) {
			if(cls.isAnnotationPresent(Controller.class)) {
				sc.add(cls);
			}
		}
		return sc;
	}
	
	
	public static Set<Class<?>> getBeanClass() {
		Set<Class<?>> sc = new HashSet<Class<?>>();
		sc.addAll(getServiceClass());
		sc.addAll(getControllerClass());
		return sc;
	}
	

}
