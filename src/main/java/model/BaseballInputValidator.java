package model;

import constant.GameConstants;
import constant.GameMessages;

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
        if (input.length() != GameConstants.ANSWER_LENGTH) {
            throw new IllegalArgumentException(GameMessages.ERROR_INVALID_LENGTH);
        }
    }

    private void validateDigitsOnly(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(GameMessages.ERROR_NOT_DIGIT);
            }
        }
    }

    private void validateRange(String input) {
        for (char c : input.toCharArray()) {
            if (c == GameConstants.EXCLUDED_DIGIT) {
                throw new IllegalArgumentException(GameMessages.ERROR_INVALID_RANGE);
            }
        }
    }

    private void validateNoDuplicates(String input) {
        Set<Character> seen = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!seen.add(c)) {
                throw new IllegalArgumentException(GameMessages.ERROR_DUPLICATE);
            }
        }
    }
}
