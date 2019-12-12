/** 
　 * Title: OrderStatusEnum.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月12日
　 * @version 1.0 
*/

package com.amarsoft.springboot.enums;

import lombok.Getter;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月12日下午11:31:46 （日期） 
 * @version:v.1.0
 */

@Getter
public enum OrderStatusEnum {
	NEW(0,"新订单"),
	FINISHED(1,"完成"),
	CANCLE(2,"取消");
    private Integer code;
	private String message;
	
	private OrderStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
}
