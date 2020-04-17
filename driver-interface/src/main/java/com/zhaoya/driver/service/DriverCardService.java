package com.zhaoya.driver.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhaoya.driver.pojo.Area;
import com.zhaoya.driver.pojo.DriverCard;

public interface DriverCardService {

	// ��ȡ��һ������������б�
	List<Area> listByPid(int pid);

	// ��ѯ
	PageInfo<DriverCard> list(int page, String name);

	// ���
	int add(DriverCard driver);

	DriverCard getById(int id);

	// �޸�
	int update(DriverCard driver);

}
