package com.springmvc.service;

import com.springmvc.exception.PluginException;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseService {
	
	/**
	 * 主方法
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> process(Map<String, Object> param) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		//通常逻辑数据校验
		if(!this.validation(param)) {
			rtnMap.put("response", false);
			rtnMap.put("error_response", param.get("error_response"));
			return rtnMap;
		} else {
			try {
				rtnMap.put("response", this.execute(param));
				rtnMap.put("error_response", false);
			} catch(PluginException pe) {
				//插件数据校验异常
				Map<String, Object> rtnMsgMap = new HashMap<String, Object>();
				rtnMsgMap.put("message", pe.getMessage());
				rtnMap.put("response", false);
				rtnMap.put("error_response", rtnMsgMap);
			}
			return rtnMap;
		}
	}
	
	/**
	 * 数据校验方法
	 * @param param
	 * @return
	 */
	public boolean validation(Map<String, Object> param) throws Exception {
		return true;
	}
	
	/**
	 * 逻辑主方法
	 * @param param
	 * @return
	 */
	public abstract Map<String, Object> execute(Map<String, Object> param) throws Exception;
	
	/**
	 * 设置返回错误信息
	 * @param param
	 * @param msg
	 */
	public void setErrMsg(Map<String, Object> param, String msg) {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		rtnMap.put("message", msg);
		param.put("error_response", rtnMap);
	}
	
	/**
	 * 执行扩展功能插件
	 * @param plugWhere
	 * @param param
	 * @throws Exception 
	 */
	public void doPlugin(String plugWhere, Map<String, Object> param) throws Exception {
//		PluginsHandler.doPlugin(plugWhere, param);
	}
}
