package model;

import constant.GameConstants;

public class BaseballAnswerJudge implements AnswerJudge {

    @Override
    public Integer countStrikes(String input, String answer) {
        int result = 0;
        for (int index = 0; index < GameConstants.ANSWER_LENGTH; index++) {
            if (input.charAt(index) == answer.charAt(index)) {
                result++;
            }
        }
        return result;
    }

    @Override
    public Integer countBalls(String input, String answer) {
        int result = 0;
        for (int index = 0; index < GameConstants.ANSWER_LENGTH; index++) {
            char item = input.charAt(index);
            if (item != answer.charAt(index) && answer.indexOf(item) != -1) {
                result++;
            }
        }
        return result;
    }
}
