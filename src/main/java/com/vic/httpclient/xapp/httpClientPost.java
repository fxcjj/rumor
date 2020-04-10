package com.vic.httpclient.xapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.security.SignatureException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class httpClientPost {

    /*
    sensetime:
  app_id: e98745fc90e34f7eb8afc93b07815c8f
  app_secret: 15f656ef2512457abce4b5a704891d98
  app_name: GX火力卡
  #  照片对比 活体检测 阈值
  limit_value: 0.7f
     */

      public static final String filepath1="D:\\work\\光信普惠\\compare\\a.jpg";//图片1路径
      public static final String filepath2="D:\\work\\光信普惠\\compare\\b.png";//图片2路径
      public static final String POST_URL = "https://v2-auth-api.visioncloudapi.com/identity/image_verification/stateless";

      public static void HttpClientPost() throws Exception {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost post = new HttpPost(POST_URL);
            FileBody fileBody1 = new FileBody(new File(filepath1));
            FileBody fileBody2 = new FileBody(new File(filepath2));
            MultipartEntity entity = new MultipartEntity();
            entity.addPart("first_image_file", fileBody1);
            entity.addPart("second_image_file", fileBody2);
            post.setEntity(entity);

          String authorization = null;
          try {
              authorization = SenseTimeUtils.getAuthorization("e98745fc90e34f7eb8afc93b07815c8f", "15f656ef2512457abce4b5a704891d98");
          } catch (SignatureException e) {
              e.printStackTrace();
          }

            post.setHeader("Authorization", authorization);//请将AUTHORIZATION替换为根据API_KEY和API_SECRET得到的签名认证串
            HttpResponse response = httpclient.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entitys = response.getEntity();
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(entitys.getContent()));
                String line = reader.readLine();
                System.out.println(line);
            }else{
                HttpEntity r_entity = response.getEntity();
                String responseString = EntityUtils.toString(r_entity);
                System.out.println("错误码是："+response.getStatusLine().getStatusCode()+"  "+response.getStatusLine().getReasonPhrase());
                System.out.println("出错原因是："+responseString);
                //你需要根据出错的原因判断错误信息，并修改
            }

            httpclient.getConnectionManager().shutdown();
      }


    public static void main(String[] args) throws Exception {
        HttpClientPost();
    }
}