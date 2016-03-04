package com.springmvc.util;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetadataUtils {

	public static Map<String, String> formatMeta2Map(List<Map<String, Object>> metaList) {
		Map<String, String> rtnMetaMap =  null;
		if(metaList != null) {
			rtnMetaMap = new HashMap<String, String>();
			for(Map<String, Object> meta : metaList) {
				if(!StringUtils.isEmpty((String)meta.get("value"))){
					rtnMetaMap.put((String)meta.get("key"), (String)meta.get("value"));
				}
			}
		}
		return rtnMetaMap;
	}
}
