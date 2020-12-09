package com.encode;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Shuaihang Xue
 * @date 2020/8/19
 */
public class MD5Encode {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update("Hello".getBytes(StandardCharsets.UTF_8));
        messageDigest.update("World".getBytes(StandardCharsets.UTF_8));
        byte[] result = messageDigest.digest();
        System.out.println(new String(result, StandardCharsets.UTF_8));
        System.out.println(new BigInteger(1, result).toString());
        System.out.println(new BigInteger(1, result).toString(16));
    }

}
