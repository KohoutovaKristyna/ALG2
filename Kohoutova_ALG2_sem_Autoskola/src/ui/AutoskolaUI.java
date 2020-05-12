/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import app.AppInterface;
import app.AutoskolaEditor;
import java.util.Scanner;

/**
 *
 * @author kristyna kohoutova
 */
public class AutoskolaUI{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declaration
        Scanner sc = new Scanner(System.in);
        AppInterface aut = new AutoskolaEditor();
        boolean keepGoing = true;
        String userAnswer;
        boolean wrongAnswer;
        String jmeno, prijmeni, email;
        String answer;
        boolean keepShowing = true;
        String showingAN;
        String resultChoise;

        //the body of program
        while (keepGoing) {
            System.out.println("Vitejte v testovacim programu");
            System.out.println("Zadejte sve krestni jmeno");
            jmeno = sc.nextLine();
            System.out.println("Zadejte sve prijmeni");
            prijmeni = sc.nextLine();
            System.out.println("Zadejte svuj email, pro odeslani vyhodnocenych vysledku");
            email = sc.nextLine();
            aut.createTestPerson(jmeno, prijmeni, email);
            
            for (int i = 0; i < 10; i++) {
                aut.showQuestion();
                if (i==0) {
                    aut.startTimer();
                }
                answer = sc.nextLine();
                aut.takeAnswer(answer);
            }
            aut.endTimer();
            
            aut.giveResults();
            
            // tady bude push do databaze???
            while(keepShowing){                  //asi umelat metodu z toho
            System.out.println("Zadejte jakym zpusobem chcete zobrazit statistiku vysledku");
            System.out.println("1 Podle poradi otazek");
            System.out.println("2 Podle spravnosti");
            resultChoise = sc.nextLine();
            if(resultChoise.equals("1")){
                aut.showByAlphabet();
            }
            else if(resultChoise.equals("2")){
                aut.showByCorrectness(); 
            }
            else{
                System.out.println("Spatna volba zkuste to znovu");
            }
            
                System.out.println("Chcete jeste nejake zobrazeni? (a)");
                showingAN = sc.nextLine();
                if(!showingAN.toLowerCase().equals("a")){
                    keepShowing = false;
                }                
            }
            
            
            
            
            //find out if user wants to continue
            System.out.println("Chcete pokracovat? a/n");     //asi z toho udelat metodu
            userAnswer = sc.nextLine();
            if (userAnswer.toLowerCase().equals("a")) {

            } else if (userAnswer.toLowerCase().equals("n")) {
                keepGoing = false;
            } else {           // if user enter something else it will not let him continue or end
                wrongAnswer = false;
                while (wrongAnswer == false) {
                    System.out.println("Spatna odpoved, zkuste to znovu");
                    userAnswer = sc.nextLine();
                    if (userAnswer.toLowerCase().equals("a") || userAnswer.toLowerCase().equals("n")) {
                        wrongAnswer = true;
                        if (userAnswer.toLowerCase().equals("a")) {

                        } else if (userAnswer.toLowerCase().equals("n")) {
                            keepGoing = false;
                        }
                    }
                }
            }
        }
    }
}
