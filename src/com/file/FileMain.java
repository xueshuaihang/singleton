package com.file;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Shuaihang Xue
 * @date 2019/12/10
 */
public class FileMain {

    static File testFile = new File("C:\\Users\\hanghang\\Desktop\\testFile.txt");
    static File desktop = new File("C:\\Users\\hanghang\\Desktop");

    public static void main(String[] args) throws IOException {
//        List<String> list = null;
//        for (String s : list) {
//            System.out.println(s);
//        }
//        createNewFile();
//        creatTempFileAndDeleteOnExit();
//        deleteFile();
//        getFilePath();
//        isFileOrDirectory();
//        getAuthAndSize();
        getFileList("F:\\singleton\\.git");
    }

    public static void createNewFile() throws IOException {
        File file = new File("C:\\Users\\hanghang\\Desktop\\testFile.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static void creatTempFileAndDeleteOnExit() throws IOException {
        File file = File.createTempFile("tem-", ".txt");
        file.deleteOnExit();
        System.out.println(file.isFile());
        System.out.println(file.getAbsolutePath());
    }


    public static void deleteFile() {
        System.out.println(testFile.delete());
    }

    public static void getFilePath() throws IOException {
        File file = new File("..");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
    }

    public static void isFileOrDirectory() {
//        File testFile = new File("C:\\Users\\hanghang\\Desktop\\testFile.txt");
//        File desktop = new File("C:\\Users\\hanghang\\Desktop");
        System.out.println(testFile.isFile());
        System.out.println(testFile.isDirectory());
        System.out.println(desktop.isFile());
        System.out.println(desktop.isDirectory());
    }

    public static void getAuthAndSize() {
        System.out.println(testFile.canRead());
        System.out.println(testFile.canWrite());
        System.out.println(testFile.canExecute());
        // 对目录而言，是否可执行表示能否列出它包含的文件和子目录。
        System.out.println(desktop.canExecute());
        System.out.println(testFile.length());
    }

    static void getFileList() {
        getFileList(null);
    }

    static void getFileList(String path) {
        File file;
        if (Objects.isNull(path)) {
            file = new File(".");
            System.out.println(file.getAbsolutePath());
        } else {
             file = new File(path);
        }
        printFileName(file, "");
    }

    static void printFileName(File file, String prefix) {
        if (file.isDirectory()) {
            System.out.println(prefix + file.getName() + File.separator);
            File[] files = file.listFiles();
            for (File f : files) {
                printFileName(f, "  " + prefix);
            }
        } else {
            System.out.println(prefix + file.getName());
        }
    }
}
