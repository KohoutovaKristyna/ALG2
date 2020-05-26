/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 * This class enables to create Result object type
 * @author kristyna kohoutova
 */
public class Result {
    private int questionNumber;
    private answerOption answered;
    private answerOption correctAnswer;
    /**
     * This method createst the Result object
     * @param questionNumber is the number of the question
     * @param answered is what the user answered
     * @param correctAnswer is what is the correct answer
     */
    public Result(int questionNumber, answerOption answered, answerOption correctAnswer) {
        this.questionNumber = questionNumber;
        this.answered = answered;
        this.correctAnswer = correctAnswer;
    }
    /**
     * This method createst the Result object (it is the second constructor)
     * @param questionNumber is the number of the question
     * @param answered is what the user answered
     */
    public Result(int questionNumber, answerOption answered) {
        this.questionNumber = questionNumber;
        this.answered = answered;
    }
    /**
     * Enables to get the number of the question 
     * @return the question number
     */
    public int getQuestionNumber() {
        return questionNumber;
    }
    /**
     * Enables to set the number of the question
     * @param questionNumber is the question number
     */
    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }
    /**
     * Enables to get what the user answered
     * @return what the user answered
     */
    public answerOption getAnswered() {
        return answered;
    }
    /**
     * Enables to set the answer option
     * @param answered is the option which the user answered
     */
    public void setAnswered(answerOption answered) {
        this.answered = answered;
    }
    /**
     * Enables to get the option which is correct
     * @return the correct answer
     */
    public answerOption getCorrectAnswer() {
        return correctAnswer;
    }
    /**
     * Enables to set the correct answer
     * @param correctAnswer is the correct answer
     */
    public void setCorrectAnswer(answerOption correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
    
    
    
            
            
}
