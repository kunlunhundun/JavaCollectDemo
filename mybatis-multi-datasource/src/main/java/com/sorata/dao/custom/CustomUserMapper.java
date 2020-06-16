package com.sorata.dao.custom;

import com.sorata.entity.custom.CustomUser;

public interface CustomUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomUser record);

    int insertSelective(CustomUser record);

    CustomUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomUser record);

    int updateByPrimaryKey(CustomUser record);
}