package com.jt.manager.service;

import com.jt.common.po.Item;
import com.jt.common.po.ItemDesc;
import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;


public interface ItemService {

    EasyUIResult findItemByPage(Integer page, Integer rows);

    String findItemCatNameById(Long itemId);

    void saveItem(Item item, String desc);

    ItemDesc findItemDescById(Long itemId);

    void updateStatus(String[] ids, int status);

    void updateItem(Item item, String desc);

    void deleteItem(String[] ids);
}
