package com.zhaoya.driver.pojo;

import java.io.Serializable;

/**
 * 地区
 * @author 45466
 *
 */
public class Area  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8250754270874415937L;
	
	private Integer id;
	private int pid;//上级id
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Area [id=" + id + ", pid=" + pid + ", name=" + name + "]";
	}
	
}
