/** 
　 * Title: ProductInfoVO.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月11日
　 * @version 1.0 
*/

package com.amarsoft.springboot.VO;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月11日上午12:31:52 （日期） 
 * @version:v.1.0
 */
@Data
public class ProductInfoVO {

	@JsonProperty("id")
    private String productId;

	@JsonProperty("name")
	private String productName;
	
	@JsonProperty("price")
	private BigDecimal productPrice;
	
	@JsonProperty("description")
	private String ProductDescription;
	
	@JsonProperty("icon")
	private String productIcon;

}
