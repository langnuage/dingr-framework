package com.yz.framework.helper;

import java.lang.reflect.Field;
import java.util.Map;


import com.yz.framework.annotation.Inject;

public class IocHelper {
	
	static {
		
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		if(!beanMap.isEmpty()) {
			for(Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
				Class<?> beanClass = beanEntry.getKey();
				Object beanInstance = beanEntry.getValue();
				Field[] beanFields = beanClass.getDeclaredFields();
				if(beanFields.length != 0) {
					for(Field field:beanFields) {
						if(field.isAnnotationPresent(Inject.class)) {
							Class<?> beanFieldClass = field.getType();
							Object beanFieldInstance = beanMap.get(beanFieldClass);
							if(beanFieldInstance != null) {
								ReflectionUtil.setField(beanInstance, field, beanFieldInstance);
							}
						}
					}
				}
			}
			
		}
		
	}

}
