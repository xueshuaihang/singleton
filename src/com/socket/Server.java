package com.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Shuaihang Xue
 * @date 2019/12/9
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true) {
                System.out.println("即将执行accept来接受客户端的socket");
                Socket server = serverSocket.accept();
                Thread processClient = new Thread(new ProcessClient(server));
                processClient.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ProcessClient implements Runnable {

        private Socket server;

        private ProcessClient() {
        }

        public ProcessClient(Socket server) {
            this.server = server;
        }

        @Override
        public void run() {
            Reader reader = null;
            Writer writer = null;
            try {
                reader = new InputStreamReader(server.getInputStream());
                OutputStream outputStream = server.getOutputStream();
                char[] chars = new char[1024];
                int len;
                StringBuilder stringBuilder = new StringBuilder();
                String s = null;
                while ((len = reader.read(chars)) != -1){
                    s = new String(chars, 0, len);
                    stringBuilder.append(s);
                }
                System.out.println("客户端发送的信息:" + stringBuilder.toString());
                String afterProcessInfo = stringBuilder.toString() + "11111";
                outputStream.write(afterProcessInfo.getBytes());
                reader.close();
                outputStream.close();
//                writer.flush();
//                writer.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
