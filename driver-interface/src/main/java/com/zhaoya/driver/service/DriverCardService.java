package com.zhaoya.driver.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhaoya.driver.pojo.Area;
import com.zhaoya.driver.pojo.DriverCard;

public interface DriverCardService {

	// 获取下一个行政级别的列表
	List<Area> listByPid(int pid);

	// 查询
	PageInfo<DriverCard> list(int page, String name);

	// 添加
	int add(DriverCard driver);

	DriverCard getById(int id);

	// 修改
	int update(DriverCard driver);

}
