package com.ocadohackathon.quizgame.models;

public interface ControllerInput {
    String takeAction(Integer xAxis, Integer yAxis, Integer button);
}
