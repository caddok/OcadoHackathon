package com.ocadohackathon.quizgame.game;

import com.ocadohackathon.quizgame.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Console;
import java.util.Random;

@Component
public class QuizGame implements GameActions {
    private Player playerOne;
    private Player playerTwo;
    private InMemoryQuestionAnswerRepository questionAnswerRepository;


    @Autowired
    public QuizGame(Player playerOne, Player playerTwo, InMemoryQuestionAnswerRepository questionAnswerRepository) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.questionAnswerRepository = questionAnswerRepository;
    }

    @Override
    public void startGame() {
        System.out.println(GameMessages.START_OF_GAME_MESSAGE);
        Console console = System.console();
        while (playerOne.getScore() < 100 || playerTwo.getScore() < 100) {
            askNextQuestion();
        }
    }

    @Override
    public void checkResults(Player playerOne, Player playerTwo) {

    }


    private void askNextQuestion() {
        int questionId = chooseQuestion();

    }

    private Integer chooseQuestion() {
        Random random = new Random();
        int questionId = random.nextInt(questionAnswerRepository.
                getQuestionListHashMap().keySet().size());
        if (questionAnswerRepository.checkIfQuestionWasAsked(questionId)) {
            chooseQuestion();
        }
        return questionId;
    }
}
