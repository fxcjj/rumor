package com.vic.httpclient.xapp.nano;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * 摩比工具类
 * @author Victor
 * date: 2020/10/26 13:44
 */
public class NanoDataUtils {

    /**
     * 签名
     * @param jsonData
     * @param appSecret
     * @param appId
     * @return
     */
    public static String getSign(String jsonData, String appSecret, String appId) {
        return DigestUtils.md5Hex(jsonData + appSecret + appId);
    }

    /**
     * 验证手机格式
     * @param mobile
     * @return
     */
    public static boolean checkIndiaMobile(String mobile){
        String regexStr = "^[6-9][0-9]{9}$";
        if(StringUtils.isBlank(mobile) || !Pattern.matches(regexStr,mobile)){
            return false;
        }
        return true;
    }

}
