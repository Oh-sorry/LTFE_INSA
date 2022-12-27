package com.mcst.gbn10.service;

import java.util.List;

import com.mcst.dto.gbn10.pg107000Dto;

public interface pg107000Service {

	public List<pg107000Dto> selectPg107000List(pg107000Dto pg107000Dto) throws Exception;

	public List<pg107000Dto> selectPg107000GbnJoinList(pg107000Dto pg107000Dto) throws Exception;

	public List<pg107000Dto> selectpg107000DtoYearList(pg107000Dto pg107000Dto) throws Exception;

	public List<pg107000Dto> selectpg107000DtoMonthList(pg107000Dto pg107000Dto) throws Exception;

	public List<pg107000Dto> excelDownload(pg107000Dto pg107000Dto) throws Exception;

}
