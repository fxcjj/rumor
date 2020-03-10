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
        Properties properties = System.getProperties();
        Enumeration<?> enumeration = properties.propertyNames();
        while(enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
        /*
        java.runtime.name
        sun.boot.library.path
        java.vm.version
        java.vm.vendor
        java.vendor.url
        path.separator
        java.vm.name
        file.encoding.pkg
        user.script
        user.country
        sun.java.launcher
        sun.os.patch.level
        java.vm.specification.name
        user.dir
        java.runtime.version
        java.awt.graphicsenv
        java.endorsed.dirs
        os.arch
        java.io.tmpdir
        line.separator
        java.vm.specification.vendor
        user.variant
        os.name
        sun.jnu.encoding
        java.library.path
        java.specification.name
        java.class.version
        sun.management.compiler
        os.version
        user.home
        user.timezone
        java.awt.printerjob
        file.encoding
        java.specification.version
        user.name
        java.class.path
        java.vm.specification.version
        sun.arch.data.model
        java.home
        sun.java.command
        java.specification.vendor
        user.language
        awt.toolkit
        java.vm.info
        java.version
        java.ext.dirs
        sun.boot.class.path
        java.vendor
        file.separator
        java.vendor.url.bug
        sun.cpu.endian
        sun.io.unicode.encoding
        sun.desktop
        sun.cpu.isalist
         */
//        System.out.println(System.getProperty("user.dir"));

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
//        testLivenessAntiHack();

//        testFace();

//        testBackOcr();

//        testFrontOcr();

//        testMask();


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

//        File file = new File("D:\\work\\india-product\\accuauth\\c395443a02684dc08499ff07ba623c56");
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


        String aa = "D:\\work\\india-product\\aadhaar-front1.jpg";
        String bb = "D:\\work\\india-product\\aadhaar-face.png";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("image_base64_1", FileUtils.fileToBase64(aa));
        paramMap.put("image_base64_2", FileUtils.fileToBase64(bb));

        String result = HttpClientUtils.sendPost(url, headerMap, paramMap);

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
