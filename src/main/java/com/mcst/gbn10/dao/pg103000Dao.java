package com.mcst.gbn10.dao;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import com.mcst.dto.db.hzz140tDto;
import com.mcst.dto.gbn10.pg103000Dto;

@Repository("pg103000Dao")
public class pg103000Dao extends EgovAbstractMapper {

	public List<pg103000Dto> selectPg103000List(pg103000Dto pg103000Dto) {
		return selectList("pg103000SQL.selectPg103000List", pg103000Dto);
	}

	public List<pg103000Dto> selectPg103000DetpList1(pg103000Dto pg103000Dto) {
		return selectList("pg103000SQL.selectPg103000DeptList1", pg103000Dto);
	}

	public List<pg103000Dto> selectPg103000DetpList2(pg103000Dto pg103000Dto) {
		return selectList("pg103000SQL.selectPg103000DeptList2", pg103000Dto);
	}

	public List<pg103000Dto> selectPg103000CertGbn(pg103000Dto pg103000Dto) {
		return selectList("pg103000SQL.selectPg103000CertGbn", pg103000Dto);
	}

	public int pageListCnt(pg103000Dto pg103000Dto) {
		return selectOne("pg103000SQL.pageListCnt", pg103000Dto);
	}

	public int selectPg103000Check(pg103000Dto pg103000Dto) {
		return selectOne("pg103000SQL.selectPg103000Check", pg103000Dto);
	}

	public int updatePg103000(hzz140tDto hzz140tDto) {
		return update("pg103000SQL.updatePg103000", hzz140tDto);
	}

	public List<pg103000Dto> selectPg103000SearchList(pg103000Dto pg103000Dto) {
		return selectList("pg103000SQL.selectPg103000SearchList", pg103000Dto);
	}

	public pg103000Dto selectPg103000Info(pg103000Dto pg103000Dto) {
		return selectOne("pg103000SQL.selectPg103000Info", pg103000Dto);
	}

	public int deletePg103000(pg103000Dto pg103000Dto) {
		return delete("pg103000SQL.deletePg103000", pg103000Dto);
	}
}
