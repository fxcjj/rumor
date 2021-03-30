package com.vic.httpclient.xapp;

import com.alibaba.fastjson.JSON;
import com.vic.httpclient.HttpClientUtils;
import com.vic.utils.FileUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Victor
 * date: 2019/12/5 15:32
 */
public class AdvanceTest {

    // 玫海-测试账号
    private static final String KEY = "14fa7f2fade5da23";
//    private static final String KEY = "e758a89c955d7322";

    // 玫海-正式账号
//    private static final String KEY = "45d711fec19139af";


    public static void main(String[] args) throws Exception {

//        System.out.println(CardType.A.name());
//        verifyAd();
//        verifyPan();

//        testMask1();
//        testFace();

        // 测试Advance接口
        testOcr1();
//        testOcr();
    }

    private static void verifyPan() {
        String url = "https://in-api.advance.ai/in/openapi/verification/v1/pan-status-check";
        // header信息
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("X-ADVAI-KEY", KEY);
        // param信息
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("pan", "EHJPM9082E");
//        paramMap.put("name", "SAVITHA LAVEENA MANEZES");
        paramMap.put("name", "LAVEENA MANEZES");
//        paramMap.put("birthday", "19940811");
        paramMap.put("birthday", "19941210");

        String result = HttpClientUtils.sendPostWithJson(url, headerMap, JSON.toJSONString(paramMap));
        System.out.println("result: " + result);
    }

    private static void verifyAd() {
        String url = "https://in-api.advance.ai/in/openapi/verification/v1/identity-check";
        // header信息
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("X-ADVAI-KEY", KEY);

        // param信息
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("aadhaarNumber", "235148621786");
        paramMap.put("name", "Amit Chandra Deshmukh");

        String result = HttpClientUtils.sendPostWithJson(url, headerMap, JSON.toJSONString(paramMap));
        System.out.println("result: " + result);
    }

    private static void testMask1() throws Exception {
        String url = "https://in-api.advance.ai/in/openapi/face-identity/v1/id-box-detection";


        // header信息
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("X-ADVAI-KEY", KEY);

        // multipart信息
        Map<String, FileBody> multipartMap1 = new HashMap<>();
//        File file = FileUtils.getFileByUrl("http://waterelephant.oss-cn-shanghai.aliyuncs.com/upload/backend/2020-01-05/61_86_01.jpg", "jpg");
        File file = new File("D:\\work\\india-product\\ad-back2.png");
        multipartMap1.put("image", new FileBody(file, ContentType.IMAGE_JPEG, file.getName()));

        // textBody信息
        Map<String, String> textBodyMap1 = new HashMap<>();
        textBodyMap1.put("resultType", "MASKED_IMAGE");

        String result = HttpClientUtils.sendPostForMultipart(url, headerMap, multipartMap1, textBodyMap1);

        System.out.println("result:" + result);

    }
    private static void testMask() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        //set the request uri and accessKey (please replace the accessKey with your accessKey)
        HttpPost httpPost = new HttpPost("https://in-api.advance.ai/in/openapi/face-identity/v1/id-box-detection");
        httpPost.setHeader("X-ADVAI-KEY", KEY);
        //set the parameters
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        File frontImage = FileUtils.getFileByUrl("http://waterelephant.oss-cn-shanghai.aliyuncs.com/upload/backend/2020-01-05/61_86_01.jpg", "jpg");

        builder.addPart("image", new FileBody(frontImage, ContentType.create("image/jpeg"), frontImage.getName()));
        builder.addTextBody("resultType", "MASKED_IMAGE");
        httpPost.setEntity(builder.build());
        //send the request
        HttpResponse httpResponse = client.execute(httpPost);

        String result = EntityUtils.toString(httpResponse.getEntity());

        System.out.println("result:" + result);

    }

    private static void testFace() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        //set the request uri and accessKey (please replace the accessKey with your accessKey)
        HttpPost httpPost = new HttpPost("https://in-api.advance.ai/in/openapi/face-identity/v1/face-comparison");
        httpPost.setHeader("X-ADVAI-KEY", KEY);
        //set the parameters
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        File firstImage = new File("D:\\work\\india-product\\ad-front5.png");
//        File secondImage = new File("D:\\work\\india-product\\face5.png");
        File secondImage = new File("D:\\work\\india-product\\face51.png");

        builder.addPart("firstImage", new FileBody(firstImage, ContentType.create("image/jpeg"), "frontImage"));
        builder.addPart("secondImage", new FileBody(secondImage, ContentType.create("image/jpeg"), "backImage"));
        httpPost.setEntity(builder.build());
        //send the request
        HttpResponse httpResponse = client.execute(httpPost);

        String result = EntityUtils.toString(httpResponse.getEntity());

        System.out.println("result:" + result);
    }

    public static void testOcr1() throws Exception {
        String url = "https://in-api.advance.ai/in/openapi/face-identity/v2/ocr";
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("X-ADVAI-KEY", KEY); // test
//        headerMap.put("X-ADVAI-KEY", "fb08d5b73ecd8c79"); // prod

        Map<String, FileBody> multipartMap = new HashMap<>();
//        File frontImage = new File("D:\\work\\india-product\\ad-front3.png");
        File frontImage = new File("D:\\work\\flashrupee-product\\测试图片\\测试图片\\2-1.jpg");
//        File backImage = new File("D:\\work\\india-product\\ad-back2.png");
        multipartMap.put("frontImage", new FileBody(frontImage, ContentType.create("image/jpeg"), frontImage.getName()));
//        multipartMap.put("backImage", new FileBody(backImage, ContentType.create("image/jpeg"), backImage.getName()));

        Map<String, String> textBodyMap = new HashMap<>();
        textBodyMap.put("cardType", "AADHAAR"); // PAN

        String result = HttpClientUtils.sendPostForMultipart(url, headerMap, multipartMap, textBodyMap);
        System.out.println("now: " + LocalDateTime.now() + ", result:" + result);

        /*
        testOcr1 result:{"code":"SUCCESS","message":"OK","data":{"result":{"birthday":"23/03/1981",
            "other":"S/O: Hasan Ali, 2350, Gali Near Madari, Rodgran Mohalla","addressAll":"S/O: Hasan Ali, 2350, Gali Near Madari,
                Rodgran Mohalla, Chandni Chowk, North Delhi, Delhi - 110006","gender":"MALE","pin":"110006","subdistrict":"Chandni Chowk",
            "district":"North Delhi","name":"Mehboob Rajput","state":"Delhi","idNumber":"390051307206"},"frontImageId":null,
            "backImageId":null},"extra":null,"transactionId":"a5dfd833f64d0af6","pricingStrategy":"PAY"}


         */
    }

    private static void testOcr() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        //set the request uri and accessKey (please replace the accessKey with your accessKey)
        HttpPost httpPost = new HttpPost("https://in-api.advance.ai/in/openapi/face-identity/v2/ocr");
        httpPost.setHeader("X-ADVAI-KEY", KEY);
        //set the parameters
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//        File frontImage = new File("D:\\work\\india-product\\ad-front.jpg");
//        File frontImage = new File("D:\\work\\flashrupee-product\\测试图片\\测试图片\\1-3.jpg");
        File frontImage = new File("D:\\work\\flashrupee-product\\测试图片\\测试图片\\bbb.jpg");
//        File backImage = new File("D:\\work\\india-product\\ad-back.jpg");

//        File backImage = new File("D:\\work\\india-product\\back.png");
//        File backImage = new File("D:\\work\\india-product\\segment.png"); //no
        builder.addPart("frontImage", new FileBody(frontImage, ContentType.create("image/jpeg"), "frontImage"));
//        builder.addPart("backImage", new FileBody(backImage, ContentType.create("image/jpeg"), "backImage"));
//        builder.addTextBody("cardType", "AADHAAR");
        builder.addTextBody("cardType", "PAN");
        httpPost.setEntity(builder.build());
        //send the request
        HttpResponse httpResponse = client.execute(httpPost);

        String result = EntityUtils.toString(httpResponse.getEntity());

        /*
        result:{"code":"SUCCESS","message":"OK","data":{"result":{"birthday":"1990","other":null,"addressAll":null,
            "gender":"Female","pin":null,"subdistrict":null,"district":null,"name":"Sapna Singh","state":null,"idNumber":"444455556666"},
            "frontImageId":null,"backImageId":null},"extra":null,"transactionId":"d6d2824fba51c985","pricingStrategy":"PAY"}
         */
        System.out.println("testOcr pan result:" + result);


    }
}
