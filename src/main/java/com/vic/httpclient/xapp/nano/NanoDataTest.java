package com.vic.httpclient.xapp.nano;

import com.alibaba.fastjson.JSON;
import com.vic.httpclient.HttpClientUtils;
import com.vic.httpclient.HttpUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Victor
 * date: 2020/10/27 10:03
 */
public class NanoDataTest {
    static String test_optSendUrl = "https://sandbox.peaksecurity.in/api/v1/mobile/otp_send";
    static String prod_optSendUrl = "http://api.peaksecurity.in/api/v1/mobile/otp_send";
    static String my_prod_optSendUrl = "http://106.14.249.159:8101/api/v1/mobile/otp_send";
    static String get_details = "https://sandbox.peaksecurity.in/api/v1/mobile/get_details";

    static String api_id = "gaojie@beadwallet.com";
    static String test_api_secret = "D<=2XfV>*1j$K2x&WN";
    static String prod_api_secret = "xJBA[*#za#6-Q{1Vc8";


    public static void main(String[] args) throws Exception {
//        test1();

//        test2();

//        test3();

//        test4();

        testGetDetails();

    }

    private static void testGetDetails() throws IOException {
        Map<String, String> paramMap = new HashMap<>(16);
        paramMap.put("session_id", "e10d0599-51fc-4648-8cbe-da0cba3c29a0");
        paramMap.put("otp", "5269");

        String jsonParam = JSON.toJSONString(paramMap);
        Map<String, String> headerMap = new HashMap<>(16);
        headerMap.put("x-m-app-id", api_id);
        headerMap.put("x-m-signature", NanoDataUtils.getSign(jsonParam, test_api_secret, api_id));

        String post = HttpClientUtils.sendPostWithJson(get_details, headerMap, jsonParam);
        System.out.println(post);
    }

    private static void test4() throws IOException {
        Map<String, String> param = new HashMap<>();
        param.put("mobile", "7406012638");

        String sign = NanoDataUtils.getSign(JSON.toJSONString(param), test_api_secret, api_id);
        Map<String, String> header = new HashMap<>();
        header.put("x-m-app-id", api_id);
        header.put("x-m-signature", sign);
        String post = HttpClientUtils.sendPostWithJson(test_optSendUrl, header, JSON.toJSONString(param));
        System.out.println(post);
    }

    private static void test3() {


        Map<String, String> param = new HashMap<>();
        param.put("mobile", "7406012638");

        String sign = NanoDataUtils.getSign(JSON.toJSONString(param), prod_api_secret, api_id);
        Map<String, String> header = new HashMap<>();
        header.put("x-m-app-id", api_id);
        header.put("x-m-signature", sign);

//        String post = AbstractFeather.doPost(prod_optSendUrl, header, "utf-8");
//        System.out.println(post);
    }

    private static void test2() throws Exception {

        Map<String, String> param = new HashMap<>();
        param.put("mobile", "7406012638");

        String sign = NanoDataUtils.getSign(JSON.toJSONString(param), prod_api_secret, api_id);
        Map<String, String> header = new HashMap<>();
        header.put("x-m-app-id", api_id);
        header.put("x-m-signature", sign);

        String post = HttpUtil.post(prod_optSendUrl, header, JSON.toJSONString(param));
        System.out.println(post);

    }

    private static void test1() {
        Map<String, String> param = new HashMap<>();
        param.put("mobile", "7406012638");

        String sign = NanoDataUtils.getSign(JSON.toJSONString(param), test_api_secret, api_id);
        Map<String, String> header = new HashMap<>();
        header.put("x-m-app-id", api_id);
        header.put("x-m-signature", sign);

        String s = HttpClientUtils.sendPostWithJson(test_optSendUrl, header, JSON.toJSONString(param));
        System.out.println(s);

    }


}
