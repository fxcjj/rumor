package com.vic.httpclient.xapp;

import com.alibaba.fastjson.JSONObject;
import com.vic.httpclient.HttpClientUtils;
import com.vic.utils.FileUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Victor
 * date: 2019/12/5 15:32
 */
public class FlashCloudTest {

    public static final String APP_ID = "dJZh4s4GDYf205HF";
    public static final String APP_SECRET = "8928860T3wG0rg4A";

    public static final String OCR_URL = "https://api.riskcloud.in/v3/cardOcr";
    public static final String PAN_VERIFY_URL = "https://api.riskcloud.in/v3/panVerify";
    public static final String AD_VERIFY_URL = "https://api.riskcloud.in/v3/aadhaarVerify";
    public static final String MOSAIC_URL = "https://api.riskcloud.in/v3/cardMosaic";
    public static final String FACE_URL = "https://api.riskcloud.in/v3/faceMatch";
    public static final String QUERY_URL = "https://api.riskcloud.in/query/${serviceType}/${reportId}";



    public static void main(String[] args) throws Exception {



        testPan();
//        testAd();

//        testOcrPanFront();

//        testOcrAdFront();

//        testMask();

//        testFaceAndX();

//        testQueryForPan();
//        testQueryForAd();

    }

    /**
     * result:{"reportId":"8YLseP6b76b7315mn8u5","statusCode":0,"statusMessage":"E_SUCCESS","IP":"218.81.81.18",
     * "data":{"errorCode":6000,"errMessage":"E_AADHAAR_SUCCESS","ageRange":"40-50","gender":"MALE","idNumber":"400247350289","phoneNumber":"961","state":"Uttar Pradesh"}}
     * @throws Exception
     */
    private static void testQueryForAd() throws Exception {
        // https://api.riskcloud.in/query/${serviceType}/${reportId}
        String url = "https://api.riskcloud.in/v3/query/AADHAAR_VERIFY/8YLseP6b76b7315mn8u5";
        // 调用ocr接口
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("reportId", "8YLseP6b76b7315mn8u5");
        jsonObject.put("signKey", APP_ID);
        jsonObject.put("timestamp", System.currentTimeMillis());
        jsonObject.put("nonce", UUID.randomUUID().toString());
        //getSign方法见接口规范验签部分
        String sign = FlashCloudUtils.getSign(jsonObject, APP_SECRET);
        jsonObject.put("sign", sign);
        String result = HttpClientUtils.sendPostWithJson(url, null, jsonObject.toJSONString());
        System.out.println("result:" + result);

    }

    private static void testQueryForPan() throws Exception {
        // https://api.riskcloud.in/query/${serviceType}/${reportId}
        String url = "https://api.riskcloud.in/v3/query/PAN_VERIFY/18vOH052087774b29q51";
        // 调用ocr接口
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("reportId", "18vOH052087774b29q51");
        jsonObject.put("signKey", APP_ID);
        jsonObject.put("timestamp", System.currentTimeMillis());
        jsonObject.put("nonce", UUID.randomUUID().toString());
        //getSign方法见接口规范验签部分
        String sign = FlashCloudUtils.getSign(jsonObject, APP_SECRET);
        jsonObject.put("sign", sign);
        String result = HttpClientUtils.sendPostWithJson(url, null, jsonObject.toJSONString());
        System.out.println("result:" + result);

    }

    private static void testFaceAndX() throws Exception {

        // 调用ocr接口
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("image1", FileUtils.getBase64StrFromUrl("http://waterelephant.oss-cn-shanghai.aliyuncs.com/upload/backend/2020-01-05/61_86_01.jpg"));
        jsonObject.put("image1", FileUtils.fileToBase64("D:\\work\\flashrupee-product\\测试图片\\pic2\\4-1.png"));
        jsonObject.put("image1Type", "BASE64");
//        jsonObject.put("image2", FileUtils.getBase64StrFromUrl("http://waterelephant.oss-cn-shanghai.aliyuncs.com/upload/backend/2020-01-05/61_86_01.jpg"));
        jsonObject.put("image2", FileUtils.fileToBase64("D:\\work\\flashrupee-product\\测试图片\\pic2\\4-2.png"));
        jsonObject.put("image2Type", "BASE64");
        jsonObject.put("signKey", APP_ID);
        jsonObject.put("timestamp", System.currentTimeMillis());
        jsonObject.put("nonce", UUID.randomUUID().toString());
        //getSign方法见接口规范验签部分
        String sign = FlashCloudUtils.getSign(jsonObject, APP_SECRET);
        jsonObject.put("sign", sign);
        String result = HttpClientUtils.sendPostWithJson(FACE_URL, null, jsonObject.toJSONString());
        System.out.println("result:" + result);
    }

    private static void testMask() throws Exception {

        // 调用ocr接口
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cardType", "AADHAAR_FRONT");
//        jsonObject.put("image", FileUtils.getBase64StrFromUrl("http://waterelephant.oss-cn-shanghai.aliyuncs.com/upload/backend/2020-01-05/61_86_01.jpg"));
        jsonObject.put("image", FileUtils.fileToBase64("D:\\work\\flashrupee-product\\测试图片\\1120_861.png"));
        jsonObject.put("signKey", APP_ID);
        jsonObject.put("timestamp", System.currentTimeMillis());
        jsonObject.put("nonce", UUID.randomUUID().toString());
        //getSign方法见接口规范验签部分
        String sign = FlashCloudUtils.getSign(jsonObject, APP_SECRET);
        jsonObject.put("sign", sign);
        String result = HttpClientUtils.sendPostWithJson(MOSAIC_URL, null, jsonObject.toJSONString());
        System.out.println("result:" + result);
    }

    private static void testOcrAdFront() throws Exception {
        // 调用ocr接口
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cardType", "AADHAAR_FRONT");
        jsonObject.put("image", FileUtils.getBase64StrFromUrl("http://waterelephant.oss-cn-shanghai.aliyuncs.com/upload/backend/2020-01-05/61_86_01.jpg"));
        jsonObject.put("signKey", APP_ID);
        jsonObject.put("timestamp", System.currentTimeMillis());
        jsonObject.put("nonce", UUID.randomUUID().toString());
        //getSign方法见接口规范验签部分
        String sign = FlashCloudUtils.getSign(jsonObject, APP_SECRET);
        jsonObject.put("sign", sign);
        String result = HttpClientUtils.sendPostWithJson(OCR_URL, null, jsonObject.toJSONString());
        System.out.println("result:" + result);


    }
    private static void testOcrPanFront() throws Exception {
        // 调用ocr接口
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cardType", "PAN_FRONT");
        jsonObject.put("image", FileUtils.getBase64StrFromUrl("https://waterelephant.oss-cn-shanghai.aliyuncs.com/loan/credit/upload/sfrz/2020-06-18/1320_96.png"));
        jsonObject.put("signKey", APP_ID);
        jsonObject.put("timestamp", System.currentTimeMillis());
        jsonObject.put("nonce", UUID.randomUUID().toString());
        //getSign方法见接口规范验签部分
        String sign = FlashCloudUtils.getSign(jsonObject, APP_SECRET);
        jsonObject.put("sign", sign);
        String result = HttpClientUtils.sendPostWithJson(OCR_URL, null, jsonObject.toJSONString());
        System.out.println("result:" + result);


    }

    private static void testAd() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("uid", "123456");
        jsonObject.put("aadhaarNo", "400247350289");
        jsonObject.put("signKey", APP_ID);
        jsonObject.put("timestamp", System.currentTimeMillis());
        jsonObject.put("nonce", UUID.randomUUID().toString());
        jsonObject.put("callbackUrl", "http://victor.free.idcfengye.com/sb01/fc/cb/panVerify1");
        // 获取签名
        String sign = FlashCloudUtils.getSign(jsonObject, APP_SECRET);
        jsonObject.put("sign", sign);

        Map<String, String> headerMap = new HashMap<>();
        String result = HttpClientUtils.sendPostWithJson("https://api.riskcloud.in/v3/aadhaarVerify", headerMap, jsonObject.toJSONString());
        System.out.println("result: " + result);
    }

    private static void testPan1() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("uid", "123456");
        jsonObject.put("panCode", "FLEPP3937F");
        jsonObject.put("dateOfBirth", "01/01/1998");
        jsonObject.put("fullName", "MAHESH PODHILA");
//        jsonObject.put("fullName", "KAMAL LOCHAN MALIK");
        jsonObject.put("signKey", APP_ID);
        jsonObject.put("timestamp", System.currentTimeMillis());
        jsonObject.put("nonce", UUID.randomUUID().toString());
        jsonObject.put("callbackUrl", "http://victor.free.idcfengye.com/sb01/fc/cb/panVerify1");
        // 获取签名
        String sign = FlashCloudUtils.getSign(jsonObject, APP_SECRET);
        jsonObject.put("sign", sign);

        System.out.println("sign: " + sign);

        Map<String, String> headerMap = new HashMap<>();
//        headerMap.put("Content-Type", "application/json");
        String result = HttpClientUtils.sendPostWithJson(PAN_VERIFY_URL, headerMap, jsonObject.toJSONString());
        System.out.println("result: " + result);
    }

    private static void testPan() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("uid", "123456");
        jsonObject.put("panCode", "HRMPS9999A");
        jsonObject.put("dateOfBirth", "01/01/1963");
        jsonObject.put("fullName", "BEDEDULA SRINIVASA");
        jsonObject.put("signKey", APP_ID);
        jsonObject.put("timestamp", System.currentTimeMillis());
        jsonObject.put("nonce", UUID.randomUUID().toString());
        jsonObject.put("callbackUrl", "http://victor.free.idcfengye.com/sb01/fc/cb/panVerify1?mer=M001");
        // 获取签名
        String sign = FlashCloudUtils.getSign(jsonObject, APP_SECRET);
        jsonObject.put("sign", sign);

        System.out.println("sign: " + sign);

        Map<String, String> headerMap = new HashMap<>();
//        headerMap.put("Content-Type", "application/json");
        String result = HttpClientUtils.sendPostWithJson(PAN_VERIFY_URL, headerMap, jsonObject.toJSONString());
        System.out.println("result: " + result);
    }
}
