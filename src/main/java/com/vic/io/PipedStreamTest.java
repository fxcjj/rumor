package com.vic.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 四
 * Piped流测试
 * 
 * @author Victor
 */
public class PipedStreamTest {
    public static void main(String[] args) {
        Sender t1 = new Sender();
        Receiver t2 = new Receiver();
        PipedOutputStream out = t1.getOutputStream();
        PipedInputStream in = t2.getInputStream();
        try {
            //管道连接，与out.connect(in)一毛一样
            in.connect(out);
            
            t1.start();
            t2.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 接收者
 * @author Victor
 */
class Receiver extends Thread {
    //管道输入流对象
    private PipedInputStream in = new PipedInputStream();
    //获取in
    public PipedInputStream getInputStream() {
        return in;
    }
    
    @Override
    public void run() {
        readMessageOnce();
//        readMessageContinued();
    }

    private void readMessageOnce() {
        //private static final int DEFAULT_PIPE_SIZE = 1024;
        //此处的2048无用，默认是1024
        byte [] buf = new byte[2048];
        try {
            int len = in.read(buf);
            System.out.println(new String(buf, 0, len));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //从管道输入流读取>1024个字节时，就停止读取
    private void readMessageContinued() {
        int total = 0;
        while(true) {
            byte[] buf = new byte[1024];
            try {
                int len = in.read(buf);
                total += len;
                System.out.println(new String(buf, 0, len));
                //读取的字节总数>1024，则退出循环
                if(total > 1024) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 发送者
 * 
 * @author Victor
 */
class Sender extends Thread {
    //管道输出流
    private PipedOutputStream out = new PipedOutputStream();
    //获取out
    public PipedOutputStream getOutputStream() {
        return out;
    }
    
    @Override
    public void run() {
//        writeShortMessage();
        writeLongMessage();
    }

    //向out中写入简短消息
    private void writeShortMessage() {
        String info = "short message";
        try {
            out.write(info.getBytes());  
            out.close();     
        } catch (IOException e) {
            e.printStackTrace();     
        }
    }
  
    //向out中写入长消息
    private void writeLongMessage() {
        StringBuilder sb = new StringBuilder();
        // 通过for循环写入1020个字节  
        for (int i=0; i<102; i++)  
            sb.append("0123456789");  
        // 再写入26个字节。  
        sb.append("abcdefghijklmnopqrstuvwxyz");  
        // str的总长度是1020+26=1046个字节  
        String str = sb.toString();  
        try {  
            // 将1046个字节写入到“管道输出流”中  
            out.write(str.getBytes());  
            out.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
    
}
