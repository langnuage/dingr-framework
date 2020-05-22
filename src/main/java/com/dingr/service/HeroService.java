package com.dingr.service;


import com.yz.framework.annotation.Inject;
import com.yz.framework.annotation.Service;

@Service
public class HeroService {
	
	@Inject
	private Hero hero;
	
	public void showName() {
		System.out.println(hero.name);
	}

}
