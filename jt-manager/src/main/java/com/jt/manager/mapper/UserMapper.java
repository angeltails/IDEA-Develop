package com.jt.manager.mapper;

import java.util.List;

import com.jt.manager.pojo.User;

public interface UserMapper {
	
	//查询用户信息
	List<User> findAll();
	
}
