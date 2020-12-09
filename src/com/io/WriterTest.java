package com.io;

import java.io.*;

/**
 * @author Shuaihang Xue
 * @date 2020/8/7
 */
public class WriterTest {

    public static void main(String[] args) throws IOException {
        byte[] bytes = "薛帅航".getBytes();
//        useFileWriter();
        useCharArrayWriter();
    }

    static void useFileWriter() throws IOException {
        Writer writer = new FileWriter("testFile.txt");
        writer.write('H');
        writer.write("\nHello".toCharArray());
        writer.write("\nHello world!");
        writer.close();
    }

    static void useCharArrayWriter() throws IOException {
        CharArrayWriter writer = new CharArrayWriter();
        writer.write(65);
        writer.write(66);
        writer.write(67);
        char[] chars = writer.toCharArray();
        System.out.println(chars);
    }

    /**
     * StringWriter内部维护了一个StringBuffer
     * write方法其实是往stringBuffer中append
     */
    static void useStringWriter() {
        StringWriter stringWriter = new StringWriter();
    }

    /**
     * OutputStreamWriter可以将OutputStream转换为Writer
     * 普通的Writer实际上是基于OutputStream构造的，它接收char，然后在内部自动转换成一个或多个byte，并写入OutputStream
     * 因此，OutputStreamWriter就是一个将任意的OutputStream转换为Writer的转换器：
     * @throws FileNotFoundException
     */
    static void useOutputStreamWriter() throws FileNotFoundException {
        Writer writer = new OutputStreamWriter(new FileOutputStream(""));
    }
}
