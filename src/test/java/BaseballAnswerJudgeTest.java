import model.AnswerJudge;
import model.BaseballAnswerJudge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballAnswerJudgeTest {

    private AnswerJudge answerJudge;

    @BeforeEach
    void setup() {
        answerJudge = new BaseballAnswerJudge();
    }

    @DisplayName("같은 위치의 숫자는 스트라이크로 판정한다")
    @Test
    void countStrikes_returnsCorrectCount_when_positionsMatch() {
        int strikes = answerJudge.countStrikes("123", "153");
        assertThat(strikes).isEqualTo(2);
    }

    @DisplayName("같은 위치의 숫자가 없으면 스트라이크는 0이다")
    @Test
    void countStrikes_returnsZero_when_noPositionMatches() {
        int strikes = answerJudge.countStrikes("456", "123");
        assertThat(strikes).isZero();
    }

    @DisplayName("모든 숫자와 위치가 같으면 스트라이크는 3이다")
    @Test
    void countStrikes_returnsThree_when_guessEqualsAnswer() {
        int strikes = answerJudge.countStrikes("123", "123");
        assertThat(strikes).isEqualTo(3);
    }

    @DisplayName("같은 위치의 숫자는 볼로 판정하지 않는다.")
    @Test
    void countBalls_returnsCorrectCount_when_positionsMatch() {
        int balls = answerJudge.countBalls("123", "153");
        assertThat(balls).isEqualTo(0);
    }

    @DisplayName("같은 숫자가 위치가 다르면 볼이다.")
    @Test
    void countBalls_returnsOne_when_noPositionMatches_OneValueMatches() {
        int balls = answerJudge.countBalls("456", "124");
        assertThat(balls).isEqualTo(1);
    }

    @DisplayName("같은 숫자가 없으면 볼은 0이다.")
    @Test
    void countBalls_returnsZero_when_noPositionMatches() {
        int balls = answerJudge.countBalls("123", "456");
        assertThat(balls).isZero();
    }
}
