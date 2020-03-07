package com.yc.spirngboot.takeout.dao;

import com.yc.spirngboot.takeout.bean.Sender;
import com.yc.spirngboot.takeout.bean.SenderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SenderMapper {
    long countByExample(SenderExample example);

    int deleteByExample(SenderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sender record);

    int insertSelective(Sender record);

    List<Sender> selectByExample(SenderExample example);

    Sender selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sender record, @Param("example") SenderExample example);

    int updateByExample(@Param("record") Sender record, @Param("example") SenderExample example);

    int updateByPrimaryKeySelective(Sender record);

    int updateByPrimaryKey(Sender record);
}