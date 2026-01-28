package model;

public interface GameManager {

    void startGame();

    int[] guess(String input);

    boolean isPlaying();

    boolean isGameWon();

}
