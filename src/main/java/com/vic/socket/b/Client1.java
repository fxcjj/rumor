package com.vic.socket.b;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client1 {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("127.0.0.1", 9999);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String str = "你好，这是我的第一个socket";

        bufferedWriter.write(str);

        //刷新输入流
        bufferedWriter.flush();

        /**
         * socket.close() 将socket关闭连接，那边如果有服务端给客户端反馈信息，此时客户端是收不到的。
         * 而socket.shutdownOutput()是将输出流关闭，此时，如果服务端有信息返回，则客户端是可以正常接受的。
         */
        socket.shutdownOutput();

    }
}
