package com.vic.socket.e;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientB {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("127.0.0.1", 9999);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        // 通过标准输入流获取字符流
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in,"UTF-8"));

        while (true){
            String str = bufferedReader.readLine();
            bufferedWriter.write(str);

            // 添加一个换行标识“\n”标识，在告诉服务端我数据已经发送完成了。
            bufferedWriter.write("\n");
            //刷新输入流
            bufferedWriter.flush();

        }

        // 没有关闭socket
    }
}
