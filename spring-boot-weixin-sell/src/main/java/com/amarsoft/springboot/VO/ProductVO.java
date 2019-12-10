/** 
　 * Title: ProductVO.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月10日
　 * @version 1.0 
*/

package com.amarsoft.springboot.VO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/** 
 * @Title:
 *  
 * @Description: 商品  包含类目（对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月10日下午11:39:58 （日期） 
 * @version:v.1.0
 */
@Data
public class ProductVO {
     
	 @JsonProperty("name")
	 private String categoryName;
	 
	 @JsonProperty("type")
	 private Integer categoryType;
	 
	 @JsonProperty("foods")
	 private List<ProductInfoVO> productInfoVOList;

}
