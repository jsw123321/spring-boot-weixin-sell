/**  
 * 
 * @Title:  KeyUtils.java   
 * @Package com.amarsoft.springboot.utils   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月15日 下午1:47:15   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */  
package com.amarsoft.springboot.utils;

import java.util.Random;

/**   
 * @ClassName:  KeyUtils   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiangshanwen
 * @date:   2019年12月15日 下午1:47:15     
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved. 
 * 
 */
public class KeyUtils {

	/**   
	 * @Title:  KeyUtils   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:    
	 * @throws   
	 */
   public static synchronized String getUniqueKey(){
	    long  localtime=System.currentTimeMillis();
	    Random random=new Random();
	    Integer number=random.nextInt(900000)+100000;
	    return localtime+String.valueOf(number);
   }
    
	public KeyUtils() {
		// TODO Auto-generated constructor stub
	}

}
