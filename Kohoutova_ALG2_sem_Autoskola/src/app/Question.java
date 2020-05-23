/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * This class enables to create the Question object type, the parent of the object Answer
 * @author kristyna kohoutova
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Question {
    @XmlAttribute(name = "Id")
    private int qNumber;
    @XmlElement(name = "QuestionText")
    private String question;
    @XmlElement(name = "Answer")
    private ArrayList<Answer> answerList = new ArrayList<Answer>();   
    /**
     * Enables to get the number of the question
     * @return the number of the question
     */
    public int getqNumber() {
        return qNumber;
    }
    /**
     * Enables to get the text of the question
     * @return the question text
     */
    public String getQuestion() {
        return question;
    }
    /**
     * Enables to set the answer list
     * @param anwerList is the list of the 3 answers
     */
    public void setAnwerList(ArrayList<Answer> anwerList) {
        this.answerList = anwerList;
    }
    /**
     * Enables to set the question name
     * @param qNumber is the question name
     */
    public void setqNumber(int qNumber) {
        this.qNumber = qNumber;
    }
    /**
     * Enables to set the question text
     * @param question is the question text
     */
    public void setQuestion(String question) {
        this.question = question;
    }
    /**
     * Provides the list of answers
     * @return the list of answers
     */
    public ArrayList<Answer> getAnwerList() {
        return answerList;
    }
    /**
     * Finds out which answer is the correct answer
     * @return the correct answer
     */
    public answerOption getCorrectAnswer(){
        if(answerList.get(0).isIsCorrect()){
            return answerOption.a;
        }
        else if(answerList.get(1).isIsCorrect()){
            return answerOption.b;
        }else{
            return answerOption.c;
        }
    }
    public answerOption getYourAnswer(){
        if(answerList.get(0).isYourAnswer()){
            return answerOption.a;
        }
        else if(answerList.get(1).isYourAnswer()){
            return answerOption.b;
        }else{
            return answerOption.c;
        }
    }

    public void addToAnswers(Answer answer) {
            this.answerList.add(answer);
    }

    
}
