package com.ocadohackathon.quizgame.models;

public class Controller {
    private Integer xAxis;
    private Integer yAxis;
    private Integer button;

    public Controller(Integer xAxis, Integer yAxis, Integer button) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.button = button;
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
}
