package com.mcst.gbn30.dao;
import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import com.mcst.dto.db.usr200tDto;
import com.mcst.dto.gbn30.pg309501Dto;

@Repository("pg309501Dao")
public class pg309501Dao extends EgovAbstractMapper {

    @SuppressWarnings("unchecked")

    public List<pg309501Dto> selectPg309501List(pg309501Dto pg309501Dto) throws Exception {
    	return selectList("pg309501Sql.selectPg309501List", pg309501Dto);
    }

    public pg309501Dto selectPg309501Info(pg309501Dto pg309501Dto) throws Exception {
    	return selectOne("pg309501Sql.selectPg309501Info", pg309501Dto);
    }

    public int selectPg309501Check(pg309501Dto pg309501Dto) throws Exception {
    	return selectOne("pg309501Sql.selectPg309501Check", pg309501Dto);
    }

    public int updatePg309501(usr200tDto usr200tDto) throws Exception {
    	return update("pg309501Sql.updatePg309501", usr200tDto);
    }

    public int selectPg309501DelCheck(pg309501Dto pg309501Dto) throws Exception {
    	return selectOne("pg309501Sql.selectPg309501DelCheck", pg309501Dto);
    }

    public int deletePg309501(pg309501Dto pg309501Dto) throws Exception {
    	return delete("pg309501Sql.deletePg309501", pg309501Dto);
    }

}
