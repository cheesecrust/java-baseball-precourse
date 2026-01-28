import model.AnswerGenerator;
import model.BaseballAnswerGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballAnswerGeneratorTest {

    private AnswerGenerator answerGenerator;

    @BeforeEach
    void setup() {
        answerGenerator = new BaseballAnswerGenerator();
    }

    @DisplayName("정답은 3자리 숫자이다")
    @Test
    void generateAnswer_returnsLengthThree() {
        String answer = answerGenerator.generateAnswer();
        assertThat(answer.length()).isEqualTo(3);
    }

    @DisplayName("정답은 0을 포함하지 않는다")
    @Test
    void generateAnswer_doesNotContainZero() {
        String answer = answerGenerator.generateAnswer();
        assertThat(answer).doesNotContain("0");
    }

    @DisplayName("정답은 숫자로만 이루어져 있다")
    @Test
    void generateAnswer_containsOnlyDigits() {
        String answer = answerGenerator.generateAnswer();
        assertThat(answer).matches("\\d+");
    }

    @DisplayName("정답의 모든 숫자는 서로 다르다")
    @Test
    void generateAnswer_hasNoDuplicateDigits() {
        String answer = answerGenerator.generateAnswer();
        assertThat(answer.chars().distinct().count())
                .isEqualTo(answer.length());
    }
}
