package com.mcst.gbn10.service;

import java.util.List;

import com.mcst.dto.db.hzz140tDto;
import com.mcst.dto.gbn10.pg103000Dto;

public interface pg103000Service {

	public List<pg103000Dto> selectPg103000List(pg103000Dto pg103000Dto) throws Exception;

	public List<pg103000Dto> selectPg103000DetpList1(pg103000Dto pg103000Dto) throws Exception;

	public List<pg103000Dto> selectPg103000DetpList2(pg103000Dto pg103000Dto) throws Exception;

	public List<pg103000Dto> selectPg103000CertGbn(pg103000Dto pg103000Dto) throws Exception;

	public int pageListCnt(pg103000Dto pg103000Dto) throws Exception;

	public int selectPg103000Check(pg103000Dto pg103000Dto) throws Exception;

	public int updatePg103000(hzz140tDto hzz140tDto) throws Exception;

	public List<pg103000Dto> selectPg103000SearchList(pg103000Dto pg103000Dto) throws Exception;

}
