package com.mcst.gbn30.dao;
import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import com.mcst.dto.db.usr200tDto;
import com.mcst.dto.gbn30.pg301100Dto;

@Repository("pg301100Dao")
public class pg301100Dao extends EgovAbstractMapper {

    @SuppressWarnings("unchecked")

    public List<pg301100Dto> selectPg309501GbnList(pg301100Dto pg301100Dto) throws Exception {
    	return selectList("pg301100Sql.selectPg309501GbnList", pg301100Dto);
    }

    public List<pg301100Dto> selectPg301100List(pg301100Dto pg301100Dto) throws Exception {
    	return selectList("pg301100Sql.selectpg301100List", pg301100Dto);
    }

    public pg301100Dto selectPg309501GbnName(pg301100Dto pg301100Dto) throws Exception {
    	return selectOne("pg301100Sql.selectPg309501GbnName", pg301100Dto);
    }

    public pg301100Dto selectPg301100Info(pg301100Dto pg301100Dto) throws Exception {
    	return selectOne("pg301100Sql.selectpg301100Info", pg301100Dto);
    }

    public String selectpg301100MenuId(pg301100Dto pg301100Dto) throws Exception {
    	return selectOne("pg301100Sql.selectpg301100MenuId", pg301100Dto);
    }

    public int updatePg301100(usr200tDto usr200tDto) throws Exception {
    	return update("pg301100Sql.updatepg301100", usr200tDto);
    }

    public int deletePg301100(pg301100Dto pg301100Dto) throws Exception {
    	return delete("pg301100Sql.deletepg301100", pg301100Dto);
    }

}
