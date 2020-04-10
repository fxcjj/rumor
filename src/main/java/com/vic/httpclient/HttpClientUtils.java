package com.vic.httpclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * apache httpclient 4.5.3测试
 * https://blog.csdn.net/N199109/article/details/23463527
 * https://blog.csdn.net/yitian_66/article/details/80512253
 * https://blog.csdn.net/jtf8525140/article/details/77862069
 * https://www.cnblogs.com/visec479/p/4820968.html
 *
 * TODO connection pool
 * @author 罗利华
 * date: 2019/7/23 15:11
 */
public class HttpClientUtils {

    private static RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(15000) //传输时间
            .setConnectTimeout(15000) //建立链接时间
            .setConnectionRequestTimeout(15000)
            .build();

    private HttpClientUtils() {
    }

    public static void main(String[] args) throws Exception {

        // login
        String token = testLogin();

        // invoke the method with CheckToken annotation
        beam(token);

        // invoke the method without CheckToken annotation
        khan();

        System.exit(0);
    }

    private static void khan() {
        String httpUrl = "http://localhost:1236/user/khan";

        String result = sendGet(httpUrl);
        System.out.println(result);
    }

    private static void beam(String token) {
        String httpUrl = "http://localhost:1236/user/beam";

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("token", token);

        String result = sendGet(httpUrl, headerMap);
        System.out.println(result);
    }

    private static String testLogin() {
        String loginUrl = "http://localhost:1236/user/login";

        // header
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("say", "haha");

        // request body
        Map<String, String> param = new HashMap<>();
        param.put("username", "u2");
        param.put("password", "p2");

        String loginResult = sendPost(loginUrl, headerMap, param);
        System.out.println(JSON.toJSONString(loginResult));

        JSONObject jsonObject = JSON.parseObject(loginResult);
        String token = jsonObject.getString("data");
        System.out.println("token: " + token);
        return token;
    }

    /**
     * 发送post请求
     * @param httpUrl
     * @return json格式
     */
    public static String sendPost(String httpUrl) {
        HttpPost httpPost = new HttpPost(httpUrl); //创建post请求
        return sendPost(httpPost);
    }

    /**
     * 发送post请求
     * @param httpUrl 地址
     * @param params 参数(格式:key1=value1&key2=value2)
     * @return
     */
    public String sendPost(String httpUrl, String params) {
        HttpPost httpPost = new HttpPost(httpUrl); // 创建httpPost
        try {
            //设置参数
            StringEntity stringEntity = new StringEntity(params, "UTF-8");
            stringEntity.setContentType("application/x-www-form-urlencoded");
            httpPost.setEntity(stringEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendPost(httpPost);
    }

    /**
     * 发送post请求
     * @param httpUrl
     * @param headerMap 请求头
     * @param param 参数key/value
     * @return
     */
    public static String sendPost(String httpUrl, Map<String, String> headerMap, Map<String, String> param) {
        HttpPost httpPost = new HttpPost(httpUrl); // 创建httpPost
        // 创建参数队列
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        if(param != null) {
            for (String key : param.keySet()) {
                nameValuePairs.add(new BasicNameValuePair(key, param.get(key)));
            }
        }

        // 添加请求头信息
        httpPost.addHeader("Connection", "keep-alive");
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Content-Type", "application/json");
        if (headerMap != null) {
            httpPost.setHeaders(assemblyHeader(headerMap));
        }

        try {
            // UrlEncodedFormEntity表示request-body
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendPost(httpPost);
    }

    /**
     * 发送post请求
     * @param httpPost
     * @return json格式
     */
    private static String sendPost(HttpPost httpPost) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String responseContent = null;
        try {

            // 创建默认的httpClient实例
            httpClient = HttpClients.createDefault();
            httpPost.setConfig(requestConfig);
            // 执行请求
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
            EntityUtils.consume(entity);
            System.out.println("sendPost 请求uri: " + httpPost.getURI());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭连接，释放资源
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

    /**
     * 发送get请求
     * @param httpUrl
     * @return
     */
    public static String sendGet(String httpUrl) {
        return sendGet(httpUrl, null);
    }

    /**
     * 发送get请求
     * @param httpUrl
     * @param headerMap 请求头
     * @return json格式
     */
    public static String sendGet(String httpUrl, Map<String, String> headerMap) {
        HttpGet httpGet = new HttpGet(httpUrl);// 创建get请求

        // 添加请求头信息
        httpGet.addHeader("Connection", "keep-alive");
        httpGet.addHeader("Accept", "application/json");
//        httpGet.addHeader("Content-Type", "application/json");
        if(headerMap != null) {
            httpGet.setHeaders(assemblyHeader(headerMap));
        }
        return sendGet(httpGet);
    }

    /**
     * 发送get请求
     * @param httpGet
     * @return json格式
     */
    private static String sendGet(HttpGet httpGet) {
        String responseContent = null;
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        try {
            // 创建默认的HttpClient实例
            httpclient = HttpClients.createDefault();
            httpGet.setConfig(requestConfig);
            response = httpclient.execute(httpGet);

            HttpEntity entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
            EntityUtils.consume(entity);
            System.out.println("sendGet 请求uri: " + httpGet.getURI());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpclient != null) {
                    httpclient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

    /**
     * 组装头部信息
     * @param headers
     * @return
     */
    public static Header[] assemblyHeader(Map<String, String> headers) {
        Header[] allHeader = new Header[headers.size()];
        int i = 0;
        for(String h : headers.keySet()) {
            allHeader[i] = new BasicHeader(h, headers.get(h));
            i++;
        }
        return allHeader;
    }

}
