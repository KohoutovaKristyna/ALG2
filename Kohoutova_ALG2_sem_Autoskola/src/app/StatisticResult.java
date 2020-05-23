/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author kristyna kohoutova
 */
public class StatisticResult {

    public StatisticResult(int correct, int wrong, String elapsedTime) {
        this.correct = correct;
        this.wrong = wrong;
        this.elapsedTime = elapsedTime;
    }

    public StatisticResult() {
    }
    
    int correct = 0;
    int wrong = 0;
    String elapsedTime = "";

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    public String getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(String elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
}
