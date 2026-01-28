import model.AnswerGenerator;
import model.AnswerJudge;
import model.BaseballAnswerJudge;
import model.BaseballGameManager;
import model.GameManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameManagerTest {

    private GameManager gameManager;
    private AnswerJudge answerJudge;

    @BeforeEach
    void setup() {
        AnswerGenerator fixedAnswerGenerator = () -> "123";
        answerJudge = new BaseballAnswerJudge();
        gameManager = new BaseballGameManager(fixedAnswerGenerator, answerJudge);
    }

    @DisplayName("게임 시작 전에는 플레이 상태가 아니다")
    @Test
    void isPlaying_returnsFalse_beforeGameStart() {
        assertThat(gameManager.isPlaying()).isFalse();
    }

    @DisplayName("게임 시작 후에는 플레이 상태이다")
    @Test
    void isPlaying_returnsTrue_afterGameStart() {
        gameManager.startGame();
        assertThat(gameManager.isPlaying()).isTrue();
    }

    @DisplayName("추측 시 스트라이크와 볼 개수를 반환한다")
    @Test
    void guess_returnsStrikesAndBalls() {
        gameManager.startGame();
        int[] result = gameManager.guess("145");
        assertThat(result[0]).isEqualTo(1);
        assertThat(result[1]).isEqualTo(0);
    }

    @DisplayName("3스트라이크 시 게임이 종료된다")
    @Test
    void guess_endsGame_whenThreeStrikes() {
        gameManager.startGame();
        int[] result = gameManager.guess("123");
        assertThat(result[0]).isEqualTo(3);
        assertThat(gameManager.isPlaying()).isFalse();
        assertThat(gameManager.isGameWon()).isTrue();
    }

    @DisplayName("3스트라이크가 아니면 게임이 계속된다")
    @Test
    void guess_continuesGame_whenNotThreeStrikes() {
        gameManager.startGame();
        gameManager.guess("456");
        assertThat(gameManager.isPlaying()).isTrue();
        assertThat(gameManager.isGameWon()).isFalse();
    }

    @DisplayName("게임 재시작 시 상태가 초기화된다")
    @Test
    void startGame_resetsState_afterGameWon() {
        gameManager.startGame();
        gameManager.guess("123");
        assertThat(gameManager.isGameWon()).isTrue();

        gameManager.startGame();
        assertThat(gameManager.isPlaying()).isTrue();
        assertThat(gameManager.isGameWon()).isFalse();
    }
}
