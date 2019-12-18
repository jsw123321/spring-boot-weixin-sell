/** 
　 * Title: CategoryServiceImpl.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月1日下午9:02:40 
　 * @version 1.0 
*/

package com.amarsoft.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.amarsoft.springboot.dataobject.ProductCategory;
import com.amarsoft.springboot.repository.ProductCategoryRepository;
import com.amarsoft.springboot.service.CategoryService;


/**
 * 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月8日上午11:36:16 （日期） 
 * @version:v.1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	public CategoryServiceImpl() {
	}

	@Autowired
	private ProductCategoryRepository repository;
    
	@Override
	public ProductCategory findOne(Integer categoryId) {
		return repository.getOne(categoryId);
	}
	
	@Override
	public List<ProductCategory> findAll(){
		return  repository.findAll();
	}
	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
		return repository.findByCategoryTypeIn(categoryTypeList);
	}

	
    
}
