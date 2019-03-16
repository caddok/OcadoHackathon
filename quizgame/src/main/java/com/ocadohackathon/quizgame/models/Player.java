package com.ocadohackathon.quizgame.models;

import org.springframework.beans.factory.annotation.Autowired;

public class Player {
    private Controller playerController;

    @Autowired
    public Player(Controller playerController) {
        this.playerController = playerController;
    }

    public Controller getPlayerController() {
        return playerController;
    }
}
