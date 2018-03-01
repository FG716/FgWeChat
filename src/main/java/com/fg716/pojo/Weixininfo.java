package com.fg716.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.ebean.Model;

/**
 * @Date 2018年2月27日下午2:23:43
 * @author zhf
 * @Desc weixininfo表对象
 */
@Entity
@Table(name = "weixininfo")
public class Weixininfo extends Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6874539836602060242L;

	@Id
	private Integer id;

	private String appid;

	private String appsecret;

	private String token;

	private String accountid;

	private String backup;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getBackup() {
		return backup;
	}

	public void setBackup(String backup) {
		this.backup = backup;
	}

	public Weixininfo(Integer id, String appid, String appsecret, String token, String accountid) {
		super();
		this.id = id;
		this.appid = appid;
		this.appsecret = appsecret;
		this.token = token;
		this.accountid = accountid;
	}

	public Weixininfo() {
		super();
	}

}
