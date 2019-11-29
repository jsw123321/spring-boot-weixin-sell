/** 
　 * Title: ProductInfoRepository.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年11月29日上午12:52:46 
　 * @version 1.0 
*/

package com.amarsoft.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amarsoft.springboot.dataobject.ProductInfo;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年11月29日上午12:52:46 （日期） 
 * @version:v.1.0
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>{
  List<ProductInfo> findByProductStatus(Integer productStatus);
}
