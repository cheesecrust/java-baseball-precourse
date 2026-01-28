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

    @DisplayName("정답 길이 테스트")
    @Test
    void generatedLengthTest() {
        String answer = answerGenerator.generateAnswer();
        assertThat(answer.length()).isSameAs(3);
    }

    @DisplayName("정답 안에 0이 없는지 test")
    @Test
    void generatedAnswerZeroTest() {
        String answer = answerGenerator.generateAnswer();
        assertThat(answer).doesNotContain("0");
    }

    @DisplayName("정답이 모두 숫자인지 test")
    @Test
    void generatedAnswerAsciiTest() {
        String answer = answerGenerator.generateAnswer();
        assertThat(answer).matches("\\d+");
    }

    @DisplayName("정답이 숫자가 모두 다른지 test")
    @Test
    void generatedAnswerDiffTest() {
        String answer = answerGenerator.generateAnswer();
        assertThat(answer.chars().distinct().count()).isEqualTo(answer.length());
    }

}
