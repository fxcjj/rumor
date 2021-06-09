package com.vic.socket.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

    public static void main(String[] args) throws Exception {

        // 初始化服务端socket并且绑定9999端口
        ServerSocket serverSocket = new ServerSocket(9999);

        // 等待客户端的连接
        // 阻塞方法
        Socket socket = serverSocket.accept();

        // 获取输入流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // 读取一行数据
        // 阻塞方法
        String str = bufferedReader.readLine();

        // 输出打印
        System.out.println(str);


    }
}
