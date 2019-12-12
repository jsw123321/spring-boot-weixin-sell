/** 
　 * Title: OrderDetail.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月13日
　 * @version 1.0 
*/

package com.amarsoft.springboot.dataobject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月13日上午12:00:53 （日期） 
 * @version:v.1.0
 */
@Entity
@Data
public class OrderDetail {
	
    /**订单明细详情id.*/
	@Id
	private String detailId;
	
	/**订单id.*/
	private String orderId;
	
	/**商品id.*/
	private String productId;
	
	/**商品名称.*/
	private String productName;
	
	/**当前价格，单位分.*/
	private double productPrice;
	
	/**数量.*/
	private int productQuantity;
	
	/**小图.*/
	private String productIcon;
	
	/**创建时间.*/
	private Date createTime;
	
	/**修改时间.*/
	private Date updateTime;
	
	public OrderDetail() {
	}

}
