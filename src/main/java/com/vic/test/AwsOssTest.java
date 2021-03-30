package com.vic.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * @author:
 * date 2020/12/16 11:43
 */
public class AwsOssTest {


    Map<String, String> cfgMap = new HashMap<>();

    public AwsOssTest() {
        init();
    }

    private void init(){
        String json = "{" +
                "\"accessKeyId\":\"AKIAZZXB22UFR4ABINHX\"," +
                "\"accessKeySecret\":\"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\"," +
                "\"bucket\":\"wesaas-mch007-obs\"," +
                "\"endpoint\":\"s3-ap-south-1.amazonaws.com\"," +
                "\"policy\":\"{\\\"Version\\\":\\\"2012-10-17\\\",\\\"Statement\\\":[{\\\"Effect\\\":\\\"Allow\\\",\\\"Action\\\":\\\"s3:*\\\",\\\"Resource\\\":\\\"*\\\"}]}\"," +
                "\"region\":\"ap-south-1\"," +
                "\"roleArn\":\"arn:aws:iam::673709741323:role/osssts\"," +
                "\"roleSessionName\":\"wesaas-mch007-obs\"," +
                "\"urlPublic\":\"wesaas-mch007-obs.s3.ap-south-1.amazonaws.com/\"" +
            "}";
        JSONObject obj = JSON.parseObject(json);
        obj.keySet().forEach(k -> {
            cfgMap.put(k, obj.getString(k));
        });
    }
    public String getAccessKeyId(){
        return cfgMap.get("accessKeyId");
    }
    public String getAccessKeySecret(){
        return cfgMap.get("accessKeySecret");
    }
    public String getBucket(){
        return cfgMap.get("bucket");
    }
    public String getEndpoint(){
        return cfgMap.get("endpoint");
    }
    public String getPolicy(){
        return cfgMap.get("policy");
    }
    public String getRegion(){
        return cfgMap.get("region");
    }
    public String getRoleArn(){
        return cfgMap.get("roleArn");
    }
    public String getRoleSessionName(){
        return cfgMap.get("roleSessionName");
    }
    public String getUrlPublic(){
        return cfgMap.get("urlPublic");
    }

    protected AmazonS3 getClient() {
        Regions awsRegion = StringUtils.isBlank(getRegion()) ? Regions.AP_NORTHEAST_1 : Regions.fromName(getRegion());

        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(getAccessKeyId(), getAccessKeySecret());
        AWSCredentialsProvider awsProvider = new AWSStaticCredentialsProvider(awsCredentials);

        AmazonS3ClientBuilder awsBuilder = AmazonS3ClientBuilder.standard();
        ClientConfiguration conf = new ClientConfiguration();
        // 设置socket超时时间
        conf.setSocketTimeout(2 * 60 * 1000);
        AmazonS3 s3Client = awsBuilder.withRegion(awsRegion).withCredentials(awsProvider).withClientConfiguration(conf).build();

        return s3Client;
    }

    public String loadContent(String path) {
        String content = "";

        // 参数验证
        if (StringUtils.isBlank(path)) {
            return content;
        }

        // 数据转换
        String key = "";
        if (path.startsWith(getBucket())) {
            key = path.substring(getBucket().length() + 1);
        } else {
            key = path;
        }

        // 执行请求
        GetObjectRequest gutObjectRequest = new GetObjectRequest(getBucket(), key);
        S3Object object = getClient().getObject(gutObjectRequest);
        InputStream ins = object.getObjectContent();

        // 解析结果
        try {
            content = IOUtils.toString(ins, "utf-8");
        } catch (IOException e) {
            System.out.println("获取文件信息IO异常，异常信息：" + e.getMessage());
        }

        // 关闭资源
        IOUtils.closeQuietly(ins);

        return content;
    }


    public boolean upload(String key, InputStream ins) {
        // 参数验证
        if (StringUtils.isBlank(key)) {
            return false;
        }

        // 内容类型
        ObjectMetadata metadata = new ObjectMetadata();
        //metadata.setCacheControl("public, max-age=31536000");

        // 执行请求
        PutObjectRequest putObjectRequest = new PutObjectRequest(getBucket(), key, ins, metadata);
        List<Tag> tags = new ArrayList<Tag>();
        // tags.add(new Tag("PUBLIC-ACCESS", "TRUE"));
        tags.add(new Tag("PRIVATE-ACCESS", "TRUE"));
        putObjectRequest.setTagging(new ObjectTagging(tags));

        putObjectRequest.setCannedAcl(CannedAccessControlList.Private);

        PutObjectResult putObjectResult = getClient().putObject(putObjectRequest);

        // 关闭资源
        IOUtils.closeQuietly(ins);

        // 解析结果
        String etag = putObjectResult.getETag();

        System.out.println("执行方法结束, eTag:" + etag);

        return true;
    }

    public boolean upload(String key, String text) {
        // 参数验证
        if (StringUtils.isBlank(key) || StringUtils.isBlank(text)) {
            return false;
        }

        // 数据转换
        byte[] asBytes = text.getBytes();
        InputStream ins = new ByteArrayInputStream(asBytes);

        // 内容类型
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(asBytes.length);
        metadata.setContentType("text/plain");
        //metadata.setCacheControl("public, max-age=31536000");

        // 执行请求
        PutObjectRequest putObjectRequest = new PutObjectRequest(getBucket(), key, ins, metadata);
        List<Tag> tags = new ArrayList<Tag>();
        // tags.add(new Tag("PUBLIC-ACCESS", "TRUE"));
        tags.add(new Tag("PRIVATE-ACCESS", "TRUE"));
        putObjectRequest.setTagging(new ObjectTagging(tags));

        putObjectRequest.setCannedAcl(CannedAccessControlList.Private);

        PutObjectResult putObjectResult = getClient().putObject(putObjectRequest);

        // 关闭资源
        IOUtils.closeQuietly(ins);

        // 解析结果
        String etag = putObjectResult.getETag();

        System.out.println("执行方法结束, eTag: " + etag);

        return true;
    }

    public boolean append(String key, String text) {
        // 参数验证
        if (StringUtils.isBlank(key) || StringUtils.isBlank(text)) {
            return false;
        }

        AmazonS3 client = getClient();
        if(client.doesObjectExist(getBucket(), key)){
            text = loadContent(key) + text;
        }

        // 数据转换
        byte[] asBytes = text.getBytes();
        InputStream ins = new ByteArrayInputStream(asBytes);

        // 内容类型
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(asBytes.length);
        metadata.setContentType("text/plain");
        //metadata.setCacheControl("public, max-age=31536000");

        // 执行请求
        PutObjectRequest putObjectRequest = new PutObjectRequest(getBucket(), key, ins, metadata);
        List<Tag> tags = new ArrayList<Tag>();
        // tags.add(new Tag("PUBLIC-ACCESS", "TRUE"));
        tags.add(new Tag("PRIVATE-ACCESS", "TRUE"));
        putObjectRequest.setTagging(new ObjectTagging(tags));

        putObjectRequest.setCannedAcl(CannedAccessControlList.Private);
        PutObjectResult putObjectResult = client.putObject(putObjectRequest);

        // 关闭资源
        IOUtils.closeQuietly(ins);

        // 解析结果
        String etag = putObjectResult.getETag();

        System.out.println("执行方法结束, eTag: " + etag);

        return true;
    }

/*

    public Map<String, String> getStsToken() {
        Map<String, String> respMap = new HashMap<>();

        String awsRegion = StringUtils.isBlank(getRegion()) ? Regions.AP_NORTHEAST_1.getName() : getRegion();

        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(getAccessKeyId(), getAccessKeySecret());
        AWSCredentialsProvider awsProvider = new AWSStaticCredentialsProvider(awsCredentials);

        AWSSecurityTokenServiceClientBuilder awsBuilder = AWSSecurityTokenServiceClientBuilder.standard();

        AwsClientBuilder.EndpointConfiguration awsConfiguration
                = new AwsClientBuilder.EndpointConfiguration(getStsEndpoint(), awsRegion);

        AWSSecurityTokenService stsClient = awsBuilder.withEndpointConfiguration(awsConfiguration)
                .withCredentials(awsProvider).build();

        if(!StringUtils.isBlank(stsRoleArn)){
            if (StringUtils.isEmpty(stsPolicy)) {
                Policy policy = new Policy();
                policy.withStatements(new Statement(Statement.Effect.Allow).withActions(S3Actions.ListObjects)
                        .withResources(new Resource(stsRoleArn)));
                stsPolicy = policy.toJson();
            }

            AssumeRoleRequest assumeRole = new AssumeRoleRequest().withRoleArn(stsRoleArn)
                    .withRoleSessionName(stsRoleSessionName).withPolicy(stsPolicy);

            stsClient.assumeRole(assumeRole);
            //credentials = stsClient.assumeRole(assumeRole).getCredentials();
        }
        // 临时凭证的有效期范围是 900 秒 (15 分钟) 到 129600 秒 (36 小时)。如果不指定有效期，则默认使用 43200 秒（12 小时）
        GetSessionTokenRequest getSessionTokenRequest = new GetSessionTokenRequest().withDurationSeconds(7200);
        GetSessionTokenResult sessionTokenResult = stsClient.getSessionToken(getSessionTokenRequest);

        Credentials credentials = sessionTokenResult.getCredentials();

        */
/*
        // 使用临时服务凭证创建S3客户端
        BasicSessionCredentials sessionCredentials = new BasicSessionCredentials(
                credentials.getAccessKeyId(),
                credentials.getSecretAccessKey(),
                credentials.getSessionToken());

        AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(sessionCredentials))
                .withRegion(region)
                .build();
        *//*


        respMap.put("accessKeyId", credentials.getAccessKeyId());
        respMap.put("accessKeySecret", credentials.getSecretAccessKey());
        respMap.put("securityToken", credentials.getSessionToken());
        respMap.put("expiration", credentials.getExpiration().toString());
        respMap.put("urlPublic", urlPublic);
        respMap.put("endpoint", endpoint);
        respMap.put("region", region);
        respMap.put("bucket", bucket);

        return respMap;
    }
*/

    public String fmtObjUrl(String key) {
        return fmtObjUrl(key, 30L);
    }
    public String fmtObjUrl(String key, Long minute) {

        if (StringUtils.isBlank(key)) {
            return "";
        }

        String objUrl = "";
        // 设置临时访问路径有效期为30分钟
        Date expiration = new Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * minute;
        expiration.setTime(expTimeMillis);
        URL url = null;
        // 获取文件临时访问路径
        try{
            GeneratePresignedUrlRequest generatePresignedUrlRequest =
                    new GeneratePresignedUrlRequest(getBucket(), key)
                            .withMethod(HttpMethod.GET)
                            .withExpiration(expiration);

            url = getClient().generatePresignedUrl(generatePresignedUrlRequest);
            objUrl = url.toString();
        } catch (Exception e){
            System.out.println("获取文件访问临时签名URL异常，异常信息: " + e.getMessage());
        }
        return objUrl;
    }

    /**
     * 生成公共访问路径，此方法只适用于公共读写文件权限
     *
     * @param key
     * @return
     */
    public String fmtObjUrlPublic(String key) {

        if (StringUtils.isBlank(key)) {
            return "";
        }

        return getUrlPublic() + key;
    }


    public byte[] loadFile(String path) {
        byte[] bytes = null;

        // 参数验证
        if (StringUtils.isBlank(path)) {
            return bytes;
        }

        // 数据转换
        String key = "";
        if (path.startsWith(getBucket())) {
            key = path.substring(getBucket().length() + 1);
        } else {
            key = path;
        }

        // 执行请求
        GetObjectRequest gutObjectRequest = new GetObjectRequest(getBucket(), key);
        S3Object object = getClient().getObject(gutObjectRequest);
        InputStream ins = object.getObjectContent();

        // 解析结果
        try {
            bytes = IOUtils.toByteArray(ins);
        } catch (IOException e) {
            System.out.println("获取文件信息IO异常，异常信息：" + e.getMessage());
        }

        // 关闭资源
        IOUtils.closeQuietly(ins);
        return bytes;
    }

    public static void main(String[] args) {
        AwsOssTest test = new AwsOssTest();

        /*
        String key = "test/njfc/upload/89988" + System.currentTimeMillis() + ".csv";
        System.out.println(key);
        System.out.println(test.append(key, "ssdssdsdsdsds,asd\n"));
        System.out.println(test.append(key, "\n555555,asd"));
        System.out.println(test.fmtObjUrl(key));
        */

        String pathList = "wesaas/merchant/loan/credit/upload/identity/2020-12-17/CM0071339593637381812225_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-17/CM0071339593614716051457_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-17/CM0071339593867703885825_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-17/CM0071339594090656051201_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-17/CM0071339594095467175937_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-17/CM0071339594435751059457_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-17/CM0071339594758611546113_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-17/CM0071339594790857613313_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-17/CM0071339594959267307521_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-17/CM0071339595143644459009_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-17/CM0071339595175034630145_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-17/CM0071339595222015029249_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339639520681271297_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339639637450694657_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339639879306846209_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339640100644204545_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339640179036004353_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339640363925118977_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339640365913219073_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339640609513943041_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339640574231457793_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339640700547375105_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339640784559284225_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339640836421595137_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339641012116795393_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339640974900994049_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339640874338361345_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339641552376705025_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339641680437452801_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339642441900503041_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339642622461095937_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339642670934925313_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339643158107271169_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339643178177015809_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339645521560084481_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339645824644685825_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339646004844310529_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339646435435753473_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339647250041151489_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339647805757071361_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339648317990383617_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339648929004265473_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339648934620180481_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339649303685378049_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339649666979213313_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339649730007019521_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339651357309149185_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339651626419888129_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339595252805672961_3.png,wesaas/merchant/loan/credit/upload/identity/2020-12-18/CM0071339495449597587457_3.png";String[] paths = pathList.split(",");

        try {
            for(String path : paths) {
                File f = new File("D:\\tmp\\" + path);
                f.getParentFile().mkdirs();
                FileUtils.writeByteArrayToFile(f, test.loadFile(path));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

//        System.out.println(test.fmtObjUrl("file/trans/cuilingxian/20201218/ghy/1608288377335_ba1bf02d8bbd027dfb3d588c0932f6db.xlsx", 7 * 24 * 60L));
//        System.out.println(test.fmtObjUrl("file/trans/cuilingxian/20201218/ghy/1608288392470_b802421d0bdf3f1dcee5577e34197003.xlsx", 7 * 24 * 60L));
//        boolean exit = true;
//        if(exit) {
//            return;
//        }
//        System.out.println(test.uploanNjfc("D:\\NJFC\\file\\印度金融文件\\cashfree_nbfc\\payment_202011_luwenjie@beadwallet.com.xlsx", "ghy"));
//        System.out.println(test.uploanNjfc("D:\\NJFC\\file\\印度金融文件\\cashfree_nbfc\\payout_202011_luwenjie@beadwallet.com.xlsx", "ghy"));

//        System.out.println(sb2.toString());
    }
}
