package com.jt.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	//跳转到首页
	@RequestMapping("/index")
	public String index(){
		
		return "index";
	}
	
	
	/**
	 * /page/item-add
	 * /page/item-list
	 * /page/item-param-list
	 * @return
	 * 
	 * RESTFul结构
	 * 格式特点:
	 * 	1.在url中将需要提交的参数使用"/"进行分割
	 * 		localhost:8091/addUser/1/tom
	 *  2.在接收端,将参数使用{}包裹并且参数的位置固定.
	 *  3.变量的名称必须和{}中的名称一致,之后通过@PathVariable
	 *    实现数据的传递.
	 *  
	 *  功能:
	 *  	1.实现了通用页面的跳转问题.
	 *  	2.减少了代码传递的字节数.
	 */
	/*@RequestMapping("/page/{id}/{name}")
	public String item_add(
			@PathVariable Integer id,
			@PathVariable String name){
		
		return XXX;
	}*/
	
	@RequestMapping("/page/{moduleName}")
	public String module(@PathVariable String moduleName){
		
		return moduleName;
	}
	
	
	
	
	
}
