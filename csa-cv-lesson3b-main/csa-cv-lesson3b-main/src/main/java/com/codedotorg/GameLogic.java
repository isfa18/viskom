package com.codedotorg;

import java.util.Random;

public class GameLogic {

    private boolean gameOver = false;
    private Random random = new Random();

    private final String[] choices = {"rock", "paper", "scissors"};

    public String getComputerChoice() {
        return choices[random.nextInt(3)];
    }

    public String determineWinner(String predictedClass, String computerChoice) {

        if (predictedClass.equals(computerChoice)) {
            return getTieResult();
        }

        if (
            (predictedClass.equals("rock") && computerChoice.equals("scissors")) ||
            (predictedClass.equals("paper") && computerChoice.equals("rock")) ||
            (predictedClass.equals("scissors") && computerChoice.equals("paper"))
        ) {
            return getUserWinnerResult();
        } else {
            return getComputerWinnerResult();
        }
    }

    public String getTieResult() {
        gameOver = true;
        return "It's a tie!";
    }

    public String getUserWinnerResult() {
        gameOver = true;
        return "You win!";
    }

    public String getComputerWinnerResult() {
        gameOver = true;
        return "Computer wins!";
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void resetLogic() {
        gameOver = false;
    }
}