package com.shinta.myreprover2.Quiz;

public class Pertanyaan {
    private String question;
    private String question2;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;
    private int statusPr;
    private int answerNr;

    public Pertanyaan() {}

    public Pertanyaan(String question, String question2,String option1, String option2, String option3, String option4, String option5,int statusPr, int answerNr) {
        this.question = question;
        this.question2 = question2;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.statusPr = statusPr;
        this.answerNr = answerNr;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getOption5() {
        return option5;
    }

    public void setOption5(String option5) {
        this.option5 = option5;
    }

    public int getStatusPr() {
        return statusPr;
    }

    public void setStatusPr(int statusPr) {
        this.statusPr = statusPr;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }
}
