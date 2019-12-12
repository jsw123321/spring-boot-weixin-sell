/** 
　 * Title: PayStatusEnum.java 
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
 * @date: 2019年12月12日下午11:45:12 （日期）
 * @version:v.1.0
 */
@Getter
public enum PayStatusEnum {
	NOTPAY(0, "未支付"), PAY(1, "已支付");
	private Integer code;
	private String message;

	private PayStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

}
