package com.springmvc.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtils {

	/**
	 * 获取指定位数随机整数
	 * @param strLength
	 * @return
	 */
	public static String getRandomNum(int strLength) {
		Random rm = new Random();
        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);
        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);
        // 返回固定的长度的随机数
        return fixLenthString.substring(1, strLength + 1);
    }
	
	/**
	 * 获取指定范围内的随机整数
	 * @param min
	 * @param max
	 * @return
	 */
	public static String getRandomNum(int min, int max) {
		Random rm = new Random();
        return String.valueOf(rm.nextInt(max - min + 1)+min);
    }
	
	/**
	 * MD5加密
	 * @param s
	 * @return
	 */
	public static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			//获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			//使用指定的字节更新摘要
			mdInst.update(btInput);
			//获得密文
			byte[] md = mdInst.digest();
			//把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str).toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 将复杂JSON格式数据转换成Map
	 * @param jsonStr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseJSON2Map(String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 最外层解析
		JSONObject json = JSONObject.fromObject(jsonStr);
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			// 如果内层还是数组的话，继续解析
			if (v instanceof JSONArray) {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				Iterator<JSONObject> it = ((JSONArray) v).iterator();
				while (it.hasNext()) {
					JSONObject json2 = it.next();
					list.add(parseJSON2Map(json2.toString()));
				}
				map.put(k.toString(), list);
			} else if (v instanceof JSONObject) {
				map.put(k.toString(), parseJSON2Map(v.toString()));
			} else {
				map.put(k.toString(), v);
			}
		}
		return map;
	}
	
	/**
	 * 将复杂Map转换成JSON
	 * @param map
	 * @return
	 */
	public static String parseMap2Json(Map<String, Object> map) {
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}
	
	/**
	 * 将日期转换成指定格式的字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String parseDate2String(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * 将字符串转换成指定格式的日期
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException 
	 */
	public static Date parseString2Date(String strDate, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(strDate);
	}
	
	/**
	 * 删除字符串首尾的制定字符
	 * @param str
	 * @param removeStr
	 * @return
	 */
	public static String removeStartAndEnd(String str, String removeStr) {
		str = StringUtils.removeStart(str, removeStr);
		str = StringUtils.removeEnd(str, removeStr);
		return str;
	}
	
	/**
	 * 保留指定位数小数
	 * @param num
	 * @param i
	 * @return
	 */
	public static double round(double num, int i) {
		BigDecimal bd = new BigDecimal(num);
		return bd.setScale(i, BigDecimal.ROUND_UP).doubleValue();
	}
	
	public static void main(String[] args) throws Exception {
		//System.out.println(parseString2Date("2015-01-18 00:00:00", "yyyy-MM-dd HH:mm:ss").getTime());
		double num = 123456.116389;
		System.out.println(round(num, 3));
//		Random rand = new Random();
//		int randNum = rand.nextInt(22)+5;
//		System.out.println(rand.nextInt(9000)+1000);
	}
}
