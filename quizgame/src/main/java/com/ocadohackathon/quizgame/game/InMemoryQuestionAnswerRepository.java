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

        questionListHashMap.put(new Question(0,"Who was the first man to fly around the earth with a spaceship?",
                new Answer(new ArrayList("Urii Gagarin","Alan Shepard","Jim Lovell","Peggy Whitson"),0)));

        questionListHashMap.put(new Question(1,"On which hemisphere were the most dinosaur skeletons found?",
                new Answer(new ArrayList("Africa","Europe","The northern hemisphere", "Australia"),2)));

        questionListHashMap.put(new Question(2,"What color is cobalt?",
                new Answer(new ArrayList("Pink","Purple","Blue","Green"),1)));

        questionListHashMap.put(new Question(3,"Who invented vulcanized rubber?",
                new Answer(new ArrayList("Bridgestone","Michelin","Pirreli","GoodYear"),3)));


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
