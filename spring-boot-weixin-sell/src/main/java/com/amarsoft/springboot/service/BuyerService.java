/**  
 * 
 * @Title:  BuyerService.java   
 * @Package com.amarsoft.springboot.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月22日 下午1:38:17   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */  
package com.amarsoft.springboot.service;

import com.amarsoft.springboot.VO.ResultVO;
import com.amarsoft.springboot.dto.OrderDTO;

/**   
 * @ClassName:  BuyerService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiangshanwen
 * @date:   2019年12月22日 下午1:38:17     
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved. 
 * 
 */
public interface BuyerService {
        //查询一个订单
	    OrderDTO findOrderOne(String openid,String orderId);
	    //取消一个订单
	    OrderDTO cancleOrder(String openid,String orderId);
}
