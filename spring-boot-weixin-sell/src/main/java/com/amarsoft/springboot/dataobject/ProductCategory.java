/** 
　 * Title: ProductCategory.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年11月29日上午12:18:50 
　 * @version 1.0 
*/

package com.amarsoft.springboot.dataobject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/** 
 * @Title: ProductCategory
 * @Description: 商品类目实体对象
 * @author jiangshanwen
 * @date: 2019年11月29日上午12:18:50 （日期） 
 * @version:v.1.0
 */
@Entity
@Data
public class ProductCategory {
	
	/** 类目id. */
	@Id
	@GeneratedValue
	private Integer categoryId;
	
	/**类目名称.*/
	private String categoryName;
	
	/**类目编号.*/
	private Integer categoryType;
	
	private Date categoryTime;
	
	private Date updateTime;
	
	public ProductCategory() {
	}

	/** 
	　 * <p>Title: ProductCategory</p> 
	　 * <p>Description: 有参构造函数</p> 
	　 * @param categoryName
	　 * @param categoryType 
	  */
	
	public ProductCategory(String categoryName, Integer categoryType) {
		super();
		this.categoryName = categoryName;
		this.categoryType = categoryType;
	}

}
