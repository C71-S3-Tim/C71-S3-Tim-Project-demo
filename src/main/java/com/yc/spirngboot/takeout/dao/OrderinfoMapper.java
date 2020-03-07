package com.yc.spirngboot.takeout.dao;

import com.yc.spirngboot.takeout.bean.Orderinfo;
import com.yc.spirngboot.takeout.bean.OrderinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderinfoMapper {
    long countByExample(OrderinfoExample example);

    int deleteByExample(OrderinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Orderinfo record);

    int insertSelective(Orderinfo record);

    List<Orderinfo> selectByExample(OrderinfoExample example);

    Orderinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Orderinfo record, @Param("example") OrderinfoExample example);

    int updateByExample(@Param("record") Orderinfo record, @Param("example") OrderinfoExample example);

    int updateByPrimaryKeySelective(Orderinfo record);

    int updateByPrimaryKey(Orderinfo record);
}