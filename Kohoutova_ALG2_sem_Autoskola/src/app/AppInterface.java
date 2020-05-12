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
    public void createTestPerson(String jmeno, String prijmeni, String email);
    
    public void showQuestion();
    
    public void takeAnswer(String answer);  

    public void giveResults();

    public void showByAlphabet();

    public void showByCorrectness();

    public void endTimer();

    public void startTimer();
}
