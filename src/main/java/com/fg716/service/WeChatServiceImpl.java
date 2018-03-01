package com.fg716.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fg716.pojo.Weixininfo;
import com.fg716.utils.EncryptUtil;

import io.ebean.EbeanServer;

/**
 * @Date 2018年2月27日下午2:04:05
 * @author zhf
 * @Desc 微信服务接口实现类
 */
@Service("weChatService")
public class WeChatServiceImpl implements WeChatServiceI {

	@Autowired
	private EbeanServer ebeanServer;

	@SuppressWarnings("finally")
	@Override
	public String checkSignature(String signature, String timestamp, String nonce, String echostr) {
		String retrunString = null;
		try {
			// System.out.println("signature: " + signature);
			// System.out.println("timestamp: " + timestamp);
			// System.out.println("nonce: " + nonce);
			// System.out.println("echostr: " + echostr);
			// 从数据库中获取token
			Weixininfo weixininfo = ebeanServer.find(Weixininfo.class).findOne();
			String token = weixininfo.getToken();

			// 字典序排序
			List<String> list = new ArrayList<>();
			list.add(nonce);
			list.add(timestamp);
			list.add(token);

			Collections.sort(list);

			// 将token、timestamp、nonce三个参数进行字典序排序 2）将三个参数字符串拼接成一个字符串进行sha1加密
			// 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
			// sha1加密
			String addString = list.get(0) + list.get(1) + list.get(2);
			String sha1Created = EncryptUtil.toSHA1(addString.getBytes());
			System.out.println("generate sha1: " + sha1Created);
			System.out.println("signature: " + signature);

			// 比较
			if (signature.toUpperCase().equals(sha1Created)) {
				retrunString = echostr;
			}

		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		} finally {
			return retrunString;
		}

	}

}
