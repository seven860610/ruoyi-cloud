/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.ruoyi.common.core.domain;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class P extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public P() {
		put("code", 0);
		put("msg", "success");
	}
	
	public static P error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static P error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static P error(int code, String msg) {
		P p = new P();
		p.put("code", code);
		p.put("msg", msg);
		return p;
	}

	public static P ok(String msg) {
		P p = new P();
		p.put("msg", msg);
		return p;
	}
	
	public static P ok(Map<String, Object> map) {
		P p = new P();
		p.putAll(map);
		return p;
	}
	
	public static P ok() {
		return new P();
	}

	public P put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
