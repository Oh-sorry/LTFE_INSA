package com.mcst.gbn10.dao;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import com.mcst.dto.db.hte100tDto;
import com.mcst.dto.gbn10.pg102000Dto;

@Repository("pg102000Dao")
public class pg102000Dao extends EgovAbstractMapper {

	public List<pg102000Dto> selectPg102000EduList(pg102000Dto pg102000Dto) throws Exception {
		return selectList("pg102000Sql.selectPg102000EduList", pg102000Dto);
	}

	public List<pg102000Dto> selectPg102000EduTypeList(pg102000Dto pg102000Dto) throws Exception {
		return selectList("pg102000Sql.selectPg102000EduTypeList", pg102000Dto);
	}

	public List<pg102000Dto> selectPg102000SearchList(pg102000Dto pg102000Dto) throws Exception {
		return selectList("pg102000Sql.selectPg102000SearchList", pg102000Dto);
	}

	public pg102000Dto selectPg102000Info(pg102000Dto pg102000Dto) throws Exception {
		return selectOne("pg102000Sql.selectPg102000Info", pg102000Dto);
	}
	
	public int selectPg102000Check(pg102000Dto pg102000Dto) throws Exception {
		return selectOne("pg102000Sql.selectPg102000Check", pg102000Dto);
	}

	public int updatePg102000(hte100tDto hte100tDto) throws Exception {
		return update("pg102000Sql.updatePg102000", hte100tDto);
	}

	public int deletePg102000(pg102000Dto pg102000Dto) throws Exception {
		return delete("pg102000Sql.deletePg102000", pg102000Dto);
	}
	
	public List<Map<String, Object>> excelList(pg102000Dto pg102000Dto) throws Exception {
		return selectList("pg102000Sql.excelList", pg102000Dto);
	}

	public int updateFilePg102000(hte100tDto hte100tDto) throws Exception {
		return update("pg102000Sql.updateFilePg102000", hte100tDto);
	}
}
