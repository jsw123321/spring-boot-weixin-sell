/** 
　 * Title: OrderMasterRepositoryTest.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月13日
　 * @version 1.0 
*/

package com.amarsoft.springboot.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.amarsoft.springboot.dataobject.OrderMaster;
import com.amarsoft.springboot.repository.OrderMasterRepository;

import reactor.core.Fuseable.SynchronousSubscription;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月13日上午12:58:57 （日期） 
 * @version:v.1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    
	@Autowired
	private OrderMasterRepository orderMasterRepository;
	
	private final String OPENID="123123";
	
	@Test
	public void testSave(){
		OrderMaster orderMaster=new OrderMaster();
		orderMaster.setOrderId("10015");
		orderMaster.setBuyerOpenid(OPENID);
		orderMaster.setBuyerName("jiangshanwen05");
		orderMaster.setBuyerAddress("广东省深圳市福田区沙嘴二坊");
		orderMaster.setBuyerPhone("13245968982");
		orderMaster.setOrderAmount(14);
		orderMaster.setPayStatus(0);
		orderMaster.setOrderStatus(0);
		OrderMaster save = orderMasterRepository.save(orderMaster);
		Assert.assertNotNull(save);
	}
	
	@Test
	public void testFindAll(){
		PageRequest result=new PageRequest(1, 3);
		Page<OrderMaster> findAll = orderMasterRepository.findAll(result);
		System.out.println(findAll.getTotalElements());
		System.out.println(findAll.getContent());
//		System.out.println(findAll.size());
//		Assert.assertNotEquals(0, findAll.size());
	}
//	
//	@Test
//	public void testFindByOpenid(){
//		PageRequest result=new PageRequest(1, 3);
//		Page<OrderMaster> findAll = orderMasterRepository.fingByBuyerOpenid(OPENID, result);
//		System.out.println(findAll.getTotalElements());
////		Assert.assertNotEquals(0, findAll.getTotalElements());
//	}

}
