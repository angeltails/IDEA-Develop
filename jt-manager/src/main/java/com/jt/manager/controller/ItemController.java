package com.jt.manager.controller;

import com.jt.common.po.Item;
import com.jt.common.po.ItemDesc;
import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import com.jt.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/query")
    @ResponseBody
    public EasyUIResult findItemByPage(Integer page, Integer rows) {
        return itemService.findItemByPage(page, rows);
    }

    @RequestMapping(value = "/cat/queryItemName", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String findItemCatNameById(Long itemId) {
        return itemService.findItemCatNameById(itemId);
    }

    @RequestMapping("/save")
    @ResponseBody
    public SysResult saveItem(Item item, String desc) {

        try {
            itemService.saveItem(item, desc);
            return SysResult.oK();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SysResult.build(201, "商品新增失败");
    }

    @RequestMapping("/query/item/desc/{itemId}")
    @ResponseBody
    public SysResult findItemDescById(@PathVariable Long itemId) {

        try {
            ItemDesc itemDesc = itemService.findItemDescById(itemId);
            return SysResult.oK(itemDesc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SysResult.build(201, "商品详情查询失败");
    }

    /**
     * 商品上架操作
     *
     * @param ids
     * @return
     */
    @RequestMapping("/reshelf")
    @ResponseBody
    public SysResult reshelf(String[] ids) {

        try {
            int status = 1;
            itemService.updateStatus(ids, status);
            return SysResult.oK();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SysResult.build(201, "商品上架失败");

    }

    @RequestMapping("/instock")
    @ResponseBody
    public SysResult instock(String[] ids) {

        try {
            int status = 2;
            itemService.updateStatus(ids, status);
            return SysResult.oK();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SysResult.build(201, "商品上架失败");

    }

    @RequestMapping("/update")
    @ResponseBody
    public SysResult updateItem(Item item ,String desc) {

        try {
            itemService.updateItem(item,desc);
            return SysResult.oK();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SysResult.build(201, "商品更新失败");
    }
    @RequestMapping("/delete")
    @ResponseBody
    public SysResult deleteItem(String []ids) {

        try {
            itemService.deleteItem(ids);
            return SysResult.oK();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SysResult.build(201, "商品删除失败");
    }
}
