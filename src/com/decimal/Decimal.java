package com.decimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Shuaihang Xue
 * @date 2020/4/27
 */
public class Decimal {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("1.75");
        bigDecimal = bigDecimal.setScale(0, RoundingMode.HALF_UP);
        System.out.println(bigDecimal.intValue());
    }
}
