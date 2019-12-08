/** 
　 * Title: ProductInfoController.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月8日
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
 * @date: 2019年12月8日下午6:32:44 （日期） 
 * @version:v.1.0
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>{
        //新增加一个ProductInfo
	    //根据productId来查询ProductInfo
	    //查询所有的ProductInfo
	    //根据上下架状态来查询ProductInfo
	List<ProductInfo> findByProductStatus(Integer integer);
}
