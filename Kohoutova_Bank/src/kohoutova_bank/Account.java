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
public class Account {
    private double sum;
    private String name;

    public Account(String name) {
        this.name = name;
    }

    public Account(double sum, String name) {
        this.sum = checkAccount(sum);
        this.name = name;
    }

    private double checkAccount(double sum){
        if(sum < 0){
            throw new IllegalArgumentException("Account can not be less than 0");
        }
        return sum; 
    }
    public void giveMoney(double money){
        this.sum += money;
    }
    public void getMoney(double money){
        this.sum -= money;
    }
    public double getSum() {
        return sum;
    }
    
    
    @Override
    public String toString(){
        return "Na uctu je: "+sum; 
    }
    

    
    
}
