package com.ocadohackathon.quizgame.game;

import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.gui2.dialogs.ActionListDialogBuilder;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.ocadohackathon.quizgame.models.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

public class QuizGame {
    private PlayerOneController playerOne;
    private PlayerTwoController playerTwo;
    private InMemoryQuestionAnswerRepository questionAnswerRepository;
    public static Player playerToAnswer;
    public QuizGame() {

    }

    @Autowired
    public QuizGame(PlayerOneController playerOne, PlayerTwoController playerTwo, InMemoryQuestionAnswerRepository questionAnswerRepository) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.questionAnswerRepository = questionAnswerRepository;
        startGame();
    }

    private void startGame() {
        System.out.println(GameMessages.START_OF_GAME_MESSAGE);
        while (playerOne.getScore() < 100 || playerTwo.getScore() < 100) {
            askNextQuestion();
        }
    }


    private void askNextQuestion() {
        int questionId = chooseQuestion();
        Optional<Question> questionToAsk = questionAnswerRepository
                .getQuestionListHashMap()
                .keySet()
                .stream()
                .filter(q -> q.getId() == questionId)
                .findFirst();
        Answer answers;
        if (questionToAsk.isPresent()) {
            answers = questionAnswerRepository.getQuestionListHashMap()
                    .get(questionToAsk.get());
            visualizeQuestionAndAnswers(questionToAsk.get(), answers);
            questionToAsk.get().visualizeQuestion();
            answers.visualizeAnswers();
            questionAnswerRepository.getAskedQuestionsIds().add(questionToAsk.get().getId());
        }
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

    private void visualizeQuestionAndAnswers(Question question, Answer answer) {
        Terminal terminal = null;
        try {
            terminal = new DefaultTerminalFactory().createTerminal();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Screen screen = null;
        try {
            screen = new TerminalScreen(terminal);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            screen.startScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Setup WindowBasedTextGUI for dialogs
        final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);
        final boolean[] correctAnswer = {false};
        new ActionListDialogBuilder()
                .setTitle("Question")
                .setDescription("Choose the correct answer")
                .addAction("A) ", () ->
                        correctAnswer[0] = checkCorrectAnswer(0,answer))
                .addAction("B) ", () ->
                        correctAnswer[0] = checkCorrectAnswer(1,answer))
                .addAction("C) ", () ->
                        correctAnswer[0] = checkCorrectAnswer(2,answer))
                .addAction("D) ", () ->
                        correctAnswer[0] = checkCorrectAnswer(3, answer))
                .build()
                .showDialog(textGUI);
        if (correctAnswer[0] && playerToAnswer instanceof PlayerOneController) {
            playerOne.setScore(10);
        } else if (correctAnswer[0] && playerToAnswer instanceof PlayerTwoController) {
            playerTwo.setScore(10);
        }
    }

    private boolean checkCorrectAnswer(int position, Answer answer) {
        return answer.getIndexOfCorrectAnswer() == position;
    }
}
