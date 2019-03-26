package com.jt.manager.service;

import com.jt.common.po.Item;
import com.jt.common.vo.EasyUIResult;
import com.jt.manager.mapper.ItemMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Override
    public EasyUIResult findItemByPage(Integer page, Integer rows) {

        int total=itemMapper.findItemCount();
        int start=(page-1)*rows;
        List<Item> itemList=itemMapper.findItemByPage(start,rows);
        return new EasyUIResult(total,itemList);
    }

    @Override
    public String findItemCatNameById(Long itemId) {
        return itemMapper.findItemCatNameById(itemId);
    }

    @Override
    public void saveItem(Item item) {
        item.setStatus(1);
        item.setCreated(new Date());
        item.setUpdated(item.getCreated());
        itemMapper.insert(item);
    }

    @Override
    public void updateItem(Item item) {
        item.setUpdated(new Date());
        itemMapper.updateByPrimaryKeySelective(item);
    }

    @Override
    public void updateStatus(String[] ids, int status) {
        itemMapper.updateStatus(ids,status);
    }
}
