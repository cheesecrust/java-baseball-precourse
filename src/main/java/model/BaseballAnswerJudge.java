package model;

public class BaseballAnswerJudge implements AnswerJudge {

    @Override
    public Integer countStrikes(String input, String answer) {
        int result = 0;
        for (int index = 0; index < 3; index++) {
            if (input.charAt(index) == answer.charAt(index)) result++;
        }
        return result;
    }
}
