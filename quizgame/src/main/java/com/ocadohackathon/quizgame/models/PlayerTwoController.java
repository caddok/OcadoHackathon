package com.ocadohackathon.quizgame.models;

import org.springframework.stereotype.Component;

@Component
public class PlayerTwoController extends Player implements ControllerInput {
    private Integer xAxis;
    private Integer yAxis;
    private Integer button;
    private Integer score;

    public PlayerTwoController() {

    }

    public PlayerTwoController(Integer xAxis, Integer yAxis, Integer button) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.button = button;
        this.score = 0;
    }

    public Integer getxAxis() {
        return xAxis;
    }

    public void setxAxis(Integer xAxis) {
        this.xAxis = xAxis;
    }

    public Integer getyAxis() {
        return yAxis;
    }

    public void setyAxis(Integer yAxis) {
        this.yAxis = yAxis;
    }

    public Integer getButton() {
        return button;
    }

    public void setButton(Integer button) {
        this.button = button;
    }

    @Override
    public void takeAction(Integer xAxis, Integer yAxis, Integer button) {

    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score += score;
    }
}
