package com.imooc.utils;

import java.util.UUID;

//生成随机UUID
public  class UUIDUtils {

	public  static String getUUID()
	{ 
		
		//生成随机的32位UUID并返回
		return UUID.randomUUID().toString().replace("-", "");
	}
}
