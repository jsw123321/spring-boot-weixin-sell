/**  
 * 
 * @Title:  ResultEnum.java   
 * @Package com.amarsoft.springboot.enums   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月15日 下午1:11:18   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */  
package com.amarsoft.springboot.enums;

import lombok.Getter;

/**   
 * @ClassName:  ResultEnum   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiangshanwen
 * @date:   2019年12月15日 下午1:11:18     
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved. 
 * 
 */
@Getter
public enum ResultEnum {
	
	
	PARAM_ERROR(1,"参数不正确"),
	ORDER_CONVERT_ERROR(2,"对象转换错误"),
	CART_EMPTY(2,"购物车为空"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品已售罄"),
	ORDER_MASTER_ERROR(12,"订单不存在"),
	ORDER_DETAIL_ERROR(13,"订单详情为空"),
	ORDER_STATUS_ERROR(13,"订单状态不正确"),
	ORDER_UPDATE_FAIL(14,"更新订单失败"), 
	;
	
	private Integer code;
	
	private String message;
	
	/**   
	 * @Title:  ResultEnum   
	 * @Description:结果枚举类有参构造方法   
	 * @param:   code
	 * @param:  message  
	 * @throws   
	 */  
	private ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
}
