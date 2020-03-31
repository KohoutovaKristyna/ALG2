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
    public double computeValue(double x){
        //x2 +2; pre x 3 bude hodnota 11   - vyuzit hornerovo schema
        double y = 0;
        for (int i = 0; i < coef.length; i++) {
            y = y * x + coef[i];
        }
        return y;
    }
    
    //metoda ktera bude vracet hodnotu polynomu
    
    //TO DO bonus
    //zjistit integral v zadanem rozpeti
    public double integrate(double a, double b){
//        String output = "";
        double sumA=0, sumB=0;
        int array[]= new int[coef.length];
        double tmp=0;
        if(a<b){
            b=tmp;
            b=a;
            a=tmp;            
        }
        for (int i = 0; i < coef.length; i++) {
            array[i]= coef.length-i;
        }       
        for (int i = 0; i < coef.length; i++) {
          sumA += (coef[i]/array[i])*(Math.pow(a, array[i])); 
          sumB += (coef[i]/array[i])*(Math.pow(b, array[i]));
        }    
        System.out.println(sumA);
        System.out.println(sumB);
        return sumA - sumB;
    }
    
    //toString - pekne a matematicky spravne i se striskou, a zadne 0x
    @Override
    public String toString() {
        String output = "";
        for (int i = coef.length - 1; i >= 0; i--) {
            if (coef[i] != 0) {
                if (coef[i] != 1) {
                    if (coef[i] > 0) {       //znamenko
                        output += " +";
                    } else {
                        output += " ";
                    }
                    output += coef[i];
                }                                                         
                if (i > 1) {
                    output += "x^" + i + " ";
                } else {
                    if (i == 1) {
                        output += "x ";
                    }
                }
            }
        }
        
        return output;
    }
    
    
    public static void main(String[] args){
//        double[] coef = {3.2,0,-2,5};
//        Polynom p = Polynom.getInstanceReverted(coef);
//        System.out.println(p);
//        System.out.println(p.derivate());
        double[] coef = {5,3,2};
        Polynom d = Polynom.getInstanceReverted(coef);
        System.out.println(d.computeValue(3));
//        for (int i = coef.length-1; i > 0; i--) {
//              System.out.println(i+1);
//        }
        System.out.println(d.integrate(2,1));
        
        
    }
    
}
