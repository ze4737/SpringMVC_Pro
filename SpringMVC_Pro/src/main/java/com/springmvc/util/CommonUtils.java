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
	 * ��ȡָ��λ���������
	 * @param strLength
	 * @return
	 */
	public static String getRandomNum(int strLength) {
		Random rm = new Random();
        // ��������
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);
        // ����õĻ�������ת��Ϊ�ַ���
        String fixLenthString = String.valueOf(pross);
        // ���ع̶��ĳ��ȵ������
        return fixLenthString.substring(1, strLength + 1);
    }
	
	/**
	 * ��ȡָ����Χ�ڵ��������
	 * @param min
	 * @param max
	 * @return
	 */
	public static String getRandomNum(int min, int max) {
		Random rm = new Random();
        return String.valueOf(rm.nextInt(max - min + 1)+min);
    }
	
	/**
	 * MD5����
	 * @param s
	 * @return
	 */
	public static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			//���MD5ժҪ�㷨�� MessageDigest ����
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			//ʹ��ָ�����ֽڸ���ժҪ
			mdInst.update(btInput);
			//�������
			byte[] md = mdInst.digest();
			//������ת����ʮ�����Ƶ��ַ�����ʽ
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
	 * ������JSON��ʽ����ת����Map
	 * @param jsonStr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseJSON2Map(String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		// ��������
		JSONObject json = JSONObject.fromObject(jsonStr);
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			// ����ڲ㻹������Ļ�����������
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
	 * ������Mapת����JSON
	 * @param map
	 * @return
	 */
	public static String parseMap2Json(Map<String, Object> map) {
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}
	
	/**
	 * ������ת����ָ����ʽ���ַ���
	 * @param date
	 * @param format
	 * @return
	 */
	public static String parseDate2String(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * ���ַ���ת����ָ����ʽ������
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
	 * ɾ���ַ�����β���ƶ��ַ�
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
	 * ����ָ��λ��С��
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
