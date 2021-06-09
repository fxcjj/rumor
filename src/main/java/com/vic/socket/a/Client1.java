package com.vic.socket.a;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client1 {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("127.0.0.1", 9999);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String str = "你好，这是我的第一个socket";

        bufferedWriter.write(str);
    }
}
