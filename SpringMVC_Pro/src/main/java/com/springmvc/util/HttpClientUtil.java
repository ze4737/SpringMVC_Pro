package com.springmvc.util;



import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class HttpClientUtil {/*

	*//**
	 * post方式提交表单（模拟用户登录请求）
	 *//*
	public static void postForm(String url, Map<String, String> param) {
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httppost = new HttpPost(url);
		// 创建参数队列
		List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
		Iterator<String> it = param.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			formparams.add(new BasicNameValuePair(key, param.get(key)));
		}
		UrlEncodedFormEntity uefEntity;
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);
			System.out.println("executing request " + httppost.getURI());
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					System.out.println("--------------------------------------");
					System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
					System.out.println("--------------------------------------");
				}
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void postForm() {
		//String url = "http://localhost:8080/open/api";
		String url = "http://localhost:8080/open/api?method=hahaha";
		HttpPost httppost = new HttpPost(url);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String json = "{\"mobile\":\"13316099117\", \"password\":\"512215\"}";
		StringEntity entity = new StringEntity(json, "utf-8");
		entity.setContentEncoding("UTF-8");    
        entity.setContentType("application/json"); 
        httppost.setEntity(entity);
//		List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
//		formparams.add(new BasicNameValuePair("mobile", "13316099117"));
//		formparams.add(new BasicNameValuePair("password", "512215"));
//		UrlEncodedFormEntity uefEntity;
        try {
//        	uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
//        	httppost.setEntity(uefEntity);
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					System.out.println("--------------------------------------");
					System.out.println("Response content: " + EntityUtils.toString(resEntity, "UTF-8"));
					System.out.println("--------------------------------------");
				}
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		HttpClientUtil.postForm();
	}
*/}
