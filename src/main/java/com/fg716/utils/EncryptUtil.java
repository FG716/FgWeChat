package com.fg716.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Date 2018年2月27日下午3:43:07
 * @author zhf
 * @Desc 加密工具类
 */
public class EncryptUtil {

	/**
	 * @Date 2018年2月27日下午3:43:13
	 * @author zhf
	 * @Desc byte array to sha1
	 * @param convertme
	 * @return
	 */
	public static String toSHA1(byte[] convertme) {
		final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] buf = md.digest(convertme);
		char[] chars = new char[2 * buf.length];
		for (int i = 0; i < buf.length; ++i) {
			chars[2 * i] = HEX_CHARS[(buf[i] & 0xF0) >>> 4];
			chars[2 * i + 1] = HEX_CHARS[buf[i] & 0x0F];
		}
		return new String(chars);
	}
}
