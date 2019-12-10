/** 
　 * Title: BuyerProductController.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月10日
　 * @version 1.0 
*/

package com.amarsoft.springboot.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amarsoft.springboot.VO.ProductInfoVO;
import com.amarsoft.springboot.VO.ProductVO;
import com.amarsoft.springboot.VO.ResultVO;

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

       @GetMapping("/list")
       public ResultVO list(){
    	   ResultVO resultVo =new ResultVO();
    	   ProductVO  productVO=new ProductVO();
    	   ProductInfoVO productinfovo=new ProductInfoVO();
    	   productinfovo.setProductId("1234234");
    	   productinfovo.setProductName("皮蛋瘦肉粥");
    	   productinfovo.setProductPrice(3.4);
    	   productinfovo.setProductIcon("HTTP://QWEQWE.JPG");
    	   productinfovo.setProductDescription("好吃不上火");
    	   productVO.setCategoryType(1);
    	   productVO.setCategoryName("热榜");//皮蛋瘦肉粥
    	   productVO.setProductInfoVOList(Arrays.asList(productinfovo));
    	   resultVo.setData(Arrays.asList(productVO));
    	   resultVo.setCode(0);
    	   resultVo.setMsg("成功");
    	   return resultVo;
       }
}
