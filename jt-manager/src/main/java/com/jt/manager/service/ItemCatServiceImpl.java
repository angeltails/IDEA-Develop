package com.jt.manager.service;

import com.jt.common.po.Item;
import com.jt.common.po.ItemCat;
import com.jt.manager.mapper.ItemCatMapper;
import com.jt.manager.vo.EasyUITree;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {
@Autowired
private ItemCatMapper itemCatMapper;

    @Override
    public List<EasyUITree> findItemCatListById(Long parentId) {
        ItemCat itemCat = new ItemCat();
        itemCat.setParentId(parentId);
        List<ItemCat> itemCatList =itemCatMapper.select(itemCat);
        List<EasyUITree> treeList=new ArrayList<>();
        for (ItemCat itemCatTemp : itemCatList) {
            EasyUITree easyUITree = new EasyUITree();
            easyUITree.setId(itemCatTemp.getId());
            easyUITree.setText(itemCatTemp.getName());
            String status = itemCatTemp.getIsParent() ? "closed" : "open";
            easyUITree.setState(status);
            treeList.add(easyUITree);
        }

        return treeList;
    }
}
