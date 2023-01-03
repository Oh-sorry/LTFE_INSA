package com.mcst.gbn10.dao;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import com.mcst.dto.gbn10.pg103000Dto;

@Repository("pg103000Dao")
public class pg103000Dao extends EgovAbstractMapper {

	public List<pg103000Dto> selectPg103000List(pg103000Dto pg103000Dto) {
		return selectList("pg103000SQL.selectPg103000List", pg103000Dto);
	}

}
