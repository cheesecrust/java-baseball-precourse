package model;

public interface AnswerJudge {

    Integer countStrikes(String input, String answer);

    Integer countBalls(String input, String answer);
}
