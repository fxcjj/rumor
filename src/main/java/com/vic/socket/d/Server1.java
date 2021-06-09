package com.vic.socket.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

    public static void main(String[] args) throws Exception {

        // 初始化服务端socket并且绑定9999端口
        ServerSocket serverSocket = new ServerSocket(9999);

        while (true) {

            // 等待客户端的连接
            // 阻塞方法
            Socket socket = serverSocket.accept();

            new Thread(() -> {
                // 获取输入流,并且指定统一的编码格式
                BufferedReader bufferedReader = null;
                try {

                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                    // 读取一行数据
                    // 阻塞方法
                    String str;

                    //通过while循环不断读取信息
                    while ((str = bufferedReader.readLine()) != null) {

                        // 输出打印
                        System.out.println("客户端说：" + str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();


        }


    }
}
