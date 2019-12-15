/** 
　 * Title: OrderDto.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月14日
　 * @version 1.0 
*/

package com.amarsoft.springboot.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import com.amarsoft.springboot.dataobject.OrderDetail;

import lombok.Data;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月14日下午11:30:48 （日期） 
 * @version:v.1.0
 */
@Data
public class OrderDTO {

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
	private BigDecimal orderAmount;

	/** 订单状态，默认为新下单. */
	private Integer orderStatus;

	/** 支付状态，默认未支付. */
	private Integer payStatus;

	/** 创建时间. */
	private Date createTime;

	/** 修改时间. */
	private Date updateTime;

	/**订单明细列表.*/
	private List<OrderDetail> orderDetailList;

}
