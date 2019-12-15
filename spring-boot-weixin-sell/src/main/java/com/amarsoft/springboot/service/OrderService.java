/** 
　 * Title: OrderService.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月14日
　 * @version 1.0 
*/

package com.amarsoft.springboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.amarsoft.springboot.dataobject.OrderMaster;
import com.amarsoft.springboot.dto.OrderDTO;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月14日下午11:23:22 （日期） 
 * @version:v.1.0
 */
public interface OrderService {
       /**创建订单.*/
	   OrderDTO  create(OrderDTO orderDTO);
	   
       /**查询单个订单.*/
	   OrderDTO findOne(String orderId);
	   
	   /**查询订单列表.*/
	   Page<OrderDTO> findList(String buyerOpenid,Pageable  pageable);
	   
	   /**取消订单.*/
	   OrderDTO cancle(OrderDTO orderDTO);
	   
	   /**完结订单.*/
	   OrderDTO finished(OrderDTO orderDTO);
	   
	   /**支付订单.*/
	   OrderDTO payid(OrderDTO orderDTO);
}
