/** 
　 * Title: OrderDetailRepository.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月13日
　 * @version 1.0 
*/

package com.amarsoft.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amarsoft.springboot.dataobject.OrderDetail;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月13日上午12:26:39 （日期） 
 * @version:v.1.0
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

}
