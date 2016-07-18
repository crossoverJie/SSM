package com.crossoverJie.cxf.impl;

import com.crossoverJie.cxf.HelloWorld;

import javax.jws.WebService;


@WebService
public class HelloWorldImpl implements HelloWorld {

	public String say(String str) {
		return "Hello"+str;
	}

}
