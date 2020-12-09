package com.io;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author Shuaihang Xue
 * @date 2020/8/5
 */
public class OutputStreamTest {

    public static void main(String[] args) throws IOException {
//        fileOutputStream();
        byteArrayOutputStream();
    }

    static void fileOutputStream() throws IOException {
        byte[] bytes = "Hello ".getBytes(Charset.forName("UTF-8"));
        byte[] bytes1 = "world!".getBytes(Charset.forName("UTF-8"));
        OutputStream outputStream = new FileOutputStream("D:\\java\\project\\singleton\\testFile.txt");
        outputStream.write(bytes);
        outputStream.write(bytes1);
    }

    static void byteArrayOutputStream() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write("Hello ".getBytes(Charset.forName("UTF-8")));
        outputStream.write("world!".getBytes(Charset.forName("UTF-8")));
        byte[] bytes = outputStream.toByteArray();
        System.out.println(new String(bytes, "UTF-8"));
    }
}
