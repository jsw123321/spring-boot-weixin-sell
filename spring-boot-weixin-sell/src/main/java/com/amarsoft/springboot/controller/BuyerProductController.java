/** 
　 * Title: BuyerProductController.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月10日
　 * @version 1.0 
*/

package com.amarsoft.springboot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amarsoft.springboot.VO.ProductInfoVO;
import com.amarsoft.springboot.VO.ProductVO;
import com.amarsoft.springboot.VO.ResultVO;
import com.amarsoft.springboot.dataobject.ProductCategory;
import com.amarsoft.springboot.dataobject.ProductInfo;
import com.amarsoft.springboot.service.CategoryService;
import com.amarsoft.springboot.service.ProductInfoService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月10日下午11:43:55 （日期） 
 * @version:v.1.0
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
		@Autowired
		private ProductInfoService productService;
	
       @Autowired
       private CategoryService categoryService;
       
       
       @GetMapping("/list")
       public ResultVO list(){
    	   //1.查询所有上架商品
    	   List<ProductInfo> productInfoUpList = productService.findUpAll();
    	   //2.查询类目--一次性查出来
    	   List<Integer> categoryTypeList = productInfoUpList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
    	   List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
    	   //3.数据的拼装
    	   List<ProductVO> productVOList=new ArrayList<ProductVO>();
    	   for (ProductCategory productCategory : productCategoryList) {
			ProductVO productVO=new ProductVO();
			productVO.setCategoryType(productCategory.getCategoryType());
			productVO.setCategoryName(productCategory.getCategoryName());
			
			List<ProductInfoVO> productInfoVOList= new ArrayList<ProductInfoVO>();
			for (ProductInfo productInfo : productInfoUpList) {
				if(productInfo.getCategoryType()==(productCategory.getCategoryType())){
					ProductInfoVO productInfoVO=new ProductInfoVO();
					BeanUtils.copyProperties(productInfo,productInfoVO);
					productInfoVOList.add(productInfoVO);
				}
				
			}
			productVO.setProductInfoVOList(productInfoVOList);
			productVOList.add(productVO);
		}
    	   ResultVO resultVo =new ResultVO();
//    	   ProductVO  productVO=new ProductVO();
//    	   ProductInfoVO productinfovo=new ProductInfoVO();
//    	   productinfovo.setProductId("1234234");
//    	   productinfovo.setProductName("皮蛋瘦肉粥");
//    	   productinfovo.setProductPrice(3.4);
//    	   productinfovo.setProductIcon("HTTP://QWEQWE.JPG");
//    	   productinfovo.setProductDescription("好吃不上火");
//    	   productVO.setCategoryType(1);
//    	   productVO.setCategoryName("热榜");//皮蛋瘦肉粥
//    	   productVO.setProductInfoVOList(Arrays.asList(productinfovo));
    	   resultVo.setData(productVOList);
    	   resultVo.setCode(0);
    	   resultVo.setMsg("成功");
    	   return resultVo;
       }
}
