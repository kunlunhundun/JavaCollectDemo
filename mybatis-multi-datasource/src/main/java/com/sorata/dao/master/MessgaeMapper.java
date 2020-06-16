package com.sorata.dao.master;

import com.sorata.entity.master.Messgae;

public interface MessgaeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Messgae record);

    int insertSelective(Messgae record);

    Messgae selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Messgae record);

    int updateByPrimaryKey(Messgae record);
}