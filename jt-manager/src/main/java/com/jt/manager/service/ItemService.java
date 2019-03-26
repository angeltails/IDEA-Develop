package com.jt.manager.service;

import com.jt.common.vo.EasyUIResult;

public interface ItemService {
    EasyUIResult findItemByPage(Integer page, Integer rows);

    String findItemCatNameById(Long itemId);
}
