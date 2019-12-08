/** 
　 * Title: ProductInfoRepositoryTest.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月8日
　 * @version 1.0 
*/

package com.amarsoft.springboot.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.amarsoft.springboot.dataobject.ProductInfo;
import com.amarsoft.springboot.enums.ProductStatusEnum;
import com.amarsoft.springboot.repository.ProductInfoRepository;


/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月8日下午6:38:04 （日期） 
 * @version:v.1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
	     
	     @Autowired
         private ProductInfoRepository productInfoRepository;
	     
	     /**
	      * 
	      * @Title: testSave
	      * @Description: TODO(描述)
	      * @author jiangshanwen
	      * @date 2019年12月8日 下午9:24:07
	      */
	     @Test
	     public void testSave(){
	    	 ProductInfo productInfo=new ProductInfo();
	    	 productInfo.setProductId("prd004");
	    	 productInfo.setProductName("肉末茄子");
	    	 productInfo.setProductDescription("价格实惠,味道很不错！");
	    	 productInfo.setProductPrice(12.00);
	    	 productInfo.setProductStock(91);
	    	 productInfo.setProductStatus(1);
	    	 productInfo.setCategoryType(1);
	    	 productInfo.setProductIcon("http://很健康1.jpg");
	    	 ProductInfo save = productInfoRepository.save(productInfo);
	     }
	     
	     /**
	      * @Title: testFindByProductStatus
	      * @Description: 根据商品上下架状态来查询商品的接口单元测试(描述)
	      * @author jiangshanwen
	      * @date 2019年12月8日 下午9:44:25
	      */
	     @Test
	     public void testFindByProductStatus(){
	    	 List<ProductInfo> findByProductStatus = productInfoRepository.findByProductStatus(1);
	    	 System.out.println(findByProductStatus);
	    	 Assert.assertNotNull(findByProductStatus);
	     }

}
