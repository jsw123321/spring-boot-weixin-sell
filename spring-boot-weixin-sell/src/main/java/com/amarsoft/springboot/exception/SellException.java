/**  
 * 
 * @Title:  SellException.java   
 * @Package com.amarsoft.springboot.exception   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月15日 下午1:09:44   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */  
package com.amarsoft.springboot.exception;

import com.amarsoft.springboot.enums.ResultEnum;

/**   
 * @ClassName:  SellException   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiangshanwen
 * @date:   2019年12月15日 下午1:09:44     
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved. 
 * 
 */
public class SellException extends RuntimeException {
    private Integer code;
	/**   
	 * @Title:  SellException   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:    
	 * @throws   
	 */
	public SellException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code=resultEnum.getCode();
	}

	/**   
	 * @Title:  SellException   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:  message  
	 * @throws   
	 */

	public SellException(String message) {
		super(message);
		
	}

	/**   
	 * @Title:  SellException   
	 * @Description:ODO(这里用一句话描述这个方法的作用)   
	 * @param:  cause  
	 * @throws   
	 */

	public SellException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**   
	 * @Title:  SellException   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:  message
	 * @param:  cause  
	 * @throws   
	 */

	public SellException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**   
	 * @Title:  SellException   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:   message
	 * @param:   cause
	 * @param:   enableSuppression
	 * @param:   writableStackTrace  
	 * @throws   
	 */

	public SellException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
