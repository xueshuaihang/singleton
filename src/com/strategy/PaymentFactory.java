package com.strategy;

/**
 * @author Shuaihang Xue
 * @date 2019/11/8
 */
public class PaymentFactory {

    public static Payment getPayment(PaymentType paymentType){
        if (PaymentType.ALIPAY == paymentType){
            return new AliPay();
        }
        if (PaymentType.WECHATPAY == paymentType){
            return new WeChatPay();
        }
        throw new IllegalArgumentException("没有找到合适的支付类型");
    }
}
