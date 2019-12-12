/** 
　 * Title: ProductInfoServiceImpl.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月8日
　 * @version 1.0 
*/

package com.amarsoft.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amarsoft.springboot.dataobject.ProductInfo;
import com.amarsoft.springboot.enums.ProductStatusEnum;
import com.amarsoft.springboot.repository.ProductInfoRepository;
import com.amarsoft.springboot.service.ProductInfoService;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月8日下午10:32:39 （日期） 
 * @version:v.1.0
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoRepository productInfoRepository;
	public ProductInfoServiceImpl() {
	}

	@Override
	public ProductInfo findOne(String productId) {
		return productInfoRepository.getOne(productId);
	}

	@Override
	public List<ProductInfo> findUpAll() {
		return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
	}
    
	@Override
	public List<ProductInfo> findAll() {
		return productInfoRepository.findAll();
	}

	/**  
	 * @Title: save
	 * @Description: TODO(描述)
	 * @param productInfo
	 * @return
	 * @author jiangshanwen
	 * @date 2019年12月8日 下午11:21:03
	 */  
	public void save(ProductInfo productInfo) {
		productInfoRepository.save(productInfo);
	}
	

}
