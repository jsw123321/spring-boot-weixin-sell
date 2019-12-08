/** 
　 * Title: ProductInfoService.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月8日
　 * @version 1.0 
*/

package com.amarsoft.springboot.service;

import java.util.List;

import com.amarsoft.springboot.dataobject.ProductInfo;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月8日下午10:25:15 （日期） 
 * @version:v.1.0
 */
public interface ProductInfoService {

	ProductInfo  findOne(String productId);
	
	List<ProductInfo> findUpAll(Integer ProductStatus);

	/**  
	 * @Title: findAll
	 * @Description: TODO(描述)
	 * @return
	 * @author jiangshanwen
	 * @date 2019年12月8日 下午11:03:17
	 */  
	List<ProductInfo> findAll();

}
