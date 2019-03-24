package com.jt.manager.factory;

import java.util.Calendar;

public class StaticFactory {
	
	//静态工厂必须有静态方法
	public static Calendar getIn(){
		
		return Calendar.getInstance();
	}
}
