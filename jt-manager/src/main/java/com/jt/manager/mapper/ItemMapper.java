package com.jt.manager.mapper;

import com.jt.common.po.Item;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author FairyTail
 * @date 2019/3/25-11:23
 */
public interface ItemMapper{
    @Select("select count(*) from tb_item")
    int findItemCount();
    List<Item> findItemByPage(@Param("start") Integer start,@Param("rows") Integer rows);
    @Select("select name from tb_item_cat where id=#{itemId}")
    String findItemCatNameById(String itemId);
}
