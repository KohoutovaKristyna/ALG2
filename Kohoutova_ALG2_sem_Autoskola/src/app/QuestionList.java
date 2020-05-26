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
 * This class enables to work with a list of the questions
 * @author kristyna kohoutova
 */
@XmlRootElement(name = "Questions")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuestionList{
    
    @XmlElement(name = "Question")
    private ArrayList<Question> questionList = new ArrayList<Question>();
    /**
     * This method enables to get the list of the questions and work with them 
     * @return the question list
     */
    public ArrayList<Question> getQuestionList() {
        return questionList;
    }
    /**
     * Enables to add a question to the list
     * @param question is the question we need to add
     */
    public void addQuestion(Question question){
        this.questionList.add(question);
    }
    /**
     * Enables to get the size of the list
     * @return the size of the list 
     */
    public int getSize(){
        return questionList.size();
    }
    /**
     * Enables to get the question on the index
     * @param index is the number of the question in the list
     * @return the question
     */
    public Question getQuestion(int index){
        return questionList.get(index);
    }
    /**
     * This method shuffle the order of the questions in the list
     */
    public void shuffleQuestions(){
        Collections.shuffle(questionList);
    }
    /**
     * The method sort the list of the questions by the question text
     */
    public void sortByQuestionText(){
        Collections.sort(questionList, Comparator.comparing(app.Question::getQuestion));
    /**
     * The method sort the list of the questions depending on the user answer, if it was correct or wrong (first are the correct answers)
     */
    }
    public void sortByCorrectnes(){
        Collections.sort(questionList, Comparator.comparing(app.Question::getCorrectAnswer));
    }   
}
