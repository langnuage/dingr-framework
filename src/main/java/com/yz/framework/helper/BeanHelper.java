package com.yz.framework.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BeanHelper {
	
	private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();
	
	static {
		Set<Class<?>> sc = ClassHepler.getBeanClass();
		for(Class<?> cls:sc) {
			Object obj = ReflectionUtil.newInstance(cls);
			BEAN_MAP.put(cls, obj);
		}
	}
	
	public static Map<Class<?>, Object> getBeanMap() {
		return BEAN_MAP;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> cls) {
		if(!BEAN_MAP.containsKey(cls)) {
			throw new RuntimeException("can not get bean class by "+cls);
		}
		return (T)BEAN_MAP.get(cls);
	}

}
