package com.zhaoya.driver.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.zhaoya.driver.pojo.Area;
import com.zhaoya.driver.pojo.DriverCard;
import com.zhaoya.driver.service.DriverCardService;

@Controller
public class DriverController {
	
	private static Logger log = Logger.getLogger(DriverController.class);
	
	@Reference
	DriverCardService dcService;
	 
	@RequestMapping("list")
	public String list(HttpServletRequest request,String name,@RequestParam(defaultValue = "1")int PageNum) {
		PageInfo<DriverCard> info=dcService.list(PageNum,name);
		request.setAttribute("name", name);
		request.setAttribute("PageNum", PageNum);
		request.setAttribute("info", info);
		return "list";
	}
	@RequestMapping("listArea")
	@ResponseBody
	public List<Area> listArea(int pid){
		List<Area> list = dcService.listByPid(pid);
		return list;
	}
	
	@RequestMapping("toAdd")
	public String toAdd(HttpServletRequest request) {
		
		log.error(" to add stat .....");
		request.setAttribute("drivercard", new DriverCard()); 
		//获取所有的省的列表
		List<Area> list = dcService.listByPid(0);
		request.setAttribute("provinceList", list);
		
		
		return "add";
	}
	
	
	@RequestMapping("toUpdate")
	public String toUpdate(HttpServletRequest request,int id) {
		
		// 获取要修改的数据
		DriverCard driverCard = dcService.getById(id);
		
		request.setAttribute("drivercard", driverCard); 
		
		//获取所有的省的列表
		List<Area> list = dcService.listByPid(0);
		request.setAttribute("provinceList", list);
		
		return "update";
	}
	
	@RequestMapping("add")
	public String add(HttpServletRequest request,
			@Valid @ModelAttribute("drivercard") DriverCard drivercard,
			@RequestParam(value = "imagefile") MultipartFile imagefile,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "add";
		}
		
		// 图片上传
		try {
			String filePath = FileUtils.processFile(imagefile);
			drivercard.setHeadImage(filePath);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int addRe = dcService.add(drivercard);
		
		return addRe>0? "redirect:list":"add";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request,
			@Valid @ModelAttribute("drivercard") DriverCard drivercard,
			@RequestParam(value = "imagefile") MultipartFile imagefile,
			BindingResult result
			) {
		
		int addRe = dcService.update(drivercard);
		return addRe>0? "redirect:list":"update";
	}
}
