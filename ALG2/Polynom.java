/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomy;

import java.util.Arrays;

/**
 *
 * @author tynka
 */
public class Polynom {
    //5x3 + 2x2 + 3
    //data
    private double[] coef;
    
    //constructor
    /*5 2 0 3
    [5,3,0,3]
    3 0 2 5
    [3,0,2,5]
    5x3 + 2x2 + 3*/
    
    private Polynom(double[] coef){  // defenzivni kopie
        double[] coefTemp = new double [coef.length];
        System.arraycopy(coef,0,coefTemp,0, coef.length);
        this.coef=coefTemp;
    }
    
    
    public static Polynom getInstanceReverted(double...coef){  //bere to jako hodnoty, ze kterych vytvori hned pole
    return new Polynom(coef);
    }
    
    public static Polynom getInstance(double[] coef){
        double[] coefTemp = new double[coef.length];
        for (int i = 0; i < coef.length; i++) {
            coefTemp[coef.length-1-i]=coef[i];
        }
        return new Polynom(coefTemp);
    }
    
    
    //metody
    public int getDegree(){
        return coef.length-1;
     }
    public double getCoefAt(int exponent){
        return coef[exponent];
    }
    public double[] getCoef(){
        return Arrays.copyOf(coef, coef.length);  //defenzivna kopie
    }
    public Polynom derivate(){
        //5*3 15x2
        double[] derivation = new double[coef.length-1];
        for (int i = 0; i < derivation.length; i++) {
            derivation[i] = coef[i+1]*(i+1);
        }
        return new Polynom(derivation);
    }
    
    //TO DO
    /*public double computeValue(double x){
        //x2 +2; pre x 3 bude hodnota 11   - vyuzit hornerovo schema
        //return y;
    }*/
    
    //metoda ktera bude vracet hodnotu polynomu
    
    //TO DO bonus
    //zjistit integral v zadanem rozpeti
    /*public double integrate(double a, double b){
    
    }*/
    
    //toString - pekne a matematicky spravne i se striskou, a zadne 0x
    @Override
    public String toString(){
        return Arrays.toString(coef);
    }
    
    public static void main(String[] args){
        double[] coef = {3,0,2,5};
        Polynom p = Polynom.getInstanceReverted(coef);
        System.out.println(p);
        System.out.println(p.derivate());
    }
    
}
