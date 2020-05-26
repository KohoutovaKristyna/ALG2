/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 * This class enables to keep data for the final statistic
 * @author kristyna kohoutova
 */
public class StatisticResult {
    int correct = 0;
    int wrong = 0;
    String elapsedTime = "";
    /**
     * This method creates an object StatisticResult
     * @param correct is number of how many questions were answered correctly
     * @param wrong is number of how many questions were answered wrong
     * @param elapsedTime is time how long it took to answer all the questions
     */
    public StatisticResult(int correct, int wrong, String elapsedTime) {
        this.correct = correct;
        this.wrong = wrong;
        this.elapsedTime = elapsedTime;
    }
    /**
     * This method is a constructor without any paramether
     */
    public StatisticResult() {
    }
    /**
     * Enables to get the number of correctly answered questions
     * @return the number of correctly answered questions
     */
    public int getCorrect() {
        return correct;
    }
    /**
     * Enables to set the number of correctly answered questions
     * @param correct is the number of correctly answered questions
     */
    public void setCorrect(int correct) {
        this.correct = correct;
    }
    /**
     * Enables to get the number of wrong answered questions
     * @return the number of wrong answered questions
     */
    public int getWrong() {
        return wrong;
    }
    /**
     * Enables to set the number of wrong answered questions
     * @param wrong is the number of wrong answered questions
     */
    public void setWrong(int wrong) {
        this.wrong = wrong;
    }
    /**
     * Enables to get the time it took to answer all the questions
     * @return the time 
     */
    public String getElapsedTime() {
        return elapsedTime;
    }
    /**
     * Enables to set the elapse time
     * @param elapsedTime is the time we want to set
     */
    public void setElapsedTime(String elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
}
