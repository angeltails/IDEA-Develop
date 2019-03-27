package com.jt.manager.mapper;

import com.jt.common.mapper.SysMapper;
import com.jt.common.po.Item;
import com.jt.common.vo.EasyUIResult;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemMapper extends SysMapper<Item> {

    List<Item> findItemByPage(@Param("start") Integer start, @Param("rows") Integer rows);


    String findItemCatNameById(@Param("id") Long itemId);

    void updateStatus(@Param("ids") String[] ids,@Param("status") int status);
}
