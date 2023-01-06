package com.mcst.gbn10.dao;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import com.mcst.dto.gbn10.pg101000Dto;

@Repository("pg101000Dao")
public class pg101000Dao extends EgovAbstractMapper {

	public pg101000Dto selectPg101000PernInfo(pg101000Dto pg101000Dto) throws Exception {
		return selectOne("pg101000Sql.selectPg101000PernInfo", pg101000Dto);
	}
	
	public List<pg101000Dto> selectPg101000SearchList(pg101000Dto pg101000Dto) throws Exception {
		return selectList("pg101000Sql.selectPg101000SearchList", pg101000Dto);
	}

	

}
