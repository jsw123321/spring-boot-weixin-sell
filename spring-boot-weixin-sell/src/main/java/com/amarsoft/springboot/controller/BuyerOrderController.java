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
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.mockito.internal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amarsoft.springboot.VO.ResultVO;
import com.amarsoft.springboot.converters.OrderForm2OrderDTOConverter;
import com.amarsoft.springboot.dto.OrderDTO;
import com.amarsoft.springboot.enums.ResultEnum;
import com.amarsoft.springboot.exception.SellException;
import com.amarsoft.springboot.form.OrderForm;
import com.amarsoft.springboot.service.BuyerService;
import com.amarsoft.springboot.service.OrderService;
import com.amarsoft.springboot.utils.ResultVOUtil;
import com.amarsoft.springboot.utils.serializer.Date2LongSerializer;

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
	 
	 @Autowired
	 private BuyerService buyerService;
	 
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
	 @GetMapping("/list")
	 public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
			                              @RequestParam("page") Integer page,
			                              @RequestParam("size") Integer size){
		 if(StringUtils.isEmpty(openid)){
			 log.error("【查询订单列表】用户openid为空！");
			 throw new SellException(ResultEnum.PARAM_ERROR);
		 }
		 PageRequest pageRequest=new PageRequest(page,size);
		 Page<OrderDTO> pageResult=orderService.findList(openid, pageRequest);
		 return ResultVOUtil.success(pageResult.getContent());
	 }
	 
	 
	 //订单详情
	 @GetMapping("/OrderDetail")
	 public ResultVO<Map<String,String>> getOrderDetail(@RequestParam("openId") String openid,
			               @RequestParam("orderId") String orderId){
		 //todo需要惊醒安全校验
		 OrderDTO findOrderOne = buyerService.findOrderOne(openid, orderId);
		 return ResultVOUtil.success(findOrderOne);
	 }
	 
	 //取消订单
	 @GetMapping("/cancle")
	 public ResultVO cancleOrder(@RequestParam("openid")String openid,@RequestParam("orderid")String orderId){
		 buyerService.cancleOrder(openid, orderId);
		 return  ResultVOUtil.success();
	 }

}
