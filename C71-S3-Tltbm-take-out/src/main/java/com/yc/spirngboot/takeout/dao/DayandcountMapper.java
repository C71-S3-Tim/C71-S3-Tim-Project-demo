package com.yc.spirngboot.takeout.dao;

import com.yc.spirngboot.takeout.bean.Dayandcount;
import com.yc.spirngboot.takeout.bean.DayandcountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DayandcountMapper {
    long countByExample(DayandcountExample example);

    int deleteByExample(DayandcountExample example);

    int insert(Dayandcount record);

    int insertSelective(Dayandcount record);

    List<Dayandcount> selectByExample(DayandcountExample example);

    int updateByExampleSelective(@Param("record") Dayandcount record, @Param("example") DayandcountExample example);

    int updateByExample(@Param("record") Dayandcount record, @Param("example") DayandcountExample example);
}