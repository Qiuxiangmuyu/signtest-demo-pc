package com.zqsign.method.dependency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.net.URI;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;



public class HttpRequest {
	
	private static String encode = "UTF-8";
	
    /**
	 * 发送post请求
	 * @param url     请求地址
	 * @param formparams   formparams.add(new BasicNameValuePair(key, value))
	 * @throws IOException
	 */
	public static String sendPost(String url, List<NameValuePair> formparams) throws IOException {
		String result=null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).build();//.setSocketTimeout(120000)
		try {
			HttpPost httpPost = new HttpPost(url);
			httpPost.setConfig(requestConfig);
			httpPost.setEntity(new UrlEncodedFormEntity(formparams, encode));
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				System.out.println(response.getStatusLine());
				HttpEntity entity = response.getEntity();
				if(entity!=null){
					result = EntityUtils.toString(response.getEntity(),encode);
				}
				// do something useful with the response body
				// and ensure it is fully consumed
				EntityUtils.consume(entity);
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
		return StringUtil.replaceBlank(result);
	}
	/**
	 * 发送post请求
	 * @param url   请求地址
	 * @param params  请求参数Map<String, ? extends Object> params  Object可以为String或者File或者基本类型
	 * @throws IOException
	 */
	public static String sendPost(String url, Map<String, String> params) throws IOException {
		System.out.println(url);
		String result=null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).build();//.setSocketTimeout(120000)
		try {
			HttpPost httpPost = new HttpPost(url);
			httpPost.setConfig(requestConfig);
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			if (params != null && params.size() > 0) {
				for (Map.Entry<String, String> entry : params.entrySet()) {
					String key = entry.getKey();
					String value = params.get(key);
					formparams.add(new BasicNameValuePair(key, value));
				}
			}
			httpPost.setEntity(new UrlEncodedFormEntity(formparams, encode));
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				System.out.println(response.getStatusLine());
				HttpEntity entity = response.getEntity();
				if(entity!=null){
					result = EntityUtils.toString(response.getEntity(),encode);
				}
				// do something useful with the response body
				// and ensure it is fully consumed
				EntityUtils.consume(entity);
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
		return StringUtil.replaceBlank(result);
	}
	/**
	   * 发送post请求
	   * @param url   请求地址
	   * @param params  请求参数Map<String, ? extends Object> params  Object可以为String或者File或者基本类型
	   * @throws IOException
	   */
	  public static byte[] sendPostReturnByte(String url, Map<String, String> params) throws IOException {
	    byte[] result = new byte[1024];
	    CloseableHttpClient httpclient = HttpClients.createDefault();
	    RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).build();//.setSocketTimeout(120000)
	    try {
	      HttpPost httpPost = new HttpPost(url);
	      httpPost.setConfig(requestConfig);
	      List<NameValuePair> formparams = new ArrayList<NameValuePair>();
	      if (params != null && params.size() > 0) {
	        for (Map.Entry<String, String> entry : params.entrySet()) {
	          String key = entry.getKey();
	          String value = params.get(key);
	          formparams.add(new BasicNameValuePair(key, value));
	        }
	      }
	      httpPost.setEntity(new UrlEncodedFormEntity(formparams, encode));
	      CloseableHttpResponse response = httpclient.execute(httpPost);
	      try {
	        HttpEntity entity = response.getEntity();
	        if(entity!=null){
	          result = EntityUtils.toByteArray(entity);
	        }
	        EntityUtils.consume(entity);
	      } finally {
	        response.close();
	      }
	    } finally {
	      httpclient.close();
	    }
	    return result;
	  }
	public static String sendPost(String url, String param) throws IOException {
		String result=null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).build();//.setSocketTimeout(120000)
		try {
			HttpPost httpPost = new HttpPost(url);
			httpPost.setConfig(requestConfig);
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			if(!StringUtils.isBlank(param)){
    			String[] pps = param.split("&");
    			for (int i = 0; i < pps.length; i++) {
					int denghaoindex=pps[i].indexOf("=");
					formparams.add(new BasicNameValuePair(pps[i].substring(0,denghaoindex), pps[i].substring(denghaoindex+1)));
				}
    		}
			httpPost.setEntity(new UrlEncodedFormEntity(formparams, encode));
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				System.out.println(response.getStatusLine());
				HttpEntity entity = response.getEntity();
				if(entity!=null){
//					result = EntityUtils.toString(response.getEntity(),encode);
					result = EntityUtils.toString(response.getEntity());
				}
				// do something useful with the response body
				// and ensure it is fully consumed
				EntityUtils.consume(entity);
			} finally {
				response.close();
			}
		}finally {
			httpclient.close();
		}
		return StringUtil.replaceBlank(result);
	}
    
	
	public static String doGet(String url,Map<String, String> param) {
		//创建Httpclient对象
		CloseableHttpClient httpClient=HttpClients.createDefault();
		
		String resultString="";
		CloseableHttpResponse response = null;
		try {
			//创建uri
			URIBuilder builder =new URIBuilder(url);
			if (param != null ) {
				for(String key : param.keySet()){
					builder.addParameter(key, param.get(key));		
				}			
			}
			URI uri =builder.build();
			//创建http GET 请求
			HttpGet httpGet = new HttpGet(uri);
			//执行请求
			response =httpClient.execute(httpGet);
			//判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(),"UTF-8");				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if (response != null) {
					response.close();					
				}
				httpClient.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}
  
}