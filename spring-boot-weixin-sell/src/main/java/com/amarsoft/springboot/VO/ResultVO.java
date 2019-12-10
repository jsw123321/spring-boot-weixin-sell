/** 
　 * Title: ResultVO.java 
　 * Description: TODO(一句话描述这个方法的目的和作用)
　 * @author jiangshanwen 
　 * @date 2019年12月10日
　 * @version 1.0 
*/

package com.amarsoft.springboot.VO;

import lombok.Data;

/** 
 * @Title: 
 * @Description: （对类进行功能描述） 
 * @author jiangshanwen
 * @date: 2019年12月10日下午11:21:29 （日期） 
 * @version:v.1.0
 */
@Data
public class ResultVO<T> {
	
    /**错误码.*/
	private Integer code;
	
	/**提示信息 .*/
	private String msg;
	
	/**返回值 .*/
	private T data;

}
