package com.ocadohackathon.quizgame.game;

import com.ocadohackathon.quizgame.models.Player;

public interface GameActions {
    void startGame();
    void checkResults(Player playerOne, Player playerTwo);
}
