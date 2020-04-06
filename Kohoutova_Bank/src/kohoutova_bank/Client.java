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
public abstract class Client{
   private String name;
   //private static ArrayList<Account>accounts= new ArrayList<>();
   private ArrayList<Account> accounts = new ArrayList<>();

   public void addAccount(double input){
       
       Account a = new Account(input, name);     
       this.accounts.add(a);   
   }
   
   public double giveSumAll(){
       double sum=0;
       for(Account a: accounts){
           sum+=a.getSum();
       }
       return sum;
   }
   public abstract String getName();

   
   
}
