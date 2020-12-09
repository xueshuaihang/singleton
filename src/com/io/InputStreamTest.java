package com.io;

import java.io.*;

/**
 * @author Shuaihang Xue
 * @date 2020/8/5
 */
public class InputStreamTest {

    public static void main(String[] args) throws IOException {
        byte[] data = {72, 101, 108, 108, 111, 33};
        // ByteArrayInputStream用来模拟一个InputStream，大多用在测试的时候
        InputStream inputStream = new ByteArrayInputStream(data);
        OutputStream outputStream = new FileOutputStream("D:\\java\\project\\singleton\\testFile.txt");
        try {
//            int n;
//            byte[] bytes = new byte[100];
//            while ((n = inputStream.read(bytes)) != -1) {
//                System.out.println(n);
//            }
//            outputStream.write(bytes);
            String s = readAsString(inputStream);
            System.out.println(s);
        } finally {
            inputStream.close();
            outputStream.close();
        }
    }

    static String readAsString(InputStream inputStream) throws IOException {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        while ((n = inputStream.read()) != -1) {
            stringBuilder.append((char) n);
        }
        return stringBuilder.toString();
    }
}
