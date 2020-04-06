/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kohoutova_bank;

import java.util.ArrayList;

/**
 *
 * @author kristyna kohoutova
 */
public class Main {
    public static ArrayList<Client> clients = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //1
        Person pekar = new Person("Pekar");
        Person svecova = new Person("Svecova");
        Company skoda = new Company("Skoda");
        
        clients.add(pekar); 
        clients.add(svecova); 
        clients.add(skoda); 
        
        //2
        pekar.addAccount(1000);
        pekar.addAccount(500);
        
        svecova.addAccount(1200);
        
        skoda.addAccount(120);
        
        
        //3
        System.out.println(clients.get(0).getName() + " a castka je: " + clients.get(0).giveSumAll());
        System.out.println(clients.get(1).getName() + " a castka je: " + clients.get(1).giveSumAll());
        System.out.println(clients.get(2).getName() + " a castka je: " + clients.get(2).giveSumAll());
    }
    
}
