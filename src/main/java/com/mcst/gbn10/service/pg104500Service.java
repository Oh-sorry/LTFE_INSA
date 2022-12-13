package com.mcst.gbn10.service;

import java.util.List;

import com.mcst.dto.gbn10.pg104500Dto;

public interface pg104500Service {

	public List<pg104500Dto> selectPg104500GbnList(pg104500Dto pg104500Dto) throws Exception;

	public List<pg104500Dto> selectPg104500List(pg104500Dto pg104500Dto) throws Exception;

}
