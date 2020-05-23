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

    public void showByAlphabet();

    public void showByCorrectness();

    public void endTimer();

    public void startTimer();
}
