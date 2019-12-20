/**  
 * 
 * @Title:  BuyerOrderController.java   
 * @Package com.amarsoft.springboot.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月20日 下午9:44:24   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */  
package com.amarsoft.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amarsoft.springboot.VO.ResultVO;
import com.amarsoft.springboot.converters.OrderForm2OrderDTOConverter;
import com.amarsoft.springboot.dto.OrderDTO;
import com.amarsoft.springboot.enums.ResultEnum;
import com.amarsoft.springboot.exception.SellException;
import com.amarsoft.springboot.form.OrderForm;
import com.amarsoft.springboot.service.OrderService;
import com.amarsoft.springboot.utils.ResultVOUtil;

import lombok.extern.slf4j.Slf4j;

/**   
 * @ClassName:  BuyerOrderController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiangshanwen
 * @date:   2019年12月20日 下午9:44:24     
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved. 
 * 
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
      
	 @Autowired
	 private OrderService orderService;
	 
	 
	 //创建订单
	 @PostMapping("/create")
	 public ResultVO<Map<String,String>> create(@Valid  OrderForm orderForm,BindingResult bindingResult){
		 if(bindingResult.hasErrors()){
			 log.error("【创建订单】参数不正确,orderForm{}",orderForm);
			 throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
					 bindingResult.getFieldError().getDefaultMessage());
		 }
		 OrderDTO orderDTO=OrderForm2OrderDTOConverter.converter(orderForm);
		 if(null==orderDTO.getOrderDetailList()){
			 log.error("【创建订单】购物车不能为空");
			 throw new SellException(ResultEnum.CART_EMPTY);
		 }
		 OrderDTO createResult = orderService.create(orderDTO);
		 Map<String,String> map=new HashMap<String,String>();
		 map.put("orderId", createResult.getOrderId());
		 return ResultVOUtil.success(map);
	 }
	 
	 
	 //订单列表
	 
	 
	 //订单详情
	 
	 
	 //取消订单

}
