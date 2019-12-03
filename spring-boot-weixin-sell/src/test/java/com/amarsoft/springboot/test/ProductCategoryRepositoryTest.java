/** 
　 * Title: ProductCategoryRepositoryTest.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年11月30日下午10:25:51 
　 * @version 1.0 
*/

package com.amarsoft.springboot.test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.amarsoft.springboot.dataobject.ProductCategory;
import com.amarsoft.springboot.repository.ProductCategoryRepository;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年11月30日下午10:25:51 （日期） 
 * @version:v.1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
	
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.getOne(3);
        System.out.println(productCategory.toString());
    }
	@Test
	public void testSave(){
		ProductCategory productCategory=new ProductCategory("女生1最爱999",4);
		ProductCategory result = repository.save(productCategory);
		Assert.assertNotNull(result);
	}
	@Test
	public void testSaveandUpdate(){
		ProductCategory productCategory = repository.getOne(15);
//		ProductCategory productCategory=new ProductCategory("女生最爱123",4);
		productCategory.setCategoryType(3);
		productCategory.setCategoryName("男生最爱");
		ProductCategory result = repository.saveAndFlush(productCategory);
		Assert.assertNotNull(result);
	}
}
