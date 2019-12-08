/** 
　 * Title: CategoryServiceTest.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月8日上午11:18:30 
　 * @version 1.0 
*/

package com.amarsoft.springboot.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.amarsoft.springboot.dataobject.ProductCategory;
import com.amarsoft.springboot.service.impl.CategoryServiceImpl;

/**
 *  
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月8日上午11:39:12 （日期） 
 * @version:v.1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {
	
	@Autowired
	private CategoryServiceImpl categoryService;
	
	public CategoryServiceTest() {
	}
    
	/**
	 * 
	 * @Title: testGetOne
	 * @Description: service层根据类目的主键id查询的接口单元测试(描述)
	 * @author jiangshanwen
	 * @date 2019年12月8日 下午2:10:25
	 */
	@Test
	public void testGetOne(){
		ProductCategory productCategory = categoryService.findOne(1);
		System.out.println(productCategory.toString());
	}
	
	/**
	 * @Title: testfindAll
	 * @Description: service层查询所有的接口单元测试(描述)
	 * @author jiangshanwen
	 * @date 2019年12月8日 下午2:03:17
	 */
	@Test
	public void testfindAll(){
		List<ProductCategory> findAll = categoryService.findAll();
		System.out.println(findAll.toString());
	}
	
	
}
