package com.ocadohackathon.quizgame.controllers;

import com.ocadohackathon.quizgame.game.QuizGame;
import com.ocadohackathon.quizgame.models.Controller;
import com.ocadohackathon.quizgame.models.PlayerOneController;
import com.ocadohackathon.quizgame.models.PlayerTwoController;
import com.ocadohackathon.quizgame.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/input")
public class GameInputController {
    private PlayerOneController playerOne;
    private PlayerTwoController playerTwo;

    @Autowired
    public GameInputController(PlayerOneController playerOne, PlayerTwoController playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    @PostMapping(value = "/playerOne",consumes = "application/json")
    public void playerOneControllerData(@RequestBody Controller controller) {
        playerOne.setxAxis(controller.getxAxis());
        playerOne.setyAxis(controller.getyAxis());
        playerOne.setButton(controller.getButton());

        /*if (QuizGame.playerToAnswer.isButtonClicked()) {
            QuizGame.playerToAnswer.takeAction(controller.getxAxis(),
                    controller.getyAxis(),controller.getButton());
        }*/
            QuizGame.playerToAnswer.setButtonClicked(true);
    }

    @PostMapping(value = "/playerTwo", consumes = "application/json")
    public void playerTwoControllerData(@RequestBody Controller controller){
        playerTwo.setxAxis(controller.getxAxis());
        playerTwo.setyAxis(controller.getyAxis());
        playerTwo.setButton(controller.getButton());
        if (QuizGame.playerToAnswer.isButtonClicked()) {

        } else {
            QuizGame.playerToAnswer.setButtonClicked(true);
        }
    }

    @GetMapping("/test")
    public Controller sendQuestion() {
        return new Controller(515,0,1);
    }

}
