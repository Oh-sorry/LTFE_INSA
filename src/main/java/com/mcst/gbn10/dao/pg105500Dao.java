package com.mcst.gbn10.dao;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import com.mcst.dto.gbn10.pg105500Dto;

@Repository("pg105500Dao")
public class pg105500Dao extends EgovAbstractMapper {

	public List<pg105500Dto> selectPg105500List(pg105500Dto pg105500Dto) {
		return selectList("pg105500Sql.selectPg105500List", pg105500Dto);
	}

	public List<pg105500Dto> selectPg105500GbnList2(pg105500Dto pg105500Dto) {
		return selectList("pg105500Sql.selectPg105500GbnList2", pg105500Dto);
	}

	public List<pg105500Dto> selectPg105500GbnList3(pg105500Dto pg105500Dto) {
		return selectList("pg105500Sql.selectPg105500GbnList3", pg105500Dto);
	}
	
	public List<pg105500Dto> selectPg105500GbnList4(pg105500Dto pg105500Dto) {
		return selectList("pg105500Sql.selectPg105500GbnList4", pg105500Dto);
	}

	public List<pg105500Dto> selectPg105500DeptList1(pg105500Dto pg105500Dto) {
		return selectList("pg105500Sql.selectPg105500DeptList1", pg105500Dto);
	}

	public List<pg105500Dto> selectPg105500DeptList2(pg105500Dto pg105500Dto) {
		return selectList("pg105500Sql.selectPg105500DeptList2", pg105500Dto);
	}

	public List<pg105500Dto> excelDownload(pg105500Dto pg105500Dto) {
		return selectList("pg105500Sql.excelDownload", pg105500Dto);
	}


}
