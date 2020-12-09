package com.strategy;

import java.math.BigDecimal;

/**
 * @author Shuaihang Xue
 * @date 2019/11/7
 */
public class Main {
    public static void main(String[] args) {
        Payment payment = PaymentFactory.getPayment(PaymentType.ALIPAY);
        payment.pay("201911080001", new BigDecimal(66));
    }
}
