package model;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class BaseballAnswerGenerator implements AnswerGenerator{

    @Override
    public String generateAnswer() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 3) {
            numbers.add(ThreadLocalRandom.current().nextInt(1, 10));
        }

        StringBuilder answer = new StringBuilder();
        for (int n : numbers) {
            answer.append(n);
        }

        return answer.toString();
    }
}
