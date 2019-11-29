/** 
　 * Title: ProductCategoryRepository.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年11月29日上午12:10:34 
　 * @version 1.0 
*/

package com.amarsoft.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amarsoft.springboot.dataobject.ProductCategory;

/** 
 * @Title: ProductCategoryRepository
 * @Description: 商品类目接口类
 * @author jiangshanwen
 * @date: 2019年11月29日上午12:10:34 （日期） 
 * @version:v.1.0
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{

	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
