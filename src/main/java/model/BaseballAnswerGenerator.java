package model;

import constant.GameConstants;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class BaseballAnswerGenerator implements AnswerGenerator {

    @Override
    public String generateAnswer() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < GameConstants.ANSWER_LENGTH) {
            numbers.add(ThreadLocalRandom.current().nextInt(
                    GameConstants.MIN_DIGIT,
                    GameConstants.MAX_DIGIT + 1
            ));
        }

        StringBuilder answer = new StringBuilder();
        for (int n : numbers) {
            answer.append(n);
        }

        return answer.toString();
    }
}
