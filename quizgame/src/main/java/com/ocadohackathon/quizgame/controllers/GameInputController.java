package com.ocadohackathon.quizgame.controllers;

import com.ocadohackathon.quizgame.models.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/input")
public class GameInputController {
    private Controller playerController;

    @Autowired
    public GameInputController(Controller playerController) {
        this.playerController = playerController;
    }

    @PostMapping(consumes = "application/json")
    public Controller consumeControllerData(@RequestBody Controller controller) {
        playerController.setxAxis(controller.getxAxis());
        playerController.setyAxis(controller.getyAxis());
        playerController.setButton(controller.getButton());
        return controller;
    }

}
