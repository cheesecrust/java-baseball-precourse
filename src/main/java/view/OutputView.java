package view;

import constant.GameMessages;

public class OutputView {

    public void printGameStart() {
        System.out.println(GameMessages.GAME_START);
    }

    public void printInputPrompt() {
        System.out.print(GameMessages.INPUT_PROMPT);
    }

    public void printResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println(GameMessages.NOTHING);
            return;
        }

        StringBuilder result = new StringBuilder();
        if (balls > 0) {
            result.append(balls).append(GameMessages.BALL).append(" ");
        }
        if (strikes > 0) {
            result.append(strikes).append(GameMessages.STRIKE);
        }
        System.out.println(result.toString().trim());
    }

    public void printGameWon() {
        System.out.println(GameMessages.GAME_WON);
    }

    public void printRestartPrompt() {
        System.out.println(GameMessages.RESTART_PROMPT);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
