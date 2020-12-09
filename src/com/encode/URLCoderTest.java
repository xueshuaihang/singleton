package com.encode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author Shuaihang Xue
 * @date 2020/8/19
 */
public class URLCoderTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String encode = URLEncoder.encode("中文", StandardCharsets.UTF_8.name());
        System.out.println(encode);
        String decode = URLDecoder.decode("%E4%B8%AD%E6%96%87", StandardCharsets.UTF_8.name());
        System.out.println(decode);
    }
}
