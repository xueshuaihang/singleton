package com.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.Set;

/**
 * @author Shuaihang Xue
 * @date 2020/8/6
 */
public class ClassPathFileTest {

    public static void main(String[] args) throws IOException {
//        byte[] gbkBytes = "薛帅航".getBytes("GBK");
//        byte[] utf8Bytes = "薛帅航".getBytes("UTF-8");
//        System.out.println();
        Properties properties = new Properties();
        properties.load(inputStreamFromClassPath("/application.properties"));
        properties.load(inputStreamFromFile("app.properties"));
        System.out.println(properties.getProperty("server.port"));
        System.out.println(new String(properties.getProperty("hobby").getBytes("ISO8859-1"), "GBK"));
        System.out.println(new String(properties.getProperty("name").getBytes("ISO8859-1"), "GBK"));
    }

    static InputStream inputStreamFromClassPath(String path) {
        return ClassPathFileTest.class.getResourceAsStream(path);
//        byte[] bytes = new byte[inputStream.available()];
//        while (inputStream.read(bytes) != -1);
//        System.out.println(new String(bytes, Charset.forName("GBK")));
    }

    static InputStream inputStreamFromFile(String filePath) throws FileNotFoundException {
        return new FileInputStream(filePath);
    }
}
