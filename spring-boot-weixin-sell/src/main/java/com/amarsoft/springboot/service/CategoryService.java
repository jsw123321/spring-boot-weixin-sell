/** 
　 * Title: CategoryService.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月1日下午8:59:38 
　 * @version 1.0 
*/

package com.amarsoft.springboot.service;

import java.util.Optional;

import com.amarsoft.springboot.dataobject.ProductCategory;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月1日下午8:59:38 （日期） 
 * @version:v.1.0
 */
public interface CategoryService {

	ProductCategory findOne(Integer categoryId);


}
