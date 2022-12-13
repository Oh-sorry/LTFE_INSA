package com.mcst.gbn10.dao;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import com.mcst.dto.gbn10.pg104500Dto;

@Repository("pg104500Dao")
public class pg104500Dao extends EgovAbstractMapper{

	public List<pg104500Dto> selectPg104500GbnList(pg104500Dto pg104500Dto) {
		return selectList("pg104500Sql.selectPg104500GbnList", pg104500Dto);
	}

	public List<pg104500Dto> selectPg104500List(pg104500Dto pg104500Dto) {
		return selectList("pg104500Sql.selectPg104500List", pg104500Dto);
	}

}
