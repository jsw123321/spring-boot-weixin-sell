/**  
 * 
 * @Title:  WechatMpConfig.java   
 * @Package com.amarsoft.springboot.config   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月29日 下午6:20:53   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */  
package com.amarsoft.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;

/**   
 * @ClassName:  WechatMpConfig   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiangshanwen
 * @date:   2019年12月29日 下午6:20:53     
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved. 
 * 
 */
@Component
public class WechatMpConfig {
      
	@Autowired
	private WechatAccountConfig accountConfig;
	
	@Bean
	public WxMpService wxMpService(){
		WxMpService wxMpservice=new WxMpServiceImpl();
		wxMpservice.setWxMpConfigStorage(wxMpConfigStorage());
		return wxMpservice;
	}
	
	@Bean
	public WxMpConfigStorage wxMpConfigStorage(){
		WxMpInMemoryConfigStorage wxMpInMeConfigStorage=new  WxMpInMemoryConfigStorage();
		wxMpInMeConfigStorage.setAppId(accountConfig.getMpAppId());
		wxMpInMeConfigStorage.setSecret(accountConfig.getMpAppSecret());
		return wxMpInMeConfigStorage;
	}
}
