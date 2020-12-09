package com.ipaddress;

public class TestMain {
    public static void main(String[] args) {
        System.out.println(ip2BinStr("192.168.1.1"));
        System.out.println(ipTo2BinStr("192.168.1.1"));
    }

    public static String ipTo2BinStr(String ip) {
        String[] ips = ip.split("\\.");
        String finalIp = "";
        for (int i = 0; i < ips.length; i++) {
            String ip2Bin = Integer.toBinaryString(Integer.parseInt(ips[i]));
            if (ip2Bin.length() < 8) {
                int diff = 8 - ip2Bin.length();
                for (int j = 0; j < diff; j++) {
                    ip2Bin = "0" + ip2Bin;
                }
            }
            finalIp += ip2Bin;
        }
        return finalIp;
    }

    public static String ip2BinStr(String ip) {
        String[] arr = ip.split("\\.");
        String rs = "";
        for (String str : arr) {
            String s = Integer.toBinaryString(Integer.parseInt(str));
            if (s.length() < 8) {
                int diff = 8 - s.length();
                for (int i = 0; i < diff; i++) {
                    s = "0" + s;
                }
            }
            rs += s;
        }
        return rs;
    }

}
