package com.yc.spirngboot.takeout.dao;

import com.yc.spirngboot.takeout.bean.Myorder;
import com.yc.spirngboot.takeout.bean.MyorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyorderMapper {
    long countByExample(MyorderExample example);

    int deleteByExample(MyorderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Myorder record);

    int insertSelective(Myorder record);

    List<Myorder> selectByExample(MyorderExample example);

    Myorder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Myorder record, @Param("example") MyorderExample example);

    int updateByExample(@Param("record") Myorder record, @Param("example") MyorderExample example);

    int updateByPrimaryKeySelective(Myorder record);

    int updateByPrimaryKey(Myorder record);
}