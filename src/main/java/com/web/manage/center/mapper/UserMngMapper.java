package com.web.manage.center.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMngMapper {

    List<HashMap<String, Object>> userMngListRetrieve(HashMap<String, Object> hashmapParam);

    int getQueryTotalCnt();

    List<HashMap<String, Object>> getAcaList(HashMap<String, Object> hashmapParam);

    boolean userCreate(HashMap<String, Object> hashmapParam);

    boolean userUpdate(HashMap<String, Object> hashmapParam);
}

