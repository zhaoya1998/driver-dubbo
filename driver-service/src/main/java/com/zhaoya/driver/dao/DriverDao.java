package com.zhaoya.driver.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhaoya.driver.pojo.Area;
import com.zhaoya.driver.pojo.DriverCard;

public interface DriverDao {

	List<Area> listAreadByPid(int pid);

	List<DriverCard> list(@Param("name")String name);

	int add(DriverCard driver);

	int update(DriverCard driver);

	DriverCard getByid(int id);

}
