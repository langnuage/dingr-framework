package com.yz.framework.helper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

import com.yz.framework.annotation.Action;
import com.yz.framework.bean.Handler;
import com.yz.framework.bean.Request;

public class ControllerHelper {
	
	private static final Map<Request, Handler> ACTION_MAP = new HashMap<>();
	
	static {
		Set<Class<?>> controllerClassSet = ClassHepler.getControllerClass();
		
		if(!controllerClassSet.isEmpty()) {
			for(Class<?> controllerClass : controllerClassSet) {
				Method[] methods = controllerClass.getDeclaredMethods();
				if(methods.length != 0) {
					for(Method method : methods) {
						if(method.isAnnotationPresent(Action.class)) {
							Action action = method.getAnnotation(Action.class);
							String mapping = action.value();
							if(mapping.matches("\\w+:/\\w*")){
								String[] array = mapping.split(":");
								if(ArrayUtils.isNotEmpty(array) && array.length == 2){
									
									String requestMethod = array[0];
									String requestPath = array[1];
									Request request = new Request(requestMethod, requestPath);
									Handler handler = new Handler(controllerClass, method);
									ACTION_MAP.put(request, handler);
								}
							}
						}
					}
				}
			}
		}
		
	}
	
	public static Handler getHandler(String requestMethod, String requestPath) {
		Request request = new Request(requestMethod, requestPath);
		return ACTION_MAP.get(request);
	}
	

}
