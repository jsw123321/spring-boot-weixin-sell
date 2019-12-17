/**  
 * 
 * @Title:  OrderMaster2OrderDTOConverter.java   
 * @Package com.amarsoft.springboot   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月15日 下午9:32:03   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */  
package com.amarsoft.springboot.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.amarsoft.springboot.dataobject.OrderMaster;
import com.amarsoft.springboot.dto.OrderDTO;

/**   
 * @ClassName:  OrderMaster2OrderDTOConverter   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiangshanwen
 * @date:   2019年12月15日 下午9:32:03     
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved. 
 * 
 */
public class OrderMaster2OrderDTOConverter {

	/**   
	 * @Title:  OrderMaster2OrderDTOConverter   
	 * @Description: (这里用一句话描述这个方法的作用)   
	 * @param:    
	 * @throws   
	 */
	public OrderMaster2OrderDTOConverter() {
		
	}
    
	public static OrderDTO convert(OrderMaster orderMaster){
		OrderDTO  orderDTO=new OrderDTO();
		BeanUtils.copyProperties(orderMaster, orderDTO);
		return orderDTO;
	}
	
	public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
		List<OrderDTO> orderDTOList = orderMasterList.stream().map(e->convert(e)).collect(Collectors.toList());
		return orderDTOList;
	}
}
