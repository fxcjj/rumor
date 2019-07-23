package com.vic.httpclient;

import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;

public class HttpClientUtil1 {

	/**
	 * 创建连接
	 */
	private void createConnectionManager() {
		// 初始化HttpClient链接池
		PoolingHttpClientConnectionManager mgr = new PoolingHttpClientConnectionManager();
		// 设置连接池最大链接数
		mgr.setMaxTotal(300);
		// 设置链接主机的最大链接数（实际起作用的是DefaultMaxPerRoute而非MaxTotal,MaxTotal表示链接池大小，仅标识能存入多少链接
		// 而DefaultMaxPerRoute则代表同一时间最多能有多少链接访问主机）
		mgr.setDefaultMaxPerRoute(150);
		// 设置链接超时时间，ConnectTimeout链接建立三次握手时间，ConnectionRequestTimeout从连接池获取链接的时间，SocketTimeout数据传输过程中数据包传输之间最大的间隔时间
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(60000).setConnectionRequestTimeout(60000)
				.setSocketTimeout(60000).setExpectContinueEnabled(false).build();
		// 设置编码格式
		ConnectionConfig connectionConfig = ConnectionConfig.custom().setCharset(Charset.forName("UTF-8")).build();
		// 设置数据通信socket
		SocketConfig socketConfig = SocketConfig.custom().setSoKeepAlive(true).setTcpNoDelay(false).build();
		// http请求出错后重试接口
		HttpRequestRetryHandler retryHandler = new HttpRequestRetryHandler() {
			@Override
			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
				if (executionCount >= 3) { // 重试三次后停止
					return false;
				}
				if (exception instanceof NoHttpResponseException) { // NoHttpResponseException异常替换为exception异常
					return true;
				} else if (exception instanceof ClientProtocolException) { //ClientProtocolException异常替换为exception异常
					return true;
				} else if (exception instanceof SocketTimeoutException) { //SocketTimeoutException异常替换为exception异常 
					return true;
				}
				return false;
			}
		};

		CloseableHttpClient client = HttpClients.custom().setConnectionManager(mgr).setDefaultRequestConfig(requestConfig)
				.setDefaultConnectionConfig(connectionConfig).setDefaultSocketConfig(socketConfig)
				.setRetryHandler(retryHandler).build();
	}


}
