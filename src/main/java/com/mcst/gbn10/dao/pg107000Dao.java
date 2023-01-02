package com.mcst.gbn10.dao;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import com.mcst.dto.gbn10.pg107000Dto;

@Repository("pg107000Dao")
public class pg107000Dao extends EgovAbstractMapper {

	public List<pg107000Dto> selectPg107000List(pg107000Dto pg107000Dto) {
		return selectList("pg107000Sql.selectPg107000List", pg107000Dto);
	}

	public List<pg107000Dto> selectPg107000GbnJoinList(pg107000Dto pg107000Dto) {
		return selectList("pg107000Sql.selectPg107000GbnJoinList", pg107000Dto);
	}

	public List<pg107000Dto> selectpg107000DtoYearList(pg107000Dto pg107000Dto) {
		return selectList("pg107000Sql.selectpg107000DtoYearList", pg107000Dto);
	}

	public List<pg107000Dto> selectpg107000DtoMonthList(pg107000Dto pg107000Dto) {
		return selectList("pg107000Sql.selectpg107000DtoMonthList", pg107000Dto);
	}

	public List<pg107000Dto> excelDownload(pg107000Dto pg107000Dto) {
		return selectList("pg107000Sql.excelDownload", pg107000Dto);
	}

	public List<pg107000Dto> selectpg107000DtoJoinCount(pg107000Dto pg107000Dto) {
		return selectList("pg107000Sql.selectpg107000DtoJoinCount", pg107000Dto);
	}

	public List<pg107000Dto> selectpg107000DtoRetrCount(pg107000Dto pg107000Dto) {
		return selectList("pg107000Sql.selectpg107000DtoRetrCount", pg107000Dto);
	}

}
