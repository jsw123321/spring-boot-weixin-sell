/** 
　 * Title: OrderDetailRepositoryTest.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月13日
　 * @version 1.0 
*/

package com.amarsoft.springboot.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.amarsoft.springboot.dataobject.OrderDetail;
import com.amarsoft.springboot.repository.OrderDetailRepository;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月13日上午12:28:31 （日期） 
 * @version:v.1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private  OrderDetailRepository orderDetailRepository;
    
    
    @Test
    public void testSave(){
    	OrderDetail orderDetail=new OrderDetail();
    	orderDetail.setOrderId("10010");
    	orderDetail.setDetailId("1001012");
    	orderDetail.setProductId("100101101");
    	orderDetail.setProductName("皮蛋粥");
    	orderDetail.setProductPrice(3.50);
    	orderDetail.setProductIcon("http://xxx.jpg");
    	orderDetail.setProductQuantity(144);
    	OrderDetail orderDetailSave = orderDetailRepository.save(orderDetail);
    	Assert.assertNotNull(orderDetailSave);
    }
    
    @Test
    public void testFindAll(){
    	List<OrderDetail> findAll = orderDetailRepository.findAll();
    	Assert.assertNotEquals(0, findAll.size());
    	System.out.println(findAll.toString());
    	}
    
    @Test
    public void testFindOne(){
    	OrderDetail findOne = orderDetailRepository.getOne("1001011");
    	Assert.assertNotNull(findOne);
    	System.out.println(findOne);
    }
}
