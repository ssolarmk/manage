package com.web.manage.manage.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.web.manage.manage.domain.PermissionVO;


@Mapper
public interface PermissionMapper {

	ArrayList<HashMap<String, Object>> siteListMenu1(HashMap<String, Object> hashmapParam);

	void permissionDelete(PermissionVO permissionVO);

	int permissionInsert(PermissionVO input_permissionVO);

}
