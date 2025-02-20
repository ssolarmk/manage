package com.web.manage.manage.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.manage.manage.domain.SchoolMstVO;

import jakarta.validation.Valid;


@Mapper
public interface SchoolMstMapper {
	
	int getQueryTotalCnt(HashMap<String, Object> hashmapParam);

	String getSchCdRetrieve();
	
	List<HashMap<String, Object>> getSchListRetrieve(HashMap<String, Object> hashmapParam);

	List<HashMap<String, Object>> getSchoolMstListRetrieve(HashMap<String, Object> hashmapParam);
	
	int schInfoCreate(@Valid SchoolMstVO schMstVO);

	int schInfoUpdate(@Valid SchoolMstVO schMstVO);
	
}