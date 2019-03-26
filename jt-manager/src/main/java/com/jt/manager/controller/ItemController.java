package com.jt.manager.controller;

import com.jt.common.po.Item;
import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import com.jt.manager.service.ItemService;
import jdk.net.SocketFlow;
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
    @RequestMapping("/save")
    @ResponseBody
    public SysResult saveItem(Item item){


        try {
            itemService.saveItem(item);
            return SysResult.oK();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SysResult.build(201,"新增商品失败");
    }
    @RequestMapping("/update")
    @ResponseBody
    public SysResult updateItem(Item item){


        try {
            itemService.updateItem(item);
            return SysResult.oK();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SysResult.build(201,"新增商品失败");
    }

    /**
     *下架操作
     * $.post("/item/instock",params, function(data)
     */
    @RequestMapping("/instock")
    @ResponseBody
    public SysResult instock(String[]ids){

        try {
            int status=2;
            itemService.updateStatus(ids, status);
            return SysResult.oK();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SysResult.build(201,"商品下架失败");
    }

}
