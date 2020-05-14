/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author kristyna kohoutova
 */
public class Main {
public static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Zadej jmena vstupnych souboru:");
        Competition c = new Competition();
        String startFile = sc.next();
        String finishFile = sc.next();
        try{
        while(true){
        try{
            c.load(startFile, finishFile);
            break;
        }
//        }catch(IllegalArgumentException e){
//            System.out.println(e.getMessage()+ " Zadej znovu.");
//        }
        catch(FileNotFoundException | IllegalArgumentException e){
            System.out.println("Neexistujici soubor/y. Zadej znovu");
            e.printStackTrace();
        }}
        System.out.println(c.getResults());
        System.out.println("Zadej jmeno vysledneho souboru");
        String resultFile = sc.next();
        c.saveResults(resultFile);
        }catch(IOException e){
            System.out.println("Nepovedlo se");
        }
    }
    
}
