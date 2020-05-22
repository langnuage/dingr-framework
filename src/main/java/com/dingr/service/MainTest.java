package com.dingr.service;

import com.yz.framework.HelperLoader;
import com.yz.framework.helper.BeanHelper;

public class MainTest {
	
	public static void main(String[] args) {
		
		HelperLoader.init();
		HeroService hs = BeanHelper.getBean(HeroService.class);
		hs.showName();
		
	}

}
