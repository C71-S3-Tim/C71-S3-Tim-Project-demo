package com.yc.spirngboot.takeout.dao;

import com.yc.spirngboot.takeout.bean.Allotinf;
import com.yc.spirngboot.takeout.bean.AllotinfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AllotinfMapper {
    long countByExample(AllotinfExample example);

    int deleteByExample(AllotinfExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Allotinf record);

    int insertSelective(Allotinf record);

    List<Allotinf> selectByExample(AllotinfExample example);

    Allotinf selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Allotinf record, @Param("example") AllotinfExample example);

    int updateByExample(@Param("record") Allotinf record, @Param("example") AllotinfExample example);

    int updateByPrimaryKeySelective(Allotinf record);

    int updateByPrimaryKey(Allotinf record);
}