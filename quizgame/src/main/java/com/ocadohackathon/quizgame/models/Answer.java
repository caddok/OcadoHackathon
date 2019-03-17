package com.ocadohackathon.quizgame.models;

import java.util.List;
import java.util.Objects;

public class Answer {
    private List<String> answers;
    private Integer indexOfCorrectAnswer;


    public Answer(List<String> answers, Integer indexOfCorrectAnswer) {
        this.answers = answers;
        this.indexOfCorrectAnswer = indexOfCorrectAnswer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public Integer getIndexOfCorrectAnswer() {
        return indexOfCorrectAnswer;
    }

    public void setIndexOfCorrectAnswer(Integer indexOfCorrectAnswer) {
        this.indexOfCorrectAnswer = indexOfCorrectAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (!Objects.equals(answers, answer.answers)) return false;
        return Objects.equals(indexOfCorrectAnswer, answer.indexOfCorrectAnswer);
    }

    @Override
    public int hashCode() {
        int result = answers != null ? answers.hashCode() : 0;
        result = 31 * result + (indexOfCorrectAnswer != null ? indexOfCorrectAnswer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String[] letters = new String[4];
        letters[0] = "A) ";
        letters[1] = "B) ";
        letters[2] = "C) ";
        letters[3] = "D) ";
        for (int i = 0; i < answers.size(); i++) {
            builder.append(letters[i]);
            builder.append(answers.get(i));
            if (i  < answers.size()) {
                builder.append("\n");
            }
        }

        return builder.toString();
    }
}
