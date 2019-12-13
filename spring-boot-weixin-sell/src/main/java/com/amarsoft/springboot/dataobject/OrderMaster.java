/** 
　 * Title: OrderMaster.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月12日
　 * @version 1.0 
*/

package com.amarsoft.springboot.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/**
 * @Title:
 * @Description: （对类进行功能描述）
 * @author jiangshanwen
 * @date: 2019年12月12日下午11:20:58 （日期）
 * @version:v.1.0
 */
@Entity
@DynamicUpdate
@Data
public class OrderMaster {
	
	/** 订单id. */
	@Id
	private String orderId;

	/** 买家名字. */
	private String buyerName;

	/** 买家电话. */
	private String buyerPhone;

	/** 买家地址. */
	private String buyerAddress;

	/** 买家微信openid. */
	private String buyerOpenid;

	/** 订单总金额. */
	private double orderAmount;

	/** 订单状态，默认为新下单. */
	private Integer orderStatus;

	/** 支付状态，默认未支付. */
	private Integer payStatus;

	/** 创建时间. */
	private Date createTime;

	/** 修改时间. */
	private Date updateTime;

	public OrderMaster() {

	}
	

}
