package com.ocadohackathon.quizgame.game;

import com.ocadohackathon.quizgame.models.Answer;
import com.ocadohackathon.quizgame.models.Question;
import org.springframework.stereotype.Component;

import java.util.*;

//@Component
public class InMemoryQuestionAnswerRepository {
    private HashMap<Question, Answer> questionListHashMap;
    private Set<Integer> askedQuestionsIds;

    public InMemoryQuestionAnswerRepository() {
        questionListHashMap = new HashMap<>();
        askedQuestionsIds = new HashSet<>();
        init();
    }

    public HashMap<Question, Answer> getQuestionListHashMap() {
        return questionListHashMap;
    }

    public void setQuestionListHashMap(HashMap<Question, Answer> questionListHashMap) {
        this.questionListHashMap = questionListHashMap;
    }

    private void init() {
        List<String> firstQuestionAnswers = new ArrayList<>();
        firstQuestionAnswers.add("Urii Gagarin");
        firstQuestionAnswers.add("Alan Shepard");
        firstQuestionAnswers.add("Jim Lovell");
        firstQuestionAnswers.add("Peggy Whitson");
        Answer firstAnswers = new Answer();
        firstAnswers.setAnswers(firstQuestionAnswers);
        firstAnswers.setIndexOfCorrectAnswer(0);
        Question firstQuestion = new Question(0,"Who was the first man to fly around the earth with a spaceship?");
        questionListHashMap.put(firstQuestion,firstAnswers);

        List<String> secondQuestionAnswers = new ArrayList<>();
        secondQuestionAnswers.add("Africa");
        secondQuestionAnswers.add("The northern hemisphere");
        secondQuestionAnswers.add("Europe");
        secondQuestionAnswers.add("Australia");
        Answer secondAnswers = new Answer();
        secondAnswers.setAnswers(secondQuestionAnswers);
        secondAnswers.setIndexOfCorrectAnswer(1);
        Question secondQuestion = new Question(1,"On which hemisphere were the most dinosaur skeletons found?");

        questionListHashMap.put(secondQuestion,secondAnswers);

        List<String> thirdQuestionAnswers = new ArrayList<>();
        thirdQuestionAnswers.add("Pink");
        thirdQuestionAnswers.add("Purple");
        thirdQuestionAnswers.add("Blue");
        thirdQuestionAnswers.add("Green");
        Answer thirdAnswers = new Answer();
        thirdAnswers.setAnswers(thirdQuestionAnswers);
        thirdAnswers.setIndexOfCorrectAnswer(2);
        Question thirdQuestion = new Question(2,"What color is cobalt?");


        questionListHashMap.put(thirdQuestion,thirdAnswers);

        List<String> fourthQuestionAnswers = new ArrayList<>();
        fourthQuestionAnswers.add("Bridgestone");
        fourthQuestionAnswers.add("Michelin");
        fourthQuestionAnswers.add("Pirreli");
        fourthQuestionAnswers.add("GoodYear");
        Answer fourthAnswers = new Answer();
        fourthAnswers.setAnswers(fourthQuestionAnswers);
        fourthAnswers.setIndexOfCorrectAnswer(3);
        Question fourthQuestion = new Question(3,"Who invented vulcanized rubber?");

        questionListHashMap.put(fourthQuestion,fourthAnswers);
    }

    public Set<Integer> getAskedQuestionsIds() {
        return askedQuestionsIds;
    }

    public void setAskedQuestionsIds(Set<Integer> askedQuestionsIds) {
        this.askedQuestionsIds = askedQuestionsIds;
    }

    public boolean checkIfQuestionWasAsked(Integer questionId) {
        return !askedQuestionsIds.contains(questionId);
    }

}
