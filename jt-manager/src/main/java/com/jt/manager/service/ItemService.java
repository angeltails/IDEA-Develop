package com.jt.manager.service;

import com.jt.common.po.Item;
import com.jt.common.vo.EasyUIResult;

public interface ItemService {
    EasyUIResult findItemByPage(Integer page, Integer rows);

    String findItemCatNameById(Long itemId);

    void saveItem(Item item);

    void updateItem(Item item);

    void updateStatus(String[] ids, int status);
}
