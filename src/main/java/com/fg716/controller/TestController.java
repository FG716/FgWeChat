package com.fg716.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fg716.pojo.Weixininfo;

import io.ebean.EbeanServer;

/**
 * @Date 2018年2月27日下午3:10:28
 * @author zhf
 * @Desc 测试
 */
@RestController
public class TestController {
	@Autowired
	private EbeanServer ebeanServer;

	@RequestMapping("/test")
	public String test() {
		// Weixininfo weixininfo = ebeanServer.find(Weixininfo.class).findOne();
		return "{\"test\":\"test\"}";

	}
}
