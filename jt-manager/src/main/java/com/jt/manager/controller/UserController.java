package com.jt.manager.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.manager.pojo.User;
import com.jt.manager.service.UserService;

@Controller
public class UserController {
	@Autowired
    private UserService userService;
	@RequestMapping("/findAll")
    public String findAll(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        return "userList";
    }

}
