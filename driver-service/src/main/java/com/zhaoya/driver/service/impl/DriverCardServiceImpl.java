package com.zhaoya.driver.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaoya.driver.dao.DriverDao;
import com.zhaoya.driver.pojo.Area;
import com.zhaoya.driver.pojo.DriverCard;
import com.zhaoya.driver.service.DriverCardService;

@Service(interfaceClass = DriverCardService.class)
public class DriverCardServiceImpl  implements DriverCardService{
	
	@Autowired
	DriverDao driverDao;

	@Override
	public List<Area> listByPid(int pid) {
		// TODO Auto-generated method stub
		return driverDao.listAreadByPid(pid);
	}


	@Override
	public int add(DriverCard driver) {
		// TODO Auto-generated method stub
		return driverDao.add(driver);
	}

	@Override
	public int update(DriverCard driver) {
		// TODO Auto-generated method stub
		return driverDao.update(driver);
	}

	@Override
	public DriverCard getById(int id) {
		// TODO Auto-generated method stub
		return driverDao.getByid(id);
	}


	@Override
	public PageInfo<DriverCard> list(int pageNum, String name) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 3);
        List<DriverCard> list=driverDao.list(name);
		PageInfo<DriverCard> info=new PageInfo<DriverCard>(list);
		return info;
	}

}
