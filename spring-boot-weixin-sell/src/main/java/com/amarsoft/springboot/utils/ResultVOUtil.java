/**  
 * 
 * @Title:  ResultVOUtil.java   
 * @Package com.amarsoft.springboot.utils   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月20日 下午11:30:35   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */  
package com.amarsoft.springboot.utils;

import com.amarsoft.springboot.VO.ResultVO;

/**   
 * @ClassName:  ResultVOUtil   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiangshanwen
 * @date:   2019年12月20日 下午11:30:35     
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved. 
 * 
 */
public class ResultVOUtil {

	/**   
	 * @Title:  ResultVOUtil   
	 * @Description:TODO(这里用一句话描述这个方法的作用)   
	 * @param:    
	 * @throws   
	 */
	public static ResultVO  success(Object object) {
		ResultVO resultVO=new ResultVO();
		resultVO.setCode(0);
		resultVO.setMsg("成功");
		resultVO.setData(object);
		return resultVO;
	}
	
	public static ResultVO success(){
		return success(null);
	}
	
	public static ResultVO error(Integer code,String msg){
		ResultVO resultVO =new ResultVO();
		resultVO.setCode(code);
		resultVO.setMsg(msg);
		return resultVO;
	}

}
