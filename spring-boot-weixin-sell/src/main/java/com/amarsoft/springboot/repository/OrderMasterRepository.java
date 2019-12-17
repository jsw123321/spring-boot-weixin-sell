/** 
　 * Title: OrderMasterRepository.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月13日
　 * @version 1.0 
*/

package com.amarsoft.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	/**  
	 * @Title: fingByBuyerOpenid
	 * @Description: TODO(描述)
	 * @param oPENID
	 * @param result
	 * @return
	 * @author jiangshanwen
	 * @date 2019年12月13日 下午10:17:33
	 */  
    Page<OrderMaster> buyerOpenid(String buyerOpenid, Pageable result);
//	Optional<OrderMaster> findById(String id);
    //Page<OrderMaster>  findByBuyerOpenid(String buyerOpenid,Pageable pageable,pageSize);
//	Page<OrderMaster>  fingByBuyerOpenid(String buyerOpenid,Pageable pageable);
//	List<OrderMaster> findAll();
}
