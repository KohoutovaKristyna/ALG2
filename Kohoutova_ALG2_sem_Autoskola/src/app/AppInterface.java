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
public interface AppInterface {
    public void createTestPerson(String jmeno, String prijmeni);
    
    public String showQuestion(int number);
    
    public boolean takeAnswer(int questionNo, String answer);  

    public String giveResults();

    public String showByAlphabet();

    public String showByCorrectness();

    public void endTimer();

    public void startTimer();
    
    public boolean writeResultToFile(String firstName, String surName, String fileContent);
    
    public void resetInformations();
    
    public String showAllTestResults(String fileName);
    
    public String callThePreviousTestResults();

}
