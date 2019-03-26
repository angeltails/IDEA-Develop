package com.jt.manager.service;

import com.jt.manager.vo.EasyUITree;

import java.util.List;

public interface ItemCatService {

    List<EasyUITree> findItemCatListById(Long parentId);
}
