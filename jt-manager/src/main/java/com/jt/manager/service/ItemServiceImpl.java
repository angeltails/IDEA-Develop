package com.jt.manager.service;

import com.jt.common.po.Item;
import com.jt.common.po.ItemDesc;
import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import com.jt.manager.mapper.ItemDescMapper;
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
    @Autowired
    private ItemDescMapper itemDescMappe;

    @Override
    public EasyUIResult findItemByPage(Integer page, Integer rows) {
        int total = itemMapper.selectCount(null);
        int start = (page - 1) * rows;
        List<Item> itemList = itemMapper.findItemByPage(start, rows);
        return new EasyUIResult(total, itemList);
    }

    @Override
    public String findItemCatNameById(Long itemId) {

        return itemMapper.findItemCatNameById(itemId);
    }

    @Override
    public void saveItem(Item item, String desc) {
        item.setStatus(1);
        item.setCreated(new Date());
        item.setUpdated(item.getCreated());
        itemMapper.insert(item);
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(item.getCreated());
        itemDesc.setUpdated(item.getCreated());
        itemDescMappe.insert(itemDesc);
    }

    @Override
    public ItemDesc findItemDescById(Long itemId) {
        return itemDescMappe.selectByPrimaryKey(itemId);
    }

    @Override
    public void updateStatus(String[] ids, int status) {
       itemMapper.updateStatus(ids,status);
    }

    @Override
    public void updateItem(Item item, String desc) {
        item.setUpdated(new Date());
        itemMapper.updateByPrimaryKeySelective(item);
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);
        itemDesc.setUpdated(item.getUpdated());
        itemDescMappe.updateByPrimaryKeySelective(itemDesc);
    }

    @Override
    public void deleteItem(String[] ids) {
        itemDescMappe.deleteByIDS(ids);
        itemMapper.deleteByIDS(ids);
    }
}
