package com.newfeature.lambda;

import java.util.function.Predicate;

/**
 * @author Shuaihang Xue
 * @date 2020/7/18
 */
public class PredicateTest {

    public static void usePredicate() {
        Predicate<String> stringPredicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return "".equals(s);
            }
        };
        System.out.println(stringPredicate.test(""));
        System.out.println(stringPredicate.test("1"));

        // 使用lambda来实现接口
        Predicate<String> lambdaStringPredicate = s -> "".equals(s);
        System.out.println(lambdaStringPredicate.test(""));
        System.out.println(lambdaStringPredicate.test("1"));

        // 使用Predicate的and
        Predicate<Integer> integerPredicate = integer -> integer > 160;
        integerPredicate.and(integer -> integer < 180);

        System.out.println(integerPredicate.test(160));

        Predicate<Object> integerPredicate1 = Predicate.isEqual(Integer.valueOf(160)).and(integer -> Integer.valueOf(160) == 160);
        System.out.println(integerPredicate1.test(160));
    }
}
