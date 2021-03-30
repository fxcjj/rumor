package com.vic.httpclient.xapp;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * 闪云工具类
 *
 * @author Victor
 * date: 2020/9/24 10:01
 */
public class FlashCloudUtils {

    /**
     * 按参数名称升序，将参数值进行连接 签名  参数为空的不参与签名
     **/
    public static String getSign(JSONObject data, String appSecretKey) {
        // appSecretKey为签名秘钥
        // data为其他接口参数
        data.put("appSecret", appSecretKey);
        StringBuilder signParam = new StringBuilder();
        Object[] keys = data.keySet().toArray();
        Arrays.sort(keys);
        for (Object key : keys) {
            if ("sign".equals(key)) {
                continue;
            }
            Object valueObject = data.get(key);
            if (valueObject != null && !valueObject.getClass().isAssignableFrom(JSONObject.class)) {
                String value = valueObject.toString();
                if (StringUtils.isNotBlank(value)) {
                    signParam.append(key).append(value);
                }
            }
        }
        String sign = DigestUtils.sha1Hex(signParam.toString());
        data.remove("appSecret");
        return sign;
    }



    public void aadhaarVerifyTest() throws Exception {
        /*JSONObject jsonObject = new JSONObject();
        jsonObject.put(AADHAAR_NO, "***");
        jsonObject.put("appId", "***");
        jsonObject.put(TIMESTAMP, System.currentTimeMillis());
        jsonObject.put(NONCE, UUID.randomUUID().toString());
        String sign = getSign(jsonObject, "***");
        jsonObject.put(SIGN, sign);
        RequestBody requestBody = RequestBody.create(JSON, jsonObject.toJSONString());
        Request request = new Request.Builder()
                .url(URL)
                .addHeader("Content-Type", "application/json")
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());*/
    }


}
