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
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/** 
 * @Title: ProductCategory
 * @Description: 商品类目实体对象
 * @author jiangshanwen
 * @date: 2019年11月29日上午12:18:50 （日期） 
 * @version:v.1.0
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {
	
	/** 类目id.
	 * 
	 *  @id  标注用于声明一个实体类的属性映射为数据库的主键列。
	 *	@GeneratedValue   用于标注主键的生成策略。
	 *  GenerationType.IDENTITY 主键自增长
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	
	/**类目名称.*/
	private String categoryName;
	
	/**类目编号.*/
	private Integer categoryType;
	
	private Date createTime;
	
	private Date updateTime;
	
	public ProductCategory() {
	}

	
	
	public ProductCategory(String categoryName, Integer categoryType) {
		super();
		this.categoryName = categoryName;
		this.categoryType = categoryType;
	}

	@Override
	public String toString() {
		return "ProductCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryType="
				+ categoryType + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}
