package com.strategy;

import java.math.BigDecimal;

/**
 * @author Shuaihang Xue
 * @date 2019/11/7
 */
public class AliPay implements Payment {
    @Override
    public boolean pay(String orderId, BigDecimal amount) {
        System.out.println("支付宝支付，" + "订单号为" + orderId + "，支付金额为" + amount);
        return true;
    }
}
