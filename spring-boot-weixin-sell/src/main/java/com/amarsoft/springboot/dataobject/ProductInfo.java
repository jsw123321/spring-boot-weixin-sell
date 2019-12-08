/** 
　 * Title: ProductInfo.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月8日
　 * @version 1.0 
*/

package com.amarsoft.springboot.dataobject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/** 
 * @Title: ProductInfo
 * @Description: 商品详情（对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月8日下午4:17:38 （日期） 
 * @version:v.1.0
 */
@Entity
@DynamicUpdate
@Data
public class ProductInfo {
    /**
     * 商品id
     */
	@Id
	private String productId;
	
	/**
	 *商品名称
	 */
	private String productName;
	
	/**
	 *单价
	 */
	private double productPrice;
	
	/**
	 *库存
	 */
	private int productStock;
	
	/**
	 *描述
	 */
	private String productDescription;
	
	/**
	 *小图
	 */
	private String productIcon;
	
	/**
	 * 商品状态,0正常1下架
	 */
	private int productStatus;
	
	/**
	 *类目编号
	 */
	private int categoryType;
	
	/**
	 *创建时间
	 */
	private Date createTime;
	
	/**
	 *修改时间
	 */
	private Date updateTime;
	
	
	public ProductInfo() {
	}


	/** 
	　 * <p>Title: </p> 
	　 * <p>Description: </p> 
	　 * @param productId
	　 * @param productName
	　 * @param productPrice
	　 * @param productStock
	　 * @param productDecription
	　 * @param productIcon
	　 * @param productStatus
	　 * @param categoryType
	　 * @param createTime
	　 * @param updateTime 
	*/
	
	public ProductInfo(String productId, String productName, double productPrice, int productStock,
			String productDescription, String productIcon, int productStatus, int categoryType, Date createTime,
			Date updateTime) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.productDescription = productDescription;
		this.productIcon = productIcon;
		this.productStatus = productStatus;
		this.categoryType = categoryType;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	
}
