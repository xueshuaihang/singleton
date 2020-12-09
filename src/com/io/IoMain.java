package com.io;

import java.io.*;

/**
 * @author Shuaihang Xue
 * @date 2020/8/3
 */
public class IoMain {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("D:\\java\\project\\singleton\\text.txt");
        OutputStream outputStream = new FileOutputStream("D:\\java\\project\\singleton\\testFile.txt");
        int count = inputStream.available();
        byte[] bytes = new byte[count];
        while (inputStream.read(bytes) != -1) {
            outputStream.write(bytes);
        }
    }
}
