package com.jt.manager.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.manager.pojo.User;
import com.jt.manager.service.UserService;

@Controller
public class UserController<HttpServletRequest> {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/findAll")
	//@ResponseBody  //将对象最终转化为JSON
	public String findAll(Model model){
		List<User> userList = 
				userService.findAll();
		//将数据传递到页面中 将数据保存到request域中
		model.addAttribute("userList", userList);
		//返回的页面的名称
		
		return "userList";
	}
}
