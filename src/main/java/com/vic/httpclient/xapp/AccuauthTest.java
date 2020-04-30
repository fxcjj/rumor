package com.vic.httpclient.xapp;

import com.vic.httpclient.HttpClientUtils;
import com.vic.utils.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Accuauth三方测试
 * @author 罗利华
 * date: 2019/12/5 15:32
 */
public class AccuauthTest {


    public final static Map<String, String> headerMap = new HashMap() {{
        put("X-DF-API-ID", "ebeacf7f79fe48adaa1b9e0d39e60ee1");
        put("X-DF-API-SECRET", "e073a6b8a4da433d923868ea582b0052");
    }};


    public static void main(String[] args) throws Exception {

        /*
        accuauth.api-id: ebeacf7f79fe48adaa1b9e0d39e60ee1
        accuauth.api-secret: e073a6b8a4da433d923868ea582b0052
        # 人脸比对
        accuauth.face-comparison-url: https://cloudapi.accuauth.com/face/v2/verify
        # 身份证ocr
        accuauth.ocr-url: https://cloudapi.accuauth.com/ocr/indian_card
        # aadhaar校验
        accuauth.verify-aadhaar-url: https://cloudapi.accuauth.com/verify/indian_aadhaar
        # pan校验
        accuauth.verify-pan-url: https://cloudapi.accuauth.com/verify/indian_pan
         */


        String aadhaar_front = "D:\\work\\india-product\\aadhaar-front1.jpg";
        String imageUrl = "D:\\work\\india-product\\aadhaar-face.png";
//        System.out.println(FileUtils.fileToBase64(imageUrl));

//        testLivenessAntiHack2_ok();
        testLivenessAntiHack();

//        testFace();

//        testBackOcr();

//        testFrontOcr();

//        testMask();

//        testOcrWithMask();
//        testVerifyAd();
//        testVerifyPan();
    }

    private static void testVerifyAd() {
        String url = "https://cloudapi.accuauth.com/verify/indian_aadhaar";

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("X-DF-API-ID", "ebeacf7f79fe48adaa1b9e0d39e60ee1");
        headerMap.put("X-DF-API-SECRET", "e073a6b8a4da433d923868ea582b0052");

        Map<String, String> map = new HashMap<>();
        map.put("aadhaar_no", "343098467001");

        long startTime = System.currentTimeMillis();
        String result = HttpClientUtils.sendPost(url, headerMap, map);
        System.out.println("result: " + result);
        System.out.println("elapsed time: " + (System.currentTimeMillis() - startTime));
    }

    private static void testVerifyPan() {
        String url = "https://cloudapi.accuauth.com/verify/indian_pan";

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("X-DF-API-ID", "ebeacf7f79fe48adaa1b9e0d39e60ee1");
        headerMap.put("X-DF-API-SECRET", "e073a6b8a4da433d923868ea582b0052");

        Map<String, String> map = new HashMap<>();
        map.put("pan", "EHJPM9082E");

        // 识别并返回打码图片
        long startTime = System.currentTimeMillis();
        String result = HttpClientUtils.sendPost(url, headerMap, map);
        System.out.println("result: " + result);
        System.out.println("elapsed time: " + (System.currentTimeMillis() - startTime));
    }


    private static void testOcrWithMask() {
        String url = "https://cloudapi.accuauth.com/ocr/indian_card_with_mask";

        // 识别并返回打码图片
        Map<String, String> map = new HashMap<>();
        map.put("image_base64", FileUtils.fileToBase64("D:\\work\\flashrupee-product\\ad-front.jpg"));
        long startTime = System.currentTimeMillis();
        String result = HttpClientUtils.sendPost(url, headerMap, map);
        System.out.println("elapsed time: " + (System.currentTimeMillis() - startTime));
    }


    private static void testMask() {
        String url = "https://cloudapi.accuauth.com/ocr/mask_indian_card";


        Map<String, String> param = new HashMap<>();
        param.put("image_base64", FileUtils.getBase64StrFromUrl("http://waterelephant.oss-cn-shanghai.aliyuncs.com/upload/backend/2020-01-05/61_86_01.jpg"));

        String result = HttpClientUtils.sendPost(url, headerMap, param);
        System.out.println(result);
    }

    private static void testLivenessAntiHack2_ok() throws Exception {
        String url = "https://cloudapi.accuauth.com/face/liveness_anti_hack";

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("X-DF-API-ID", "ebeacf7f79fe48adaa1b9e0d39e60ee1");
        headerMap.put("X-DF-API-SECRET", "e073a6b8a4da433d923868ea582b0052");

        // multipart信息
        Map<String, FileBody> multipartMap = new HashMap<>();
//        File frontImage = FileUtils.getFileByUrl("http://waterelephant.oss-cn-shanghai.aliyuncs.com/upload/backend/2020-01-05/61_3_03.jpg", "jpg");
//        System.out.println(frontImage.getName());

//        File file = new File("D:\\work\\flashrupee-product\\accuauth\\c395443a02684dc08499ff07ba623c56");
        File file = new File("D:\\work\\india-product\\accuauth\\aaaa");

        multipartMap.put("liveness_data_file", new FileBody(file, ContentType.IMAGE_JPEG, file.getName()));

        String result = HttpClientUtils.sendPostForMultipart(url, headerMap, multipartMap, null);

        System.out.println("result:" + result);

    }

    private static void testLivenessAntiHack() throws Exception {
        String url = "https://cloudapi.accuauth.com/face/liveness_anti_hack";

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("X-DF-API-ID", "ebeacf7f79fe48adaa1b9e0d39e60ee1");
        headerMap.put("X-DF-API-SECRET", "e073a6b8a4da433d923868ea582b0052");

        Map<String, String> paramMap = new HashMap<>();
//        paramMap.put("liveness_data_url", "http://waterelephant.oss-cn-shanghai.aliyuncs.com/upload/backend/2020-01-06/33_2_acf99534c3e34bf5bbb8cdbb5ef2e97c");
        paramMap.put("liveness_data_url", "http://waterelephant.oss-cn-shanghai.aliyuncs.com/upload/backend/2020-01-07/33_2_6f7f9c468187446dafaab9cd274c7401");

        String result = HttpClientUtils.sendPost(url, headerMap, paramMap);

        System.out.println("result:" + result);

    }

    private static void testLivenessAntiHack1() throws Exception {
        String url = "https://cloudapi.accuauth.com/face/liveness_anti_hack";

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("X-DF-API-ID", "ebeacf7f79fe48adaa1b9e0d39e60ee1");
        headerMap.put("X-DF-API-SECRET", "e073a6b8a4da433d923868ea582b0052");

        // multipart信息
        Map<String, FileBody> multipartMap = new HashMap<>();

        File frontImage = FileUtils.getFileByUrl("http://waterelephant.oss-cn-shanghai.aliyuncs.com/upload/backend/2019-11-28/34_03.jpg", "jpg");
        multipartMap.put("liveness_data_file", new FileBody(frontImage, ContentType.IMAGE_JPEG, "333_03"));

        // textBody信息
        Map<String, String> textBodyMap = new HashMap<>();

        String result = HttpClientUtils.sendPostForMultipart(url, headerMap, multipartMap, textBodyMap);

        System.out.println("result:" + result);

    }

    private static void testFace() throws Exception {
        String url = "https://cloudapi.accuauth.com/face/v2/verify";

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("X-DF-API-ID", "ebeacf7f79fe48adaa1b9e0d39e60ee1");
        headerMap.put("X-DF-API-SECRET", "e073a6b8a4da433d923868ea582b0052");


        String aa = "D:\\work\\online-issue\\图片相关\\196121_3_03.jpg";
        String bb = "D:\\work\\online-issue\\图片相关\\196121_86_01.jpg";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("image_base64_1", FileUtils.fileToBase64(aa));
        paramMap.put("image_base64_2", FileUtils.fileToBase64(bb));
        long startTime = System.currentTimeMillis();
        String result = HttpClientUtils.sendPost(url, headerMap, paramMap);
        System.out.println("elapsed time: " + (System.currentTimeMillis() - startTime));
        System.out.println("result:" + result);

        /*
        result:{
            "status":"OK","identical":true,"score":0.99998161,
            "request_id":"TID31d88f7553a74ea29e81e9855798834d","image_id_1":"980b88eb112940a6ae96236c26acea78",
            "image_id_2":"8f04d1786eea48de8746d50ac81d633b"
        }
         */
    }

    private static void testBackOcr() throws Exception {
        String url = "https://cloudapi.accuauth.com/ocr/indian_card";

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("X-DF-API-ID", "ebeacf7f79fe48adaa1b9e0d39e60ee1");
        headerMap.put("X-DF-API-SECRET", "e073a6b8a4da433d923868ea582b0052");

        // pan
//        String imageUrl = "D:\\work\\india-product\\advance\\pan-front2.jpg";

        // aadhaar
        String imageUrl = "D:\\work\\india-product\\advance\\pan-back.png";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("image_base64", FileUtils.fileToBase64(imageUrl));

        String result = HttpClientUtils.sendPost(url, headerMap, paramMap);

        System.out.println("result:" + result);
    }

    private static void testFrontOcr() throws Exception {
        String url = "https://cloudapi.accuauth.com/ocr/indian_card";

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("X-DF-API-ID", "ebeacf7f79fe48adaa1b9e0d39e60ee1");
        headerMap.put("X-DF-API-SECRET", "e073a6b8a4da433d923868ea582b0052");

        // pan
//        String imageUrl = "D:\\work\\india-product\\advance\\pan-front2.jpg";

        // aadhaar
        String imageUrl = "D:\\work\\india-product\\ad-front5.png";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("image_base64", FileUtils.fileToBase64(imageUrl));

        String result = HttpClientUtils.sendPost(url, headerMap, paramMap);

        /*
        aadhaar卡结果
        result:{
            "request_id":"TIDfae2764c110643e0bcfd9031747513fa","status":"OK","image_id":"6426e82f5d1441478af75f8bf4985ae6",
            "results":[
                {
                "card_info":{"card_no":"4444 5555 6666","date_info":"1990","date_type":"YOB","father_name":"","gender":"Female",
                "mother_name":"","name":"Sapna Singh","need_check":false,"phone_number":"","vid":""},
                "card_region":[[-9,35],[407,-1],[447,258],[12,300]],"card_side":"front","card_type":"aadhaar_card"
                }
            ]
        }

        pan卡结果
        result:{
            "request_id":"TID08c8c6095ff14d10b851c9a3cbb97ace",
            "status":"OK",
            "image_id":"518fadb509ff404990864e235df88121",
            "results":[
                {
                "card_info":{"card_no":"BNGPS0907J","date_info":"02/06/1950","date_type":"DOB","father_name":"SAMPATHIYENGAR",
                "issue_date":"10062007","name":"PARTHA SARATHY","need_check":false},
                "card_region":[
                    [-22,-5],[472,-5],[472,304],[-22,304]
                 ],
                 "card_side":"front",
                 "card_type":"pan_card"
                 }
            ]
        }



         */

        System.out.println("result:" + result);
    }

}
