package com.dai.mozi.admin.mapper;

import com.dai.mozi.admin.po.Cash;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CashDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(Cash record);

    int insertSelective(Cash record);

    Cash selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cash record);

    int updateByPrimaryKey(Cash record);
}