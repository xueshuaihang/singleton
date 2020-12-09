package com.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @author Shuaihang Xue
 * @date 2020/8/3
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
//        getFilePath();
//        getSeparator();
//        isFileOrDirectory();
//        createAndDeleteFile();
//        createTempFile();
//        directoryList();
        createAndDeleteDirectory();
    }

    /**
     * Java字符串中需要用\\表示\
     */
    static void getFilePath() throws IOException {
        // 绝对路径
        File f = new File("D:\\java\\project\\singleton\\text.txt");
        // 相对路径
        File f1 = new File("..\\text.txt");
        System.out.println(f.getPath());
        // 构造方法传入的路径
        System.out.println(f1.getPath());
        // 绝对路径：当前目录 + 构造方法传入的路径
        System.out.println(f1.getAbsolutePath());
        // 规范路径：真是的路径
        System.out.println(f1.getCanonicalPath());
    }

    static void getSeparator() {
        // 根据平台打印分隔符
        System.out.println(File.separator);
    }

    static void isFileOrDirectory() {
        File f1 = new File("D:\\java\\project\\singleton\\text.txt");
        File f2 = new File("D:\\data");
        File f3 = new File("D:\\nothing");
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println(f2.isFile());
        System.out.println(f2.isDirectory());
        System.out.println(f3.isFile());
        System.out.println(f3.isDirectory());
    }

    static void createAndDeleteFile() throws IOException {
        File f = new File("D:\\java\\project\\singleton\\text1.txt");
        if (f.createNewFile()) {
            System.out.println("创建成功");
            if (f.delete()) {
                System.out.println("删除成功");
            }
        }
    }

    static void createAndDeleteDirectory() {
        File f = new File("D:\\java\\project\\singleton\\test_dir\\test_dir1");
        // mkdirs()可以创建不存在的父级目录
        if (f.mkdirs()) {
            System.out.println("创建成功");
            if (f.delete()) {
                System.out.println("删除成功");
            }
        }
    }

    static void createTempFile() throws IOException {
        File f = File.createTempFile("temp-", ".txt");
        f.deleteOnExit();
        System.out.println(f.isFile());
        System.out.println(f.getCanonicalPath());
    }

    static void directoryList() {
        File f = new File("D:\\java\\project\\singleton");
        // 获取目录下文件名数组
        String[] fileNames = f.list();
        printFileName(fileNames);
        // 获取目录下文件数组对象
        File[] files = f.listFiles();
        printFile(files);
        File[] filterFiles = f.listFiles((dir, name) -> name.endsWith(".txt"));
        printFile(filterFiles);
    }

    static void printFileName(String[] fileNames) {
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }

    static void printFile(File[] files) {
        System.out.println("========================================");
        for (File file : files) {
            System.out.println(file);
        }
    }
}
