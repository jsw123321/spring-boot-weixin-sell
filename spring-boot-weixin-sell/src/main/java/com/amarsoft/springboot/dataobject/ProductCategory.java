/** 
　 * Title: ProductCategory.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年11月29日上午12:18:50 
　 * @version 1.0 
*/

package com.amarsoft.springboot.dataobject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/** 
 * @Title: ProductCategory
 * @Description: 商品类目实体对象
 * @author jiangshanwen
 * @date: 2019年11月29日上午12:18:50 （日期） 
 * @version:v.1.0
 */
@Entity
//@DynamicUpdate
public class ProductCategory {
	
	/** 类目id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	
	/**类目名称.*/
	private String categoryName;
	
	/**类目编号.*/
	private Integer categoryType;
	
	private Date createTime;
	
	private Date updateTime;
	
	public ProductCategory() {
	}

	
	/**
	* @return the categoryId 
	*/
	
	public Integer getCategoryId() {
		return categoryId;
	}


	/**
	* @param categoryId the categoryId to set 
	*/
	
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	/**
	* @return the categoryName 
	*/
	
	public String getCategoryName() {
		return categoryName;
	}


	/**
	* @param categoryName the categoryName to set 
	*/
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	/**
	* @return the categoryType 
	*/
	
	public Integer getCategoryType() {
		return categoryType;
	}


	/**
	* @param categoryType the categoryType to set 
	*/
	
	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}


	

	/**
	* @return the createTime 
	*/
	
	public Date getCreateTime() {
		return createTime;
	}


	/**
	* @param createTime the createTime to set 
	*/
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	/**
	* @return the updateTime 
	*/
	
	public Date getUpdateTime() {
		return updateTime;
	}


	/**
	* @param updateTime the updateTime to set 
	*/
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public ProductCategory(String categoryName, Integer categoryType) {
		super();
		this.categoryName = categoryName;
		this.categoryType = categoryType;
	}

	

	@Override
	public String toString() {
		return "ProductCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryType="
				+ categoryType + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}



}
