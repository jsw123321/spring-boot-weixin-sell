/**  
 * 
 * @Title:  WeixinController.java   
 * @Package com.amarsoft.springboot.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月29日 下午2:21:00   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */  
package com.amarsoft.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**   
 * @ClassName:  WeixinController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiangshanwen
 * @date:   2019年12月29日 下午2:21:00     
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved. 
 * 
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
       
	@GetMapping("/authorize")
	public void auth(@RequestParam("code") String code){
		log.info("进入auth().......");
		log.info("code={}",code);    
		//@RequestParam("code") String code
	}
}
