package com.example.demo.entity;

import java.io.Serializable;


/**
 * 统一的JSON返回对象
 * 
 * @author ldh
 * @date 2018年4月20日
 * @version 1.0.0
 *
 */
public class JsonResult implements Serializable{

	private static final long serialVersionUID = 1L;
	// 成功返回码
	public static final int SUCCESS = 10000000;
	// 失败返回码
	public static final int FAILURE = 10000001;
	
	// 成功返回消息
	public static final String SUCCESS_MSG = "成功";
	// 通用异常返回消息
	public static final String ERROR_MSG = "系统异常";
	// 参数异常返回消息
	public static final String PARAM_ERROR_MSG = "无效的参数";

	// 返回码
	private Integer code;
	// 返回消息
	private String msg;
	// 返回数据
	private Object data;

	/**
	 * 构造并返回自定义内容的JSON对象
	 * 
	 * @param code 返回码
	 * @param msg 返回消息
	 * @param data 返回数据
	 * @return {@link JsonResult} 对象
	 */
	public JsonResult create(Integer code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
		return this;
	}
	/**
	 * 构造并返回自定义内容的JSON对象，返回数据将会设置为<b>NULL</b>
	 * 
	 * @param code 返回码
	 * @param msg 返回消息
	 * @return {@link JsonResult} 对象
	 */
	public JsonResult create(Integer code, String msg) {
		return create(code, msg, null);
	}
	
	// 成功返回模板
	/**
	 * 构造并返回请求成功的JSON对象，返回码将会被设置为 <b>10000000</b>
	 *  
	 * @param msg 返回消息
	 * @param data 返回数据
	 * @return {@link JsonResult} 对象
	 */
	public JsonResult success(String msg, Object data) {
		return create(SUCCESS, msg, data);
	}
	/**
	 * 构造并返回请求成功的JSON对象，返回码将会被设置为 <b>10000000</b>，
	 * 返回消息将会设置为默认成功消息（SUCCESS_MSG）
	 * 
	 * @param data 返回数据
	 * @return {@link JsonResult} 对象
	 */
	public JsonResult success(Object data) {
		return create(SUCCESS, SUCCESS_MSG, data);
	}
	/**
	 * 构造并返回请求成功的JSON对象，返回码将会被设置为 <b>10000000</b>，
	 * 返回消息将会设置为<b>默认成功消息</b>（SUCCESS_MSG），返回数据将会
	 * 设置为<b>NULL</b>
	 * 
	 * @return {@link JsonResult} 对象
	 */
	public JsonResult success() {
		return create(SUCCESS, SUCCESS_MSG, null);
	}

	// 通用异常返回模板
	/**
	 * 构造并返回通用请求失败的JSON对象，返回码将会被设置为 <b>19999999</b>
	 *
	 * @param msg 返回消息
	 * @param data 返回数据
	 * @return {@link JsonResult} 对象
	 */
	public JsonResult failure(String msg, Object data) {
		return create(FAILURE, msg, data);
	}
	/**
	 * 构造并返回通用请求失败的JSON对象，返回码将会被设置为 <b>19999999</b>，
	 * 返回消息将会设置为<b>默认失败消息</b>（ERROR_MSG）
	 *
	 * @param data 返回数据
	 * @return {@link JsonResult} 对象
	 */
	public JsonResult failure(Object data) {
		return create(FAILURE, ERROR_MSG, data);
	}
	/**
	 * 构造并返回通用请求失败的JSON对象，返回码将会被设置为 <b>19999999</b>，
	 * 返回数据将会设置为<b>NULL</b>
	 *
	 * @param msg 返回消息
	 * @return {@link JsonResult} 对象
	 */
	public JsonResult failure(String msg) {
		return create(FAILURE, msg, null);
	}
	/**
	 * 构造并返回通用请求失败的JSON对象，返回码将会被设置为 <b>19999999</b>，
	 * 返回消息将会设置为<b>默认失败消息</b>（ERROR_MSG），返回数据将会设置
	 * 为<b>NULL</b>
	 *
	 * @return {@link JsonResult} 对象
	 */
	public JsonResult failure() {
		return create(FAILURE, ERROR_MSG, null);
	}

	// 参数异常模板
	/**
	 * 构造并返回参数异常请求失败的JSON对象，返回码将会被设置为 <b>19999998</b>
	 *
	 * @param msg 返回消息
	 * @param data 返回数据
	 * @return {@link JsonResult} 对象
	 */
	public JsonResult paramFailure(String msg, Object data) {
		return create(FAILURE, msg, data);
	}
	/**
	 * 构造并返回参数异常请求失败的JSON对象，返回码将会被设置为 <b>19999998</b>，
	 * 返回消息将会设置为<b>默认参数异常消息</b>(PARAM_ERROR_MSG)
	 *
	 * @param data 返回数据
	 * @return {@link JsonResult} 对象
	 */
	public JsonResult paramFailure(Object data) {
		return create(FAILURE, PARAM_ERROR_MSG, data);
	}
	/**
	 * 构造并返回参数异常请求失败的JSON对象，返回码将会被设置为 <b>19999998</b>，
	 * 返回数据将会设置为<b>NULL</b>
	 *
	 * @param msg 返回消息
	 * @return {@link JsonResult} 对象
	 */
	public JsonResult paramFailure(String msg) {
		return create(FAILURE, msg, null);
	}
	/**
	 * 构造并返回参数异常请求失败的JSON对象，返回码将会被设置为 <b>19999998</b>，
	 * 返回消息将会设置为<b>默认参数异常消息</b>(PARAM_ERROR_MSG)，返回数据将
	 * 会设置为<b>NULL</b>
	 *
	 * @return {@link JsonResult} 对象
	 */
	public JsonResult paramFailure() {
		return create(FAILURE, PARAM_ERROR_MSG, null);
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
