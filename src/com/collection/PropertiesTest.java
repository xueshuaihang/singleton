package com.collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Shuaihang Xue
 * @date 2020/7/30
 */
public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        useProperties();
    }

    static void useProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\java\\project\\singleton\\out\\production\\singleton\\application.properties"));
        String port = properties.getProperty("server.port");
        String hobby = properties.getProperty("hobby");
        System.out.println(port);
        System.out.println(hobby);
        properties.setProperty("user.name", "张三");
        properties.store(new FileOutputStream("D:\\java\\project\\singleton\\out\\production\\singleton\\application.properties"), "这是注释");
    }


}
