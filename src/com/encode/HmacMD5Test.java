package com.encode;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Shuaihang Xue
 * @date 2020/8/24
 */
public class HmacMD5Test {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        for (int i = 0; i < 50; i++) {
            System.out.println("-----------------------");
            getStrForHmacMd5("Hello");
            System.out.println("-----------------------");
        }
//        getStrForHmacMd5("Hello");
//        hexStr2Byte("03d2f9e10979c9a968eed417364578c68f46cdd164ce55838ca6df92dd7b4e5de44767a20803074b7810839889f733285d3cdf0869e1ed1e2383f8cf68b3a55f");
    }

    static String getStrForHmacMd5(String str) throws NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        SecretKey secretKey = keyGenerator.generateKey();
        byte [] bytes = secretKey.getEncoded();
        // 用BigInteger来将byte数组转为16进制字符串，如果第一位为0则会省略
//        String salt = new BigInteger(1, bytes).toString(16);
        String salt = byte2HexStr(bytes);
        System.out.println(salt);
        System.out.println(byte2HexStr(bytes));
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(secretKey);
        mac.update(str.getBytes(StandardCharsets.UTF_8));
        byte[] result = mac.doFinal();
//        String resultHex = new BigInteger(1, result).toString(16);
        String resultHex = byte2HexStr(result);
        System.out.println(resultHex);

        // 验证
        System.out.println(verificationHmacMd5(salt, str));
        return resultHex;
    }

    static String verificationHmacMd5(String salt, String str) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] bytes = hexStr2Byte(salt);
        SecretKey secretKey = new SecretKeySpec(bytes, "HmacMD5");
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(secretKey);
        mac.update(str.getBytes(StandardCharsets.UTF_8));
        byte[] result = mac.doFinal();
        String resultHex = new BigInteger(1, result).toString(16);
        return resultHex;
    }

    public static byte[] hexStr2Byte(String hex) {
        ByteBuffer bf = ByteBuffer.allocate(hex.length() / 2);
        for (int i = 0; i < hex.length(); i++) {
            String hexStr = hex.charAt(i) + "";
            i++;
            hexStr += hex.charAt(i);
            byte b = (byte) Integer.parseInt(hexStr, 16);
            bf.put(b);
        }
        return bf.array();
    }

    public static String byte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }


}
