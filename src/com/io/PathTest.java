package com.io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Shuaihang Xue
 * @date 2020/8/5
 */
public class PathTest {

    public static void main(String[] args) {
        Path p1 = Paths.get(".", "test.txt");
        System.out.println(p1);
        Path absolutePath = p1.toAbsolutePath();
        System.out.println(absolutePath);
        Path normalize = absolutePath.normalize();
        System.out.println(normalize);
        File file = normalize.toFile();
        System.out.println(file);
        for (Path path : Paths.get("..").toAbsolutePath()) {
            System.out.println("" + path);
        }
    }

}
