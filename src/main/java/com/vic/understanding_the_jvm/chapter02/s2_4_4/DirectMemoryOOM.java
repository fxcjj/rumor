package com.vic.understanding_the_jvm.chapter02.s2_4_4;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 *
 * 运行后报如下异常
 * "D:\Program Files\Java\jdk1.8.0_151\bin\java.exe" -Xmx20M -XX:MaxDirectMemorySize=10M "-javaagent:D:\Program Files\JetBrains\IntelliJ IDEA 2019.3.4\lib\idea_rt.jar=7946:D:\Program Files\JetBrains\IntelliJ IDEA 2019.3.4\bin" -Dfile.encoding=UTF-8 -classpath "D:\Program Files\Java\jdk1.8.0_151\jre\lib\charsets.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\deploy.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\ext\access-bridge-64.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\ext\cldrdata.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\ext\dnsns.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\ext\jaccess.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\ext\jfxrt.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\ext\localedata.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\ext\nashorn.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\ext\sunec.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\ext\sunjce_provider.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\ext\sunmscapi.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\ext\sunpkcs11.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\ext\zipfs.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\javaws.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\jce.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\jfr.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\jfxswt.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\jsse.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\management-agent.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\plugin.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\resources.jar;D:\Program Files\Java\jdk1.8.0_151\jre\lib\rt.jar;D:\github\rumor\target\classes;D:\repository\cn\afterturn\easypoi-base\4.1.0\easypoi-base-4.1.0.jar;D:\repository\org\apache\poi\poi\4.1.0\poi-4.1.0.jar;D:\repository\commons-codec\commons-codec\1.12\commons-codec-1.12.jar;D:\repository\org\apache\commons\commons-collections4\4.3\commons-collections4-4.3.jar;D:\repository\org\apache\commons\commons-math3\3.6.1\commons-math3-3.6.1.jar;D:\repository\org\apache\poi\poi-ooxml\4.1.0\poi-ooxml-4.1.0.jar;D:\repository\org\apache\commons\commons-compress\1.18\commons-compress-1.18.jar;D:\repository\com\github\virtuald\curvesapi\1.06\curvesapi-1.06.jar;D:\repository\org\apache\poi\poi-ooxml-schemas\4.1.0\poi-ooxml-schemas-4.1.0.jar;D:\repository\org\apache\xmlbeans\xmlbeans\3.1.0\xmlbeans-3.1.0.jar;D:\repository\com\google\guava\guava\16.0.1\guava-16.0.1.jar;D:\repository\ognl\ognl\3.2.6\ognl-3.2.6.jar;D:\repository\org\javassist\javassist\3.20.0-GA\javassist-3.20.0-GA.jar;D:\repository\org\slf4j\slf4j-api\1.6.1\slf4j-api-1.6.1.jar;D:\repository\javax\validation\validation-api\1.1.0.Final\validation-api-1.1.0.Final.jar;D:\repository\cn\afterturn\easypoi-web\4.1.0\easypoi-web-4.1.0.jar;D:\repository\org\springframework\spring-web\5.1.7.RELEASE\spring-web-5.1.7.RELEASE.jar;D:\repository\org\springframework\spring-beans\5.1.7.RELEASE\spring-beans-5.1.7.RELEASE.jar;D:\repository\org\springframework\spring-webmvc\5.1.7.RELEASE\spring-webmvc-5.1.7.RELEASE.jar;D:\repository\org\springframework\spring-aop\5.1.7.RELEASE\spring-aop-5.1.7.RELEASE.jar;D:\repository\org\springframework\spring-context\5.1.7.RELEASE\spring-context-5.1.7.RELEASE.jar;D:\repository\org\springframework\spring-expression\5.1.7.RELEASE\spring-expression-5.1.7.RELEASE.jar;D:\repository\cn\afterturn\easypoi-annotation\4.1.0\easypoi-annotation-4.1.0.jar;D:\repository\mysql\mysql-connector-java\8.0.15\mysql-connector-java-8.0.15.jar;D:\repository\com\google\protobuf\protobuf-java\3.6.1\protobuf-java-3.6.1.jar;D:\repository\com\amazonaws\aws-java-sdk-s3\1.11.95\aws-java-sdk-s3-1.11.95.jar;D:\repository\com\amazonaws\aws-java-sdk-kms\1.11.95\aws-java-sdk-kms-1.11.95.jar;D:\repository\com\amazonaws\aws-java-sdk-core\1.11.95\aws-java-sdk-core-1.11.95.jar;D:\repository\software\amazon\ion\ion-java\1.0.2\ion-java-1.0.2.jar;D:\repository\com\fasterxml\jackson\core\jackson-databind\2.6.6\jackson-databind-2.6.6.jar;D:\repository\com\fasterxml\jackson\core\jackson-annotations\2.6.0\jackson-annotations-2.6.0.jar;D:\repository\com\fasterxml\jackson\core\jackson-core\2.6.6\jackson-core-2.6.6.jar;D:\repository\com\fasterxml\jackson\dataformat\jackson-dataformat-cbor\2.6.6\jackson-dataformat-cbor-2.6.6.jar;D:\repository\joda-time\joda-time\2.8.1\joda-time-2.8.1.jar;D:\repository\com\amazonaws\jmespath-java\1.11.95\jmespath-java-1.11.95.jar;D:\repository\com\amazonaws\aws-java-sdk-sts\1.11.95\aws-java-sdk-sts-1.11.95.jar;D:\repository\org\apache\commons\commons-lang3\3.8.1\commons-lang3-3.8.1.jar;D:\repository\commons-beanutils\commons-beanutils\1.8.3\commons-beanutils-1.8.3.jar;D:\repository\commons-logging\commons-logging\1.1.1\commons-logging-1.1.1.jar;D:\repository\commons-io\commons-io\2.4\commons-io-2.4.jar;D:\repository\org\jsoup\jsoup\1.11.3\jsoup-1.11.3.jar;D:\repository\org\springframework\spring-core\5.1.5.RELEASE\spring-core-5.1.5.RELEASE.jar;D:\repository\org\springframework\spring-jcl\5.1.5.RELEASE\spring-jcl-5.1.5.RELEASE.jar;D:\repository\com\alibaba\fastjson\1.2.6\fastjson-1.2.6.jar;D:\repository\org\apache\httpcomponents\httpmime\4.5.10\httpmime-4.5.10.jar;D:\repository\org\apache\httpcomponents\httpclient\4.5.10\httpclient-4.5.10.jar;D:\repository\org\apache\httpcomponents\httpcore\4.4.12\httpcore-4.4.12.jar;D:\repository\cglib\cglib\2.2.2\cglib-2.2.2.jar;D:\repository\asm\asm\3.3.1\asm-3.3.1.jar" com.vic.understanding_the_jvm.chapter02.s2_4_4.DirectMemoryOOM
 * Exception in thread "main" java.lang.OutOfMemoryError
 * 	at sun.misc.Unsafe.allocateMemory(Native Method)
 * 	at com.vic.understanding_the_jvm.chapter02.s2_4_4.DirectMemoryOOM.main(DirectMemoryOOM.java:19)
 *
 *
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }

















}
