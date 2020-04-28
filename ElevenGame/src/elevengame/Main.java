/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevengame;

import java.util.Scanner;

/**
 *
 * @author kristyna kohoutova
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static BordInterface bord;

    public static void main(String[] args) {
        String[] symbol = {"Srdce", "Piky", "Krize", "Kara"};
        String[] value = { "A","2", "3", "4","5","6", "7", "8","9","10", "J", "Q", "K"};
        int[] nPoints = {1,2,3,4,5,6,7,8,9,10,0,0,0}; 
         bord = new Bord(symbol, value, nPoints, 9);
        
        while (bord.isAnotherPlayPossible()) {  // zda jsou jeste karty v balicku, na stole a existuje suma 11
            System.out.println("************** " + bord.getName() + " ***************");
            displayCards();
            displayDeck();
            System.out.println("Vyber karty");
            String[] selectedCardsPositions = sc.nextLine().split(" +");
            if (!bord.playAndReplace(selectedCardsPositions)) {
                System.out.println("Nevalidni tah");
            }
//            } else {
//                displayCards();
//                displayDeck();
//            }
        }
        if(bord.hasWon()){
            System.out.println("Gratuluji");
        }
        else{
            System.out.println("Nelze hrat");
        }
    }

    private static void displayCards() {
        for (int i = 0; i < bord.nCards(); i++) {
            System.out.format("%1d. %10s   ", i + 1, bord.getCardDescriptionAt(i));
            if ((i + 1) % 3 == 0) {
                System.out.println("");
            }
        }
    }

    private static void displayDeck() {
        System.out.println("V balicku je " + bord.getDeckSize() + " karet");
    }

}
