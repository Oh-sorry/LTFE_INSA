package com.mcst.gbn10.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;


import com.mcst.gbn10.service.pg102000Service;
import com.mcst.dto.db.hte100tDto;
import com.mcst.dto.gbn10.pg102000Dto;
import com.mcst.gbn10.dao.pg102000Dao;

@Service("pg102000Service")
public class pg102000ServiceImpl extends EgovAbstractServiceImpl implements pg102000Service {

	@Resource(name = "pg102000Dao")
    private pg102000Dao pg102000Dao;

	public List<pg102000Dto> selectPg102000EduList(pg102000Dto pg102000Dto) throws Exception {
		return pg102000Dao.selectPg102000EduList(pg102000Dto);
	}

	public List<pg102000Dto> selectPg102000EduTypeList(pg102000Dto pg102000Dto) throws Exception {
		return pg102000Dao.selectPg102000EduTypeList(pg102000Dto);
	}

	public List<pg102000Dto> selectPg102000SearchList(pg102000Dto pg102000Dto) throws Exception {
		return pg102000Dao.selectPg102000SearchList(pg102000Dto);
	}

	public pg102000Dto selectPg102000Info(pg102000Dto pg102000Dto) throws Exception {
		return pg102000Dao.selectPg102000Info(pg102000Dto);
	}
	
	public int selectPg102000Check(pg102000Dto pg102000Dto) throws Exception {
		return pg102000Dao.selectPg102000Check(pg102000Dto);
	}

	public int updatePg102000(hte100tDto hte100tDto) throws Exception {
		return pg102000Dao.updatePg102000(hte100tDto);
	}

	public int deletePg102000(pg102000Dto pg102000Dto) throws Exception {
		return pg102000Dao.deletePg102000(pg102000Dto);
	}
	
	public List<Map<String, Object>> excelList(pg102000Dto pg102000Dto) throws Exception {
		return pg102000Dao.excelList(pg102000Dto);
	}

	public int updateFilePg102000(hte100tDto hte100tDto) throws Exception {
		return pg102000Dao.updateFilePg102000(hte100tDto);
	}
}
