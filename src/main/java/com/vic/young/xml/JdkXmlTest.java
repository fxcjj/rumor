package com.vic.young.xml;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;

/**
 * 使用jdk中的api解析xml
 * 
 * @author Victor
 */
public class JdkXmlTest {

    public static void main(String[] args) throws Exception {
        
        //字符串转XML
        String str = "<a>字符串转XML</a>";
        StringReader sr = new StringReader(str);
        InputSource is = new InputSource(sr);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(is);
        
        //XML转字符串
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        
        Transformer t = transformerFactory.newTransformer();
        t.setOutputProperty("encoding", "UTF-8");
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        t.transform(new DOMSource(doc), new StreamResult(baos));
        String xmlStr = baos.toString();
        System.out.println(xmlStr);
       // 这里的XML DOCUMENT为org.w3c.dom.Document
        
        
    }

}
