package model;

import constant.GameConstants;

public class BaseballGameManager implements GameManager {
    private final AnswerGenerator answerGenerator;
    private final AnswerJudge answerJudge;
    private String answer;
    private boolean playing;
    private boolean gameWon;

    public BaseballGameManager(AnswerGenerator answerGenerator, AnswerJudge answerJudge) {
        this.answerGenerator = answerGenerator;
        this.answerJudge = answerJudge;
        this.playing = false;
        this.gameWon = false;
    }

    @Override
    public void startGame() {
        this.answer = answerGenerator.generateAnswer();
        this.playing = true;
        this.gameWon = false;
    }

    @Override
    public int[] guess(String input) {
        int strikes = answerJudge.countStrikes(input, answer);
        int balls = answerJudge.countBalls(input, answer);

        if (strikes == GameConstants.ANSWER_LENGTH) {
            this.playing = false;
            this.gameWon = true;
        }

        return new int[]{strikes, balls};
    }

    @Override
    public boolean isPlaying() {
        return playing;
    }

    @Override
    public boolean isGameWon() {
        return gameWon;
    }
}
