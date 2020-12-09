package com.strategy;

import java.math.BigDecimal;

public interface Payment {

    boolean pay(String orderId, BigDecimal amount);
}
