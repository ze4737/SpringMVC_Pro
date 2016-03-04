package com.springmvc.exception;

/**
 * 自定义插件异常
 * 用于插件数据校验错误信息返回
 * @author Administrator
 *
 */
public class PluginException extends Exception{

	public PluginException(String msg) {
		super(msg);
	}
}
