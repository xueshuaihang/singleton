package com.reflection;

/**
 * @author Shuaihang Xue
 * @date 2020/2/27
 */
public class Student extends Person {

    public int score;

    private int grade;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    private void priMethod() {
        System.out.println("steam://rungameid/740");
    }

    @Override
    public void playGame(String gameId) {
        System.out.println("student-----" + "steam://rungameid/" + gameId);
    }
}
