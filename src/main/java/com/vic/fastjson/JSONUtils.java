package com.vic.fastjson;

import com.alibaba.fastjson.JSON;

/**
 * @author 罗利华
 * date: 2020/3/14 14:02
 */
public class JSONUtils {

    public static boolean isJson(String content) {
        try {
            JSON.parseObject(content);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String objJsonStr = "{\"id\":1,\"name\":\"u1\"}";
        String arrJsonStr = "[{\"id\":1,\"name\":\"u1\"},{\"id\":2,\"name\":\"u2\"}]";
        String containListJsonStr = "{\"id\":1,\"name\":\"g1\",\"userList\":[{\"id\":1,\"name\":\"u1\"},{\"id\":2,\"name\":\"u2\"}]}";

        System.out.println(isJson(objJsonStr));
//        System.out.println(isJson(arrJsonStr));
        System.out.println(isJson(containListJsonStr));


    }


}
