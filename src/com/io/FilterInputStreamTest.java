package com.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author Shuaihang Xue
 * @date 2020/8/6
 */
public class FilterInputStreamTest {

    public static void main(String[] args) throws IOException {
//        useCountInputStream();
//        useZipInputStream();
        useZipOutputStream();
//        getFileDataAsBytes(new File("D:\\java\\project\\singleton\\text.txt"));
    }

    static void useCountInputStream() throws IOException {
        byte[] bytes = "Hello!".getBytes(Charset.forName("UTF-8"));
        CountInputStream countInputStream = new CountInputStream(new ByteArrayInputStream(bytes));
        int n;
        while ((n = countInputStream.read()) != -1) {
            System.out.println((char) n);
        }
        System.out.println("Total read " + countInputStream.getBytesRead() + " bytes");
    }

    static void useZipInputStream() throws IOException {
        InputStream inputStream = new FileInputStream("D:\\java\\project\\singleton\\testZip.zip");
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            System.out.println(zipEntry.getName());
        }
    }

    static void useZipOutputStream() throws IOException {
        File[] files = {new File("D:\\java\\project\\singleton\\text.txt"), new File("D:\\java\\project\\singleton\\testFile.txt")};
        OutputStream outputStream = new FileOutputStream("D:\\java\\project\\singleton\\out.zip");
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
        for (File file : files) {
            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
            zipOutputStream.write(getFileDataAsBytes(file));
            zipOutputStream.closeEntry();
        }
        // 如果不正确关闭流则压缩包会损坏
        zipOutputStream.close();
        outputStream.close();
    }

    static byte[] getFileDataAsBytes(File file) throws IOException {
        InputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        while (inputStream.read(bytes) != -1);
        System.out.println(new String(bytes));
        return bytes;
    }
}
