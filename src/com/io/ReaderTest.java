package com.io;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author Shuaihang Xue
 * @date 2020/8/7
 */
public class ReaderTest {

    public static void main(String[] args) throws IOException {
        useFileReader();
    }

    static void useFileReader() throws IOException {
//        Reader reader = new FileReader("D:\\java\\project\\singleton\\text.txt");
//        Reader reader = new FileReader("D:\\java\\project\\singleton\\moke.properties");
        Reader reader = new InputStreamReader(new FileInputStream("D:\\java\\project\\singleton\\moke.properties"), Charset.forName("GBK"));
//        for (;;){
//            int n = reader.read();
//            if (n == -1) {
//                break;
//            }
//            System.out.print(n);
//            System.out.println((char) n);
//        }
        char[] chars = new char[1000];
        int n;
        while ((n = reader.read(chars)) != -1) ;
        System.out.println(chars);
        reader.close();
    }

    /**
     * 和ByteArrayInputStream类似，在内存中模拟一个Reader
     */
    static void useCharArrayReader() {
        Reader reader = new CharArrayReader("Hello".toCharArray());
    }

    /**
     * StringReader可以直接使用String作为数据源
     * 和CharArrayReader几乎一样
     *
     */
    static void useStringReader() {
        Reader reader = new StringReader("Hello");
    }

    /**
     * InputStreamReader可以将一个InputStream转换成Reader
     * @throws FileNotFoundException
     */
    static void useInputStreamReader() throws FileNotFoundException {
        Reader reader = new InputStreamReader(new FileInputStream("D:\\java\\project\\singleton\\moke.properties"), Charset.forName("GBK"));
    }
}
