package com.zhaoya.driver.pojo;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *  驾驶证
 * @author 45466
 *
 */
public class DriverCard implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1467468194900230737L;
	
	private String id             ;
	@NotEmpty
	private String cardNo        ;
   //@Length(min = 2 ,max=10 , message = "长度cong 2 dao 10 ")
	private String name           ;
	@Email
	private String gender         ;//性别
	
	@Size(max = 100 ,min=10,message = "sss")
	private String provinceId    ;//省id
	private String cityId        ;//市id
	private String countyId      ;//区id
	private String postDate      ;//
	private String createtime     ;
	private String headImage;
	
	private Area province; //省
	
	private Area city;//市
	
	private Area county;//县
	
	
	public Area getProvince() {
		return province;
	}
	public void setProvince(Area province) {
		this.province = province;
	}
	public Area getCity() {
		return city;
	}
	public void setCity(Area city) {
		this.city = city;
	}
	public Area getCounty() {
		return county;
	}
	public void setCounty(Area county) {
		this.county = county;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCountyId() {
		return countyId;
	}
	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	@Override
	public String toString() {
		return "DriverCard [id=" + id + ", cardNo=" + cardNo + ", name=" + name + ", gender=" + gender + ", provinceId="
				+ provinceId + ", cityId=" + cityId + ", countyId=" + countyId + ", postDate=" + postDate
				+ ", createtime=" + createtime + ", headImage=" + headImage + ", province=" + province + ", city="
				+ city + ", county=" + county + "]";
	}
	
	

}
