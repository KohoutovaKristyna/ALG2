/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author kristyna kohoutova
 */
@XmlRootElement(name = "Questions")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuestionList{
    
    @XmlElement(name = "Question")
    private ArrayList<Question> questionList = new ArrayList<Question>();

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public void addQuestion(Question question){
        this.questionList.add(question);
    }
    
    public int getSize(){
        return questionList.size();
    }
    public Question getQuestion(int index){
        return questionList.get(index);
    }
    public void shuffleQuestions(){
        Collections.shuffle(questionList);
    }
    
    public void sortByGNumber(){
        Collections.sort(questionList, Comparator.comparing(app.Question::getqNumber));
    
    }
    public void sortByCorrectnes(){
        Collections.sort(questionList, Comparator.comparing(app.Question::getCorrectAnswer));
    }

//    @Override
//    public int compareTo(Object o) {
//        if(this.equals(o)){
//        
//        }
//
//    }
    
    
}
