package com.jt.manager.mapper;

import com.jt.common.po.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author FairyTail
 * @date 2019/3/25-11:23
 */
public interface ItemMapper {
    public int findItemCount();

    List<Item> findItemByPage(@Param("start") Integer start, @Param("rows") Integer rows);
}
