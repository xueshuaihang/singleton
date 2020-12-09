package com.stringbuilder;

/**
 * @author Shuaihang Xue
 * @date 2020/1/11
 */
public class Main {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        StringBuilder errorReason = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(1 / 0);
            } catch (Exception e) {
                e.printStackTrace();
                errorReason.append("applicationName")
                        .append("：")
                        .append(e.getMessage())
                        .append("\n");
            }
        }
        int errorReasonLength = errorReason.length();
        errorReason.delete(errorReasonLength - 1, errorReasonLength);
        System.out.println("构建失败\n" + errorReason.toString());

    }
}
