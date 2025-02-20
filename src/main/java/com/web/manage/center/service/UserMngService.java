package com.web.manage.center.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.manage.center.mapper.UserMngMapper;

@Service
public class UserMngService {

    @Autowired
    private UserMngMapper userMngMapper;

    public List<HashMap<String, Object>> userMngListRetrieve(HashMap<String, Object> hashmapParam) {
        return userMngMapper.userMngListRetrieve(hashmapParam);
    }


    public int getQueryTotalCnt() {
        return userMngMapper.getQueryTotalCnt();
    }


    public List<HashMap<String, Object>> getAcaList(HashMap<String, Object> hashmapParam) {
        return userMngMapper.getAcaList(hashmapParam);
    }


    public boolean userCreate(HashMap<String, Object> hashmapParam) {
        return userMngMapper.userCreate(hashmapParam);
    }


    public boolean userUpdate(HashMap<String, Object> hashmapParam) {
        return userMngMapper.userUpdate(hashmapParam);
    }
}
