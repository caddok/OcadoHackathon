package com.ocadohackathon.quizgame.models;

import com.googlecode.lanterna.input.KeyStroke;

public class Player {//implements ControllerInput {
    private boolean buttonClicked;

    public boolean isButtonClicked() {
        return buttonClicked;
    }

    public void setButtonClicked(boolean buttonClicked) {
        this.buttonClicked = buttonClicked;
    }

    /*@Override
    public String takeAction(Integer xAxis, Integer yAxis, Integer button) {

    }*/
}
