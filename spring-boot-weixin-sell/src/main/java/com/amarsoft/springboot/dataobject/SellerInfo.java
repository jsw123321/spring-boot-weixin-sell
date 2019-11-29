/** 
　 * Title: SellerInfo.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年11月29日上午12:49:50 
　 * @version 1.0 
*/

package com.amarsoft.springboot.dataobject;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年11月29日上午12:49:50 （日期） 
 * @version:v.1.0
 */
@Data
@Entity
public class SellerInfo {
    @Id
	private String sellerId;
    
	private String username;
	
	private String password;
	
	private String openid;
	

}
