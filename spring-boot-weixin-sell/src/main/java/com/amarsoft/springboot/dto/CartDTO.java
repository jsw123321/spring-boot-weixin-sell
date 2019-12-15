/**  
 * 
 * @Title:  CartDTO.java   
 * @Package com.amarsoft.springboot.dto   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月15日 下午4:27:56   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */  
package com.amarsoft.springboot.dto;

import java.math.BigDecimal;

import lombok.Getter;

/**   
 * @ClassName:  CartDTO   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiangshanwen
 * @date:   2019年12月15日 下午4:27:56     
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved. 
 * 
 */
@Getter
public class CartDTO {

	private String productId;
	
	private Integer productQuantity;
	
	/**   
	 * @Title:  CartDTO   
	 * @Description: 购物车DTO数据结构(这里用一句话描述这个方法的作用)   
	 * @param:   productId
	 * @param:   productQuantity  
	 * @throws   
	 */  
	public CartDTO(String productId, Integer productQuantity) {
		this.productId = productId;
		this.productQuantity = productQuantity;
	}


	public CartDTO() {
	}

}
