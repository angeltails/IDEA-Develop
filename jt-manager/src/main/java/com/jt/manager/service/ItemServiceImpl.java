package com.jt.manager.service;

import com.jt.common.po.Item;
import com.jt.common.vo.EasyUIResult;
import com.jt.manager.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
@Autowired
private ItemMapper itemMapper;
    @Override
    public EasyUIResult findItemByPage(Integer page, Integer rows) {
        int total=itemMapper.findItemCount();
        int start=(page-1)*rows;
        List<Item>itemList=itemMapper.findItemByPage(start,rows);
        return new EasyUIResult(total,itemList);
    }

    @Override
    public String findItemCatNameById(String itemId) {
        return itemMapper.findItemCatNameById(itemId);
    }
}

