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
 *
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

    public int getqNumber() {
        return qNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnwerList(ArrayList<Answer> anwerList) {
        this.answerList = anwerList;
    }

    public void setqNumber(int qNumber) {
        this.qNumber = qNumber;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<Answer> getAnwerList() {
        return answerList;
    }

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
    
    
    
}
