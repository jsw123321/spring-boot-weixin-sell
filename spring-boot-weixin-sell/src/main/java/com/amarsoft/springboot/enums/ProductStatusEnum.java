/** 
　 * Title: ProductStatusEnum.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月8日
　 * @version 1.0 
*/

package com.amarsoft.springboot.enums;

import lombok.Getter;

/** 
 * @Title: 
 * @Description:商品上下架状态枚举类（对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月8日下午6:45:23 （日期） 
 * @version:v.1.0
 */
@Getter
public enum ProductStatusEnum {
    
	UP(0,"在架"),
	DOWN(1,"下架");
	private Integer code;
	private String message;
	
	ProductStatusEnum(Integer code,String message) {
		this.code=code;
		this.message=message;
	}

}
