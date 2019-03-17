package com.ocadohackathon.quizgame.models;

public class Question {
    private Integer id;
    private String questionBody;

    public Question(Integer id, String questionBody) {
        this.id = id;
        this.questionBody = questionBody;
    }

    public String getQuestionBody() {
        return questionBody;
    }

    public void setQuestionBody(String questionBody) {
        this.questionBody = questionBody;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (!id.equals(question.id)) return false;
        return questionBody.equals(question.questionBody);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + questionBody.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Question: "  + questionBody;
    }
}
