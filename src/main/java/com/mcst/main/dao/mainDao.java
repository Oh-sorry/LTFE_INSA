package com.mcst.main.dao;
import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import com.mcst.dto.loginDto;
import com.mcst.dto.loginMenuAuthDto;
import com.mcst.dto.nameSearchDto;

@Repository("mainDao")
public class mainDao extends EgovAbstractMapper {

    @SuppressWarnings("unchecked")
    public loginDto selectLoginInfo(loginDto loginDto) throws Exception {
    	return selectOne("mainSql.selectLoginInfo", loginDto);
    }

    public int selectLoginChk(loginDto loginDto) throws Exception {
    	return selectOne("mainSql.selectLoginChk", loginDto);
    }

    public List<loginMenuAuthDto> selectMenuAuth(loginDto loginDto) throws Exception {
    	return selectList("mainSql.selectMenuAuth", loginDto);
    }

}
