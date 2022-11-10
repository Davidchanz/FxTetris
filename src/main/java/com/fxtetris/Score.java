package com.fxtetris;

public class Score {
    private String date;
    private Integer score;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    Score(String date, Integer score){
        setScore(score);
        setDate(date);
    }
}
