package com.strategy;

import java.math.BigDecimal;

/**
 * @author Shuaihang Xue
 * @date 2019/11/7
 */
public class WeChatPay implements Payment {
    @Override
    public boolean pay(String orderId, BigDecimal amount) {
        System.out.println("微信支付，" + "订单号为" + orderId + "，支付金额为" + amount);
        return true;
    }
}
