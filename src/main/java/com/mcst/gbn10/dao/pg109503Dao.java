package com.mcst.gbn10.dao;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import com.mcst.dto.gbn10.pg109503Dto;

@Repository("pg109503Dao")
public class pg109503Dao extends EgovAbstractMapper {

	public List<pg109503Dto> selectPg109503OrgList(pg109503Dto pg109503Dto) throws Exception {
		return selectList("pg109503Sql.selectPg109503OrgList", pg109503Dto);
	}

	public List<pg109503Dto> selectPg109503DeptList1(pg109503Dto pg109503Dto) throws Exception {
		return selectList("pg109503Sql.selectPg109503DeptList1", pg109503Dto);
	}

	public List<pg109503Dto> selectPg109503DeptList2(pg109503Dto pg109503Dto) throws Exception {
		return selectList("pg109503Sql.selectPg109503DeptList2", pg109503Dto);
	}

	public List<Map<String, Object>> excelList(pg109503Dto pg109503Dto) throws Exception {
		return selectList("pg109503Sql.excelList", pg109503Dto);
	}

}
