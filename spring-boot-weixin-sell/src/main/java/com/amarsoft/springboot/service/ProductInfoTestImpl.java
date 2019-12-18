/**  
 * 
 * @Title:  ProductInfoTestImpl.java   
 * @Package com.amarsoft.springboot.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月18日 下午10:18:57   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */  
package com.amarsoft.springboot.service;

import com.amarsoft.springboot.dataobject.ProductInfo;

/**   
 * @ClassName:  ProductInfoTestImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiangshanwen
 * @date:   2019年12月18日 下午10:18:57     
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved. 
 * 
 */
public class ProductInfoTestImpl {
	
	   /**
	    * 
	    * @Title: findById
	    * @Description: TODO(这里用一句话描述这个方法的作用) 
	    * @param name
	    * @param tellPhone
	    * @return
	    * @author jiangshanwen
	    * @date 2019年12月18日 下午10:21:51
	    * @throws
	    */
       public ProductInfo findById(String name,String tellPhone){
    	   ProductInfo productInfo=new ProductInfo();
    	   productInfo.setProductName(name);
    	   productInfo.setProductId(tellPhone);;
    	   return productInfo;
       }
}
