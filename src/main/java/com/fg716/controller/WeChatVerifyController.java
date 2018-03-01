package com.fg716.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fg716.service.WeChatServiceI;

/**
 * @Date 2018年2月27日下午1:58:17
 * @author zhf
 * @Desc 微信验证相关
 */
@RestController
public class WeChatVerifyController {

	@Autowired
	private WeChatServiceI weChatService;

	/**
	 * @Date 2018年2月27日下午2:00:45
	 * @author zhf
	 * @Desc 服务器配置
	 * @param signature
	 *            微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机数
	 * @param echostr
	 *            随机字符串
	 * @return
	 */
	@RequestMapping("wechatVerify/serverConfigVerify")
	public String serverConfigVerify(@RequestParam String signature, @RequestParam String timestamp,
			@RequestParam String nonce, @RequestParam String echostr) {

		return weChatService.checkSignature(signature, timestamp, nonce, echostr);

	}

}
