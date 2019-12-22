/**  
 * 
 * @Title:  BuyerServiceImpl.java   
 * @Package com.amarsoft.springboot.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月22日 下午1:43:34   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */
package com.amarsoft.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amarsoft.springboot.VO.ResultVO;
import com.amarsoft.springboot.dto.OrderDTO;
import com.amarsoft.springboot.enums.ResultEnum;
import com.amarsoft.springboot.exception.SellException;
import com.amarsoft.springboot.service.BuyerService;
import com.amarsoft.springboot.service.OrderService;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;

/**
 * @ClassName: BuyerServiceImpl
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: jiangshanwen
 * @date: 2019年12月22日 下午1:43:34
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved.
 * 
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	private OrderService orderService;

	/**
	 * @Title: findOrderOne
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param openid
	 * @param orderId
	 * @return
	 * @author jiangshanwen
	 * @date 2019年12月22日 下午1:43:56
	 * @throws @see
	 *             com.amarsoft.springboot.service.BuyerService#findOrderOne(
	 *             java.lang.String, java.lang.String)
	 */
	@Override
	public OrderDTO findOrderOne(String openid, String orderId) {
		return   checkOrderOwnerRight(openid, orderId);
	}

	/**
	 * @Title: cancleOrder
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param openid
	 * @param orderId
	 * @return OrderDTO
	 * @author jiangshanwen
	 * @date 2019年12月22日 下午2:50:48
	 * @throws @see
	 *             com.amarsoft.springboot.service.BuyerService#cancleOrder(java
	 *             .lang.String, java.lang.String)
	 */
	@Override
	public OrderDTO cancleOrder(String openId, String orderId) {
		OrderDTO orderDTO = checkOrderOwnerRight(openId,orderId);
		if(null==orderDTO){
			log.error("【取消订单】订单不存在,orderId={}",orderId);
			throw new SellException(ResultEnum.ORDER_NOT_EXIST);
		}
		return orderService.cancle(orderDTO);
	}

	/**
	 * @Title: cancle
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param openId
	 * @param orderId
	 * @author jiangshanwen
	 * @date 2019年12月22日 下午1:43:56
	 * @throws @see
	 * com.amarsoft.springboot.service.BuyerService#cancle(java.lang.String, java.lang.String)
	 */
	public OrderDTO checkOrderOwnerRight(String openId, String orderId) {
		// 根据orderId来查询orderDTO
		OrderDTO orderDTO = orderService.findOne(orderId);
		if (orderDTO == null) {
			return null;
		}
		if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openId)) {
			log.error("【查询订单】订单openid不一致：openid={},orderDTO={}", openId, orderDTO);
			throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
		}
		return orderDTO;
	}
}
