/**  
 * 
 * @Title:  WechatMpController.java   
 * @Package com.amarsoft.springboot.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月29日 下午6:14:12   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */  
package com.amarsoft.springboot.controller;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amarsoft.springboot.enums.ResultEnum;
import com.amarsoft.springboot.exception.SellException;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;

/**   
 * @ClassName:  WechatMpController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiangshanwen
 * @date:   2019年12月29日 下午6:14:12     
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved. 
 * 
 */
@RestController
@RequestMapping("/wechat")
@Data
@Slf4j
public class WechatMpController {
      
	@Autowired
	private WxMpService wxchatMpService;
	
	@GetMapping("/authorize")
	public String authorize(@RequestParam("returnUrl") String returnUrl){
		//1.配置
		//2.调用
		String url="http://selljsw.natapp1.cc/selljsw/wechat/userInfo";
		String redirectUrl=wxchatMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_BASE, URLEncoder.encode(returnUrl));
		return "redirect:"+redirectUrl;
	}
	
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                         @RequestParam("state") String returnUrl) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxchatMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}", e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }

        String openId = wxMpOAuth2AccessToken.getOpenId();

        return "redirect:" + returnUrl + "?openid=" + openId;
    }
}
