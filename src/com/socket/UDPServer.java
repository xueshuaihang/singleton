package com.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

/**
 * @author Shuaihang Xue
 * @date 2020/9/17
 */
public class UDPServer {

    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(5555);
        for (; ; ) {
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            datagramSocket.receive(datagramPacket);
            String s = new String(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), StandardCharsets.UTF_8);
            byte[] data = "555".getBytes(StandardCharsets.UTF_8);
            datagramPacket.setData(data);
            datagramSocket.send(datagramPacket);
        }
    }
}
