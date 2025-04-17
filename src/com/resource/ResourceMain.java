package com.resource;

public class ResourceMain {

    public static void main(String[] args) {
        //System.out.println(ResourceMain.class.getResource("1.txt"));
//        System.out.println(ResourceMain.class.getResource("/hazelcast.yaml"));
        System.out.println(ResourceMain.class.getClassLoader().getResource("hazelcast.yaml"));
//        System.out.println(System.getProperty("java.ext.dirs"));
    }
}
