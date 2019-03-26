package com.jt.manager.controller;

import com.jt.common.vo.EasyUIResult;
import com.jt.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @RequestMapping("/query")
    @ResponseBody
    public EasyUIResult findItemByPage(Integer page,Integer rows){
        return itemService.findItemByPage(page,rows);
    }
    @RequestMapping(value = "/cat/queryItemName",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String findItemCatNameById(Long itemId){
        return itemService.findItemCatNameById(itemId);
    }
}
