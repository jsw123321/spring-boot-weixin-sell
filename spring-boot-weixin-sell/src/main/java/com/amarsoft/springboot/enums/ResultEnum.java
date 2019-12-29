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
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存不正确"),
	ORDER_NOT_EXIST(12,"订单不存在"),
	ORDERDETAIL_NOT_EXIST(13,"订单详情不存在"),
	ORDER_STATUS_ERROR(14,"订单状态不正确"),
	ORDER_UPDATE_FAIL(15,"订单更新失败"), 
	ORDER_DETAIL_EMPTY(16,"订单详情为空"), 
	ORDER_PAY_STATUS_ERROR(17,"订单支付状态不正确"), 
	CART_EMPTY(18,"购物车为空"),
	ORDER_OWNER_ERROR(19,"订单不属于当前用户"), 
	WECHAT_MP_ERROR(20,"微信公众账号方面错误"), 
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
