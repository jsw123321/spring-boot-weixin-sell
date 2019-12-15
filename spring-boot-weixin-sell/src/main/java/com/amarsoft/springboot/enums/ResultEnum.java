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
	
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(20,"商品已售罄");
	
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
