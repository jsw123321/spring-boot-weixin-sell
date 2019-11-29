/** 
　 * Title: ProductInfo.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年11月29日上午12:39:48 
　 * @version 1.0 
*/

package com.amarsoft.springboot.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年11月29日上午12:39:48 （日期） 
 * @version:v.1.0
 */
@Entity
@Data
public class ProductInfo {

	@Id
	private String productId;
	
	/**  名字.  */
	private String productName;
	/**  单价.  */
	private BigDecimal productPrice;
	/**  库存.  */
	private Integer productStock;
	/**  描述.  */
	private String productDescription;
	/**  小图.  */
	private String productIcon;
	
	/**  状态,0正常 1下架.  */
	private Integer productStatus ;
//	= ProductStatusEnum;
	
	/**  类目编号.  */
	private Integer categoryType;
	
	private Date createTime;
	
	public ProductInfo() {
	}

}
