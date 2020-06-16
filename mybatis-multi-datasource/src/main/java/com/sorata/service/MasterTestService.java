package com.sorata.service;

import com.sorata.dao.master.MessgaeMapper;
import com.sorata.entity.master.Messgae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by :  Sorata   2017/6/26 0026 下午 1:59.
 */
@Service
public class MasterTestService {

    @Autowired
    private MessgaeMapper messgaeMapper;


    public Messgae getM(Integer id){
        return messgaeMapper.selectByPrimaryKey(id);
    }

    public int instet(){
        Messgae messgae = new Messgae();
        messgae.setAge(35);
        messgae.setName("王五");
        messgae.setSex("男");
        return messgaeMapper.insertSelective(messgae);
    }


}
