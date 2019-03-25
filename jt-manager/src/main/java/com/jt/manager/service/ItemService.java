package com.jt.manager.service;

import com.jt.common.vo.EasyUIResult;

/**
 * @author FairyTail
 * @date 2019/3/25-11:23
 */
public interface ItemService {
    EasyUIResult findItemByPage(Integer page, Integer rows);
}
