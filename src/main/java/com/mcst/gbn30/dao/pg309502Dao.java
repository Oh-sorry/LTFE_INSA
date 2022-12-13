package com.mcst.gbn30.dao;
import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import com.mcst.dto.db.usr200tDto;
import com.mcst.dto.gbn30.pg309502Dto;

@Repository("pg309502Dao")
public class pg309502Dao extends EgovAbstractMapper {

    @SuppressWarnings("unchecked")

    public List<pg309502Dto> selectPg309502List(pg309502Dto pg309502Dto) throws Exception {
    	return selectList("pg309502Sql.selectPg309502List", pg309502Dto);
    }

    public List<pg309502Dto> selectPg309502Info(pg309502Dto pg309502Dto) throws Exception {
    	return selectList("pg309502Sql.selectPg309502Info", pg309502Dto);
    }

    public int selectPg309502Check(pg309502Dto pg309502Dto) throws Exception {
    	return selectOne("pg309502Sql.selectPg309502Check", pg309502Dto);
    }

    public int updatePg309502(usr200tDto usr200tDto) throws Exception {
    	return update("pg309502Sql.updatePg309502", usr200tDto);
    }

    public int selectPg309502DelCheck(pg309502Dto pg309502Dto) throws Exception {
    	return selectOne("pg309502Sql.selectPg309502DelCheck", pg309502Dto);
    }

    public int deletePg309502(pg309502Dto pg309502Dto) throws Exception {
    	return delete("pg309502Sql.deletePg309502", pg309502Dto);
    }

}
