package model;

import java.util.HashSet;
import java.util.Set;

public class BaseballInputValidator implements InputValidator {

    @Override
    public void validate(String input) {
        validateLength(input);
        validateDigitsOnly(input);
        validateRange(input);
        validateNoDuplicates(input);
    }

    private void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("[ERROR] 3자리 숫자를 입력해주세요.");
        }
    }

    private void validateDigitsOnly(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
            }
        }
    }

    private void validateRange(String input) {
        for (char c : input.toCharArray()) {
            if (c == '0') {
                throw new IllegalArgumentException("[ERROR] 1부터 9까지의 숫자만 입력해주세요.");
            }
        }
    }

    private void validateNoDuplicates(String input) {
        Set<Character> seen = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!seen.add(c)) {
                throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력해주세요.");
            }
        }
    }
}
