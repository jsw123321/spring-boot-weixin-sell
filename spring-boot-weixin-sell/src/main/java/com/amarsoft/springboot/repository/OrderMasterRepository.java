/** 
　 * Title: OrderMasterRepository.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月13日
　 * @version 1.0 
*/

package com.amarsoft.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amarsoft.springboot.dataobject.OrderMaster;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月13日上午12:09:21 （日期） 
 * @version:v.1.0
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
//	Optional<OrderMaster> findById(String id);
//	
//	List<OrderMaster> findAll();
}
