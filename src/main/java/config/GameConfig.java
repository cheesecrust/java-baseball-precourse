package config;

import controller.GameController;
import model.BaseballAnswerGenerator;
import model.BaseballAnswerJudge;
import model.BaseballGameManager;
import model.BaseballInputValidator;
import view.OutputView;

public class GameConfig {

    public GameController gameController() {
        return new GameController(
                gameManager(),
                new BaseballInputValidator(),
                new OutputView()
        );
    }

    private BaseballGameManager gameManager() {
        return new BaseballGameManager(
                new BaseballAnswerGenerator(),
                new BaseballAnswerJudge()
        );
    }

}
