package com.vic.young.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * http
 * @author Victor
 */
public class HttpClientTest {
	
	public static void main(String[] args) throws Exception, IOException {
		
//		get();
		post();
		

	}

	private static void get() {
		
		String url = "http://localhost:8080/restfulexample/rest/json/cardiovascular/get";
		
//		String url = "http://www.baidu.com/";
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			//创建http get请求
			HttpGet httpGet = new HttpGet(url);
			
			System.out.println("executing request " + httpGet.getURI()); 
			
			//执行get请求
			CloseableHttpResponse response = httpclient.execute(httpGet);
			
			try {
				//获取响应状态
				System.out.println(response.getStatusLine());
				//状态码 200成功
				System.out.println(response.getStatusLine().getStatusCode());
				//获取响应内容
				HttpEntity entity = response.getEntity(); //包装了服务器的响应内容
				
				// 打印响应内容长度    
                System.out.println("Response content length: " + entity.getContentLength());  
				
				//entity转换为string
			    System.out.println(EntityUtils.toString(entity/*,"utf-8"*/));
			    
			} finally {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void post() {
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		try {
		    HttpPost httpPost = new HttpPost("http://localhost:8080/restfulexample/rest/json/cardiovascular/login");
		    
	//	    httpPost.setEntity(entity);
		    
		    List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		    nvps.add(new BasicNameValuePair("name", "lihua.luo"));
		    nvps.add(new BasicNameValuePair("psw", "aaa"));
				httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		    CloseableHttpResponse response2 = httpClient.execute(httpPost);
	
		    try {
		        System.out.println(response2.getStatusLine());
		        HttpEntity entity2 = response2.getEntity();
		        
			    System.out.println(EntityUtils.toString(entity2/*,"utf-8"*/));
		        // do something useful with the response body and ensure it is fully consumed
//		        EntityUtils.consume(entity2);
		    } finally {
		        response2.close();
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
