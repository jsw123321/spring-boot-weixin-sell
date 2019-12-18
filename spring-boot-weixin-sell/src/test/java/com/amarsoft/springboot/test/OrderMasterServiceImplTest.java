/**  
 * 
 * @Title:  OrderMasterServiceImplTest.java   
 * @Package com.amarsoft.springboot.test   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月15日 下午5:31:12   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */  
package com.amarsoft.springboot.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.amarsoft.springboot.dataobject.OrderDetail;
import com.amarsoft.springboot.dto.OrderDTO;
import com.amarsoft.springboot.enums.OrderStatusEnum;
import com.amarsoft.springboot.enums.PayStatusEnum;
import com.amarsoft.springboot.repository.OrderDetailRepository;
import com.amarsoft.springboot.repository.OrderMasterRepository;
import com.amarsoft.springboot.service.OrderService;
import com.amarsoft.springboot.service.ProductInfoService;

import lombok.extern.slf4j.Slf4j;

/**   
 * @ClassName:  OrderMasterServiceImplTest   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiangshanwen
 * @date:   2019年12月15日 下午5:31:12     
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved. 
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderMasterServiceImplTest {

	 @Autowired
	 private OrderService orderService;
	 
	 @Autowired
	 private ProductInfoService productInfoService;
	 
	 @Autowired
	 private OrderDetailRepository  orderDetailRepository;
	 
	 @Autowired
	 private OrderMasterRepository  orderMasterRepository;
	
	 
	 private final String OPENID="201912151747";
	 private final String ORDERID="1576409643590274207";
	 private final String BUYEROPENID="123123";
	 @Test
	 public  void testCreateOrderMaster(){
		    /**
		     * ```
				POST /sell/buyer/order/create
				参数
				name: "张三"
				phone: "18868822111"
				address: "慕课网总部"
				openid: "ew3euwhd7sjw9diwkq" //用户的微信openid
				items: [{
				    productId: "1423113435324",
				    productQuantity: 2 //购买数量
				}]
		     */
		 
		 OrderDTO  orderDTO=new  OrderDTO();
		 orderDTO.setBuyerName("jiangshanwen");
		 orderDTO.setBuyerPhone("13247159251");
		 orderDTO.setBuyerAddress("广东省深圳市福田区沙嘴二坊47");
		 orderDTO.setBuyerOpenid(OPENID);
		 List<OrderDetail> orderDetailList=new ArrayList<OrderDetail>();
		 /**
		  * prd001	皮蛋瘦肉粥	4	99	价格实惠,味道很不错！	http://我很帅.jpg	0	1	2019-12-03 11:07:15	2019-12-03 11:07:15
prd002	香辣手撕鸡	5	91	价格实惠,味道很不错！	http://她很美.jpg	0	1	2019-12-03 11:24:17	2019-12-03 19:06:56
prd003	玉米鸡丁	15	91	价格实惠,味道很不错！	http://很健康.jpg	0	1	2019-12-03 13:20:26	2019-12-03 19:06:56
prd004	肉末茄子	12	91	价格实惠,味道很不错！	http://很健康1.jpg	0	1	2019-12-03 14:24:20	2019-12-03 19:06:56
prd005	蚂蚁上树	18	333	价格实惠,味道很不错！	http://很健康.jpg	0	3	2019-12-03 14:25:28	2019-12-03 19:06:56
		  */
		 OrderDetail orderDetail1=new OrderDetail();
		 orderDetail1.setProductId("prd001");
		 orderDetail1.setProductQuantity(3);
		 
		 OrderDetail orderDetail2=new OrderDetail();
		 orderDetail2.setProductId("prd002");
		 orderDetail2.setProductQuantity(5);
		 
		 OrderDetail orderDetail3=new OrderDetail();
		 orderDetail3.setProductId("prd003");
		 orderDetail3.setProductQuantity(2);
		 
		 OrderDetail orderDetail4=new OrderDetail();
		 orderDetail4.setProductId("prd004");
		 orderDetail4.setProductQuantity(1);
		 
		 OrderDetail orderDetail5=new OrderDetail();
		 orderDetail5.setProductId("prd005");
		 orderDetail5.setProductQuantity(11);
		 orderDetailList.add(orderDetail1);
		 orderDetailList.add(orderDetail2);
		 orderDetailList.add(orderDetail3);
		 orderDetailList.add(orderDetail4);
		 orderDetailList.add(orderDetail5);
		 orderDTO.setOrderDetailList(orderDetailList);
		 OrderDTO result = orderService.create(orderDTO);
		 log.info("【创建订单】：result={}",result);
		 Assert.assertNotNull(result);
	}
	 
	 
	 @Test
	 public void testfindOne(){
		 OrderDTO findOne = orderService.findOne(ORDERID);
		 log.info("【查询订单】：result={}",findOne);
	 }
	 
	 
	 @Test
	 public void testfindList(){
		 PageRequest pageRequest=new PageRequest(1,3);
		 Page<OrderDTO> findList = orderService.findList(BUYEROPENID, pageRequest);
		 System.out.println(findList.getTotalElements()+"-----"+findList.getContent());
		 Assert.assertNotEquals(0, findList.getTotalElements());
	 }
	 
	 @Test
	 public void testCancle(){
		 OrderDTO findOne = orderService.findOne(ORDERID);
		 OrderDTO cancle = orderService.cancle(findOne);
		 Assert.assertEquals(OrderStatusEnum.CANCLE.getCode(),cancle.getOrderStatus());
	 }
	 /**
	  * 
	  * @Title: testCancle
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @author jiangshanwen
	  * @date 2019年12月18日 下午10:29:13
	  * @throws
	  */
	 @Test
	 public void testFinished(){
		 OrderDTO findOne = orderService.findOne(ORDERID);
		 OrderDTO finished = orderService.finished(findOne);
		 Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),finished.getOrderStatus());
	 }
	 
	 @Test
	 public void testPaid(){
		 OrderDTO findOne = orderService.findOne(ORDERID);
		 OrderDTO payid = orderService.payid(findOne);
		 Assert.assertEquals(PayStatusEnum.PAY.getCode(),payid.getPayStatus());
	 }
	 
	 
	 
}
