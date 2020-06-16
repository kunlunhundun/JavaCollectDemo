package com.sorata.service;

import com.sorata.dao.custom.CustomUserMapper;
import com.sorata.entity.custom.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by :  Sorata   2017/6/26 0026 下午 1:59.
 */
@Service
public class CustomTestService {

    @Autowired
    private CustomUserMapper customUserMapper;


    public CustomUser getM(Integer id){
        return customUserMapper.selectByPrimaryKey(id);
    }


    public int instet(){
        CustomUser customUser = new CustomUser();
        customUser.setAge(36);
        customUser.setName("赵六");
        customUser.setSex("男");
        return customUserMapper.insertSelective(customUser);
    }
}
