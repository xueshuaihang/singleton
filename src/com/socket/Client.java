package com.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author Shuaihang Xue
 * @date 2019/12/9
 */
public class Client {

    public static void main(String[] args) {
        try {
            Writer outputStreamWriter = null;
            Socket client = new Socket("127.0.0.1", 9999);
            outputStreamWriter = new OutputStreamWriter(client.getOutputStream());
            outputStreamWriter.write("Hello Socket");
            outputStreamWriter.flush();
            client.shutdownOutput();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder stringBuilder = new StringBuilder();
//            Reader inputStreamReader = new InputStreamReader(client.getInputStream());
            InputStream inputStream = client.getInputStream();
            while ((len = inputStream.read(bytes)) != -1) {
                stringBuilder.append(new String(bytes, 0, len));
            }
            System.out.println("服务端加工后的信息:" + stringBuilder.toString());
            inputStream.close();
            outputStreamWriter.close();
//            inputStreamReader.close();
            client.close();

//            Writer outputStreamWriter1 = null;
//            Socket client1 = new Socket("127.0.0.1", 9999);
//            outputStreamWriter1 = new OutputStreamWriter(client1.getOutputStream());
//            outputStreamWriter1.write("Hello Socket1");
//            outputStreamWriter1.flush();
//            outputStreamWriter1.close();
//            client1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
