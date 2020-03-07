package com.yc.spirngboot.takeout.dao;

import com.yc.spirngboot.takeout.bean.Collect;
import com.yc.spirngboot.takeout.bean.CollectExample;
import com.yc.spirngboot.takeout.bean.Seller;

import java.util.List;
import org.apache.ibatis.annotations.*;


public interface CollectMapper {
	

    long countByExample(CollectExample example);

    int deleteByExample(CollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);

    List<Collect> selectByExample(CollectExample example);

    Collect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
}