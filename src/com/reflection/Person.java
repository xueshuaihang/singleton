package com.reflection;

/**
 * @author Shuaihang Xue
 * @date 2020/2/27
 */
public class Person {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void playGame(String gameId) {
        System.out.println("steam://rungameid/" + gameId);
    }
}
