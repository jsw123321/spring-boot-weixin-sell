/** 
　 * Title: ProductInfoServiceImpl.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月8日
　 * @version 1.0 
*/

package com.amarsoft.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amarsoft.springboot.dataobject.ProductInfo;
import com.amarsoft.springboot.dto.CartDTO;
import com.amarsoft.springboot.enums.ProductStatusEnum;
import com.amarsoft.springboot.enums.ResultEnum;
import com.amarsoft.springboot.exception.SellException;
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

	@Override
	public void decreaseStock(List<CartDTO> cartDTOList) {
		for (CartDTO cartDTO : cartDTOList) {
			Integer quantity = cartDTO.getProductQuantity();
			ProductInfo productInfo = productInfoRepository.getOne(cartDTO.getProductId());
			if (null == productInfo) {
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			Integer result = productInfo.getProductStock();
			result -= quantity;
			if (result < 0) {
				throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
			}
			productInfo.setProductStock(result);
			productInfoRepository.save(productInfo);
		}
	}

	@Override
	public void increaseStock(List<CartDTO> cartDTOList) {
		/**
		 * ``` POST /sell/buyer/order/create 参数 name: "张三" phone: "18868822111"
		 * address: "慕课网总部" openid: "ew3euwhd7sjw9diwkq" //用户的微信openid items: [{
		 * productId: "1423113435324", productQuantity: 2 //购买数量 }]
		 */
		for (CartDTO cartDTO : cartDTOList) {
			Integer quantity = cartDTO.getProductQuantity();
			ProductInfo productInfo = productInfoRepository.findByProductId(cartDTO.getProductId());
			if (null == productInfo) {
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			Integer number = productInfo.getProductStock();
			number += quantity;
			productInfo.setProductStock(number);
			productInfoRepository.save(productInfo);
		}
	}
}
