package com.ocadohackathon.quizgame.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Player {
    private Controller playerController;
    private Integer score;

    @Autowired
    public Player(Controller playerController, Integer score) {
        this.playerController = playerController;
        this.score = score;
    }

    public Controller getPlayerController() {
        return playerController;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
