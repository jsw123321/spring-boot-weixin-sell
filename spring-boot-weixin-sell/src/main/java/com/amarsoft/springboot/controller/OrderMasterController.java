/**  
 * 
 * @Title:  OrderMasterController.java   
 * @Package com.amarsoft.springboot.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月14日 下午11:58:29   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */  
package com.amarsoft.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amarsoft.springboot.dataobject.OrderMaster;
import com.amarsoft.springboot.service.OrderService;

/**   
 * @ClassName:  OrderMasterController   
 * @Description:订单管理的控制器   
 * @author: jiangshanwen
 * @date:   2019年12月14日 下午11:58:29     
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved. 
 * 
 */
@RestController
@RequestMapping("/buyer/order")
public class OrderMasterController {

	@Autowired
	private OrderService  orderMasterService;
	
	@PostMapping("/create")
	public OrderMaster create(){
		
		return null;
	}
}
