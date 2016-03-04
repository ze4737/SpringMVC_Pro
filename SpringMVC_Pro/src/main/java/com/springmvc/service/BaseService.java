package com.springmvc.service;

import com.springmvc.exception.PluginException;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseService {
	
	/**
	 * ������
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> process(Map<String, Object> param) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		//ͨ���߼�����У��
		if(!this.validation(param)) {
			rtnMap.put("response", false);
			rtnMap.put("error_response", param.get("error_response"));
			return rtnMap;
		} else {
			try {
				rtnMap.put("response", this.execute(param));
				rtnMap.put("error_response", false);
			} catch(PluginException pe) {
				//�������У���쳣
				Map<String, Object> rtnMsgMap = new HashMap<String, Object>();
				rtnMsgMap.put("message", pe.getMessage());
				rtnMap.put("response", false);
				rtnMap.put("error_response", rtnMsgMap);
			}
			return rtnMap;
		}
	}
	
	/**
	 * ����У�鷽��
	 * @param param
	 * @return
	 */
	public boolean validation(Map<String, Object> param) throws Exception {
		return true;
	}
	
	/**
	 * �߼�������
	 * @param param
	 * @return
	 */
	public abstract Map<String, Object> execute(Map<String, Object> param) throws Exception;
	
	/**
	 * ���÷��ش�����Ϣ
	 * @param param
	 * @param msg
	 */
	public void setErrMsg(Map<String, Object> param, String msg) {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		rtnMap.put("message", msg);
		param.put("error_response", rtnMap);
	}
	
	/**
	 * ִ����չ���ܲ��
	 * @param plugWhere
	 * @param param
	 * @throws Exception 
	 */
	public void doPlugin(String plugWhere, Map<String, Object> param) throws Exception {
//		PluginsHandler.doPlugin(plugWhere, param);
	}
}
