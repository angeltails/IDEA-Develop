package com.jt.manager.controller;

import com.jt.manager.service.ItemCatService;
import com.jt.manager.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/cat/list")
    @ResponseBody
    public List<EasyUITree> findItemCatListById(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        return itemCatService.findItemCatListById(parentId);
    }
}
