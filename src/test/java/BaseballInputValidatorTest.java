import model.BaseballInputValidator;
import model.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

public class BaseballInputValidatorTest {

    private InputValidator validator;

    @BeforeEach
    void setup() {
        validator = new BaseballInputValidator();
    }

    @DisplayName("올바른 입력은 예외가 발생하지 않는다")
    @Test
    void validate_doesNotThrow_whenValidInput() {
        assertThatCode(() -> validator.validate("123"))
                .doesNotThrowAnyException();
    }

    @DisplayName("3자리가 아니면 예외가 발생한다")
    @Test
    void validate_throwsException_whenLengthIsNotThree() {
        assertThatThrownBy(() -> validator.validate("12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("숫자가 아닌 문자가 포함되면 예외가 발생한다")
    @Test
    void validate_throwsException_whenContainsNonDigit() {
        assertThatThrownBy(() -> validator.validate("12a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("0이 포함되면 예외가 발생한다")
    @Test
    void validate_throwsException_whenContainsZero() {
        assertThatThrownBy(() -> validator.validate("012"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("중복된 숫자가 있으면 예외가 발생한다")
    @Test
    void validate_throwsException_whenHasDuplicates() {
        assertThatThrownBy(() -> validator.validate("112"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
