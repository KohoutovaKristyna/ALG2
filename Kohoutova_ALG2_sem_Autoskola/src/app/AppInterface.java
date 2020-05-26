/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;

/**
 *
 * @author kristyna kohoutova
 */
public interface AppInterface {
    /**
     * This method is the constructor of the object TestPerson (it creates the object)  
     * @param jmeno is the firstname of the person
     * @param prijmeni is the surname of the person
     */
    public void createTestPerson(String jmeno, String prijmeni);
    /**
     * Shows the selected question
     * @param number is the number of the selected question
     * @return formated output of the selected question
     */
    public String showQuestion(int number);
    /**
     * Method takes the answer the user gave and set it to the list 
     * @param questionNo it the number of the anwered question
     * @param answer is the answer from the user
     * @return if everything was ok (the answer was a/b/c)
     */
    public boolean takeAnswer(int questionNo, String answer);  
    /**
     * Method return the string of formated results
     * @return the results
     */
    public String giveResults();
    /**
     * Method shows the extended version of questions with the user answer, odered by the question text
     * @return return the ordered list of questions
     */
    public String showByAlphabet();
    /**
     * Method shows the extended version of questions with the user answer, ordered by the correctness
     * @return return the ordered list of questions
     */
    public String showByCorrectness();
    /**
     * Method ends the timer of the elapsed time
     */
    public void endTimer();
    /**
     * Method starts the timer of for start elapsing the time
     */
    public void startTimer();
    /**
     * Method writes the test results to the file
     * @param firstName is the firstname of the person
     * @param surName is the surname of the person
     * @param fileContent is what we want to write to the file
     * @return if was everything ok
     */    
    public boolean writeResultToFile(String firstName, String surName, String fileContent) ;
    /**
     * Method resets the list with the questions and the results of the test
     */
    public void resetInformations();
    /**
     * Method calls the showAllTestResults method and gives it the file name
     * @return the formated string of the user's results
     */
    public String callThePreviousTestResults();
  
   
   
}
