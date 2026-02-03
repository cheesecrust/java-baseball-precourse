package controller;

import constant.GameConstants;
import model.GameManager;
import model.InputValidator;
import view.OutputView;

import java.util.Scanner;

public class GameController {

    private final GameManager gameManager;
    private final InputValidator inputValidator;
    private final OutputView outputView;
    private final Scanner scanner;

    public GameController(GameManager gameManager, InputValidator inputValidator, OutputView outputView) {
        this.gameManager = gameManager;
        this.inputValidator = inputValidator;
        this.outputView = outputView;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        outputView.printGameStart();
        while (true) {
            playGame();
            if (!askRestart()) break;
        }
    }

    private void playGame() {
        gameManager.startGame();
        while (gameManager.isPlaying()) {
            outputView.printInputPrompt();
            String input = scanner.nextLine();
            processGuess(input);
        }
        outputView.printGameWon();
    }

    private void processGuess(String input) {
        try {
            inputValidator.validate(input);
            int[] result = gameManager.guess(input);
            outputView.printResult(result[0], result[1]);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private boolean askRestart() {
        outputView.printRestartPrompt();
        String input = scanner.nextLine();
        return input.equals(GameConstants.RESTART_COMMAND);
    }
}
