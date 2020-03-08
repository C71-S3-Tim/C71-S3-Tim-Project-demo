package com.yc.spirngboot.takeout.dao;

import com.yc.spirngboot.takeout.bean.Giftorder;
import com.yc.spirngboot.takeout.bean.GiftorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GiftorderMapper {
    long countByExample(GiftorderExample example);

    int deleteByExample(GiftorderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Giftorder record);

    int insertSelective(Giftorder record);

    List<Giftorder> selectByExample(GiftorderExample example);

    Giftorder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Giftorder record, @Param("example") GiftorderExample example);

    int updateByExample(@Param("record") Giftorder record, @Param("example") GiftorderExample example);

    int updateByPrimaryKeySelective(Giftorder record);

    int updateByPrimaryKey(Giftorder record);
}