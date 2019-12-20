/**  
 * 
 * @Title:  OrderForm.java   
 * @Package com.amarsoft.springboot.form   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月20日 下午9:50:12   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */  
package com.amarsoft.springboot.form;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

/**   
 * @ClassName:  OrderForm   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiangshanwen
 * @date:   2019年12月20日 下午9:50:12     
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved. 
 * 
 */
@SuppressWarnings("deprecation")
@Data
public class OrderForm {
     
	 /**
	  * 买家姓名
	  */
	 @NotEmpty(message="姓名必填")
     private String name;
	 
	 /**
	  * 买家电话
	  */
	 @NotEmpty(message="电话必填")
     private String phone;
     
	 /**
	  * 买家地址
	  */
	 @NotEmpty(message="地址必填")
     private String address;
     
	 /**
	  * 买家openid
	  */
	 @NotEmpty(message="openid必填")
     private String openid;
     
	 /**
	  * 购物车
	  */
	 @NotEmpty(message="购物车不能为空")
     private String items;
}
