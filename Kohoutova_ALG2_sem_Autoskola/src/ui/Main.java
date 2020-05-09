/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Scanner;

/**
 *
 * @author kristyna kohoutova
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declaration
        Scanner sc = new Scanner(System.in);
        boolean keepGoing = true;
        String userAnswer;
        boolean wrongAnswer;

        //the body of program
        while (keepGoing) {
            
            
            
            
            
            //find out if user wants to continue
            System.out.println("Chcete pokracovat? a/n");
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
