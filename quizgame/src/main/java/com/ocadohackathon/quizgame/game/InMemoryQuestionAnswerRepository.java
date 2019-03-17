package com.ocadohackathon.quizgame.game;

import com.ocadohackathon.quizgame.models.Answer;
import com.ocadohackathon.quizgame.models.Question;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Component
public class InMemoryQuestionAnswerRepository {
    private HashMap<Question, Answer> questionListHashMap;
    private Set<Integer> askedQuestionsIds;

    public InMemoryQuestionAnswerRepository() {
        questionListHashMap = new HashMap<>();
        init();
    }

    public HashMap<Question, Answer> getQuestionListHashMap() {
        return questionListHashMap;
    }

    public void setQuestionListHashMap(HashMap<Question, Answer> questionListHashMap) {
        this.questionListHashMap = questionListHashMap;
    }

    private HashMap<Question, Answer> init() {
        return questionListHashMap;
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
