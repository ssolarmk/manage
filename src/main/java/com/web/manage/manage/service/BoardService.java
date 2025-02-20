package com.web.manage.manage.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.manage.manage.domain.BoardVO;
import com.web.manage.manage.mapper.BoardMapper;

import jakarta.validation.Valid;


@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;

	public int getQueryTotalCnt() {
		return mapper.getQueryTotalCnt();
	}
	
	public int getParentTotalCnt(String aca_id) {
		return mapper.getParentTotalCnt(aca_id);
	}
	
	public List<HashMap<String, Object>> boardMstListRetrieve(HashMap<String, Object> hashmapParam) {
		return mapper.boardMstListRetrieve(hashmapParam);
	}
	
	public List<HashMap<String, Object>> getSelectBoardFileList(HashMap<String, Object> hashmapParam) {
		return mapper.getSelectBoardFileList(hashmapParam);
	}
	
	public int createBoardSeq() {
		return mapper.createBoardSeq();
	}
	
	public int getChkFileSeq(BoardVO vo) {
		return mapper.getChkFileSeq(vo);
	}
	
	public int generateFileSeq() {
		return mapper.generateFileSeq();
	}
	
	public int insertBoardFileInfo(BoardVO vo) {
		return mapper.insertBoardFileInfo(vo);
	}
	
	public int boardCreate(@Valid BoardVO boardVO) {
		// TODO Auto-generated method stub
		return mapper.boardCreate(boardVO);
	}

	public int boardUpdate(@Valid BoardVO boardVO) {
		// TODO Auto-generated method stub
		return mapper.boardUpdate(boardVO);
	}
}
