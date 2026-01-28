package view;

public class OutputView {

    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputPrompt() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder result = new StringBuilder();
        if (balls > 0) {
            result.append(balls).append("볼 ");
        }
        if (strikes > 0) {
            result.append(strikes).append("스트라이크");
        }
        System.out.println(result.toString().trim());
    }

    public void printGameWon() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printRestartPrompt() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
