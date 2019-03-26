package com.jt.manager.mapper;

import com.jt.common.po.Item;
import com.jt.common.vo.EasyUIResult;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemMapper {
    @Select("select count(*) from tb_item")
    int findItemCount();

    List<Item> findItemByPage(@Param("start") int start, @Param("rows") Integer rows);
    @Select("select name from tb_item_cat where id=#{itemId} ")
    String findItemCatNameById(Long itemId);
}
