/**  
 * 
 * @Title:  OrderForm2OrderDTOConverter.java   
 * @Package com.amarsoft.springboot.converters   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月20日 下午10:50:51   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */
package com.amarsoft.springboot.converters;

import java.util.ArrayList;
import java.util.List;

import com.amarsoft.springboot.dataobject.OrderDetail;
import com.amarsoft.springboot.dto.OrderDTO;
import com.amarsoft.springboot.enums.ResultEnum;
import com.amarsoft.springboot.exception.SellException;
import com.amarsoft.springboot.form.OrderForm;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: OrderForm2OrderDTOConverter
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: jiangshanwen
 * @date: 2019年12月20日 下午10:50:51
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved.
 * 
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

	/**
	 * 
	 * @Title: OrderForm2OrderDTOConverter @Description:
	 * 将OrderForm对象转化为OrderDTO @param orderform @return OrderDTO @author
	 * jiangshanwen @date 2019年12月20日 下午10:59:35 @throws
	 */
	public static OrderDTO converter(OrderForm orderform) {
		Gson gson = new Gson();
		OrderDTO orderDto = new OrderDTO();
		orderDto.setBuyerName(orderform.getName());
		orderDto.setBuyerPhone(orderform.getPhone());
		orderDto.setBuyerAddress(orderform.getAddress());
		orderDto.setBuyerOpenid(orderform.getOpenid());
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		try {
			orderDetailList = gson.fromJson(orderform.getItems(), new TypeToken<List<OrderDetail>>() {
			}.getType());
		} catch (Exception e) {
			log.error("【对象转换】错误：String={}", orderform.getItems());
			throw new SellException(ResultEnum.ORDER_CONVERT_ERROR);
		}
		orderDto.setOrderDetailList(orderDetailList);
		return orderDto;
	}

}
