package com.fg716.service;

/**
 * @Date 2018年2月27日下午2:03:52
 * @author zhf
 * @Desc 微信服务接口
 */
public interface WeChatServiceI {

	/**
	 * @Date 2018年2月27日下午2:04:48
	 * @author zhf
	 * @param echostr
	 * @param nonce
	 * @param timestamp
	 * @param signature
	 * @Desc 校验信息
	 * @return
	 */
	String checkSignature(String signature, String timestamp, String nonce, String echostr);
}
