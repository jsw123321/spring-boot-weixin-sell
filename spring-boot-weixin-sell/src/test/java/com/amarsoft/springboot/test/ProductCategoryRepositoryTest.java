/** 
　 * Title: ProductCategoryRepositoryTest.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年11月30日下午10:25:51 
　 * @version 1.0 
*/

package com.amarsoft.springboot.test;

import java.util.Arrays;
import java.util.List;
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
    
    /**
     * 
     * @Title: findOneTest
     * @Description: 根据类目主键id来查询类目的单元测试
     * @author jiangshanwen
     * @date 2019年12月8日 下午12:11:21
     */
    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.getOne(3);
        System.out.println(productCategory.toString());
    }
    
    /**
     * @Title: testSaveCategory
     * @Description: 新增加一个类目的单元测试
     * @author jiangshanwen
     * @date 2019年12月8日 上午11:56:28
     */
	@Test
	public void testSaveCategory(){
		ProductCategory productCategory=new ProductCategory("女生1最爱999",4);
		ProductCategory result = repository.save(productCategory);
		System.out.println(result);
		Assert.assertNotNull(result);
	}
	
	
	/**
	 * 
	 * @Title: testUpdateCategory
	 * @Description: 更新一个类目并刷新数据库数据的单元测试(描述)
	 * @author jiangshanwen
	 * @date 2019年12月8日 下午12:04:03
	 */
	@Test
	public void testUpdateCategory(){
		ProductCategory productCategory = repository.getOne(3);
		productCategory.setCategoryType(2);
		productCategory.setCategoryName("男生最爱3");
		repository.saveAndFlush(productCategory);
//		System.out.println(result);
		repository.flush();
//		Assert.assertNotNull(result);
		
	}

	/**
	 * 
	 * @Title: testfindByCategoryTypeIn
	 * @Description: 根据类目类别id来查询目录的单元测试
	 * @author jiangshanwen
	 * @date 2019年12月8日 上午11:58:37
	 */
	@Test
	public void testfindByCategoryTypeIn(){
		List<Integer> list=Arrays.asList(2,3,4);
        List<ProductCategory> findByCategoryTypeIn = repository.findByCategoryTypeIn(list);
        System.out.println(findByCategoryTypeIn.toString());
		Assert.assertNotEquals(0, findByCategoryTypeIn.size());
	}
	
	/**
	 * 
	 * @Title: testFindAll
	 * @Description: 查询所有类目记录的单元测试(描述)
	 * @author jiangshanwen
	 * @date 2019年12月8日 下午12:18:22
	 */
	@Test
	public void testFindAll(){
//		List<ProductCategory> list=Arrays.asList(1,2,3,4,5,6);
		List<ProductCategory> findAllList = repository.findAll();
		System.out.println(findAllList.toString());
		Assert.assertNotNull(findAllList.size());
	}
	
	@Test
//	@Transactional
	public void testDeleteById(){
		repository.deleteById(3);
	}
}
