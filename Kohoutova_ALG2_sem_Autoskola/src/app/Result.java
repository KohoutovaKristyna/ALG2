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
public class Result {
    private int questionNumber;
    private answerOption answered;
    private answerOption correctAnswer;

    public Result(int questionNumber, answerOption answered, answerOption correctAnswer) {
        this.questionNumber = questionNumber;
        this.answered = answered;
        this.correctAnswer = correctAnswer;
    }
    public Result(int questionNumber, answerOption answered) {
        this.questionNumber = questionNumber;
        this.answered = answered;
    }

    
    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public answerOption getAnswered() {
        return answered;
    }

    public void setAnswered(answerOption answered) {
        this.answered = answered;
    }

    public answerOption getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(answerOption correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
    
    
    
            
            
}
