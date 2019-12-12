/** 
　 * Title: ProductInfoServiceTest.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月8日
　 * @version 1.0 
*/

package com.amarsoft.springboot.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.amarsoft.springboot.dataobject.ProductInfo;
import com.amarsoft.springboot.enums.ProductStatusEnum;
import com.amarsoft.springboot.service.impl.ProductInfoServiceImpl;

/**
 * @Title:
 * @Description: （对类进行功能描述）
 * @author jiangshanwen
 * @date: 2019年12月8日下午10:38:48 （日期）
 * @version:v.1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceTest {

	@Autowired
	private ProductInfoServiceImpl productInfoService;

	@Test
	public void testSave() {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductId("prd006");
		productInfo.setProductName("酸菜鱼");
		productInfo.setProductDescription("价格实惠,味道很不错！");
		productInfo.setProductPrice(25.00);
		productInfo.setProductStock(333);
		productInfo.setProductStatus(1);
		productInfo.setCategoryType(4);
		productInfo.setProductIcon("http://很健康.jpg");
	    productInfoService.save(productInfo);
	}

	/**
	 * 
	 * @Title: testfindOne
	 * @Description: TODO(描述)
	 * @author jiangshanwen
	 * @date 2019年12月8日 下午10:52:52
	 */
	@Test
	public void testfindOne() {
		ProductInfo productInfo = productInfoService.findOne("prd002");
		System.out.println(productInfo);
	}

	/**
	 * 
	 * @Title: testfindByProductStatus
	 * @Description: 根据商品的上下架状态来查询的接口单元测试(描述)
	 * @author jiangshanwen
	 * @date 2019年12月8日 下午10:59:31
	 */
	@Test 
	public void testfindUPAll() {
		List<ProductInfo> findUpAllList = productInfoService.findUpAll();
		System.out.println(findUpAllList.toString());
	}

	@Test
	public void testFindAll() {
		List<ProductInfo> findAllList = productInfoService.findAll();
		System.out.println(findAllList);
	}
}
