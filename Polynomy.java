/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomy;

/**
 * Library knihovni trida
 * @author tynka
 */
//vytvorime privatni konstruktor, aby nikdo nemohl vytvorit objekt teto tridy
public class Polynomy {
    private Polynomy(){
        
    }
    public static Polynom sum(Polynom a, Polynom b){
        Polynom max = a.getDegree() > b.getDegree()? a:b;
        Polynom min = a.getDegree() <=b.getDegree()? a:b;
        double[] sum = new double[max.getDegree()+1];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = max.getCoefAt(i);
        }
        for (int i = 0; i <min.getDegree()+1 ; i++) {
            sum[i] = sum[i] + min.getCoefAt(i);
        }
        return Polynom.getInstanceReverted(sum);
    }
    
    public static Polynom multiply(Polynom a, Polynom b){
       int powMax = a.getDegree()*b.getDegree();   // urceni velikosti pole
       double array[] = new double[powMax] ;
       double multi;
       int pow;
        for (int i = 0; i <= a.getDegree(); i++) {
            for (int j = 0; j <= b.getDegree(); j++) {
                multi = a.getCoefAt(i) * b.getCoefAt(j);
                pow = (a.getDegree()-i) + (b.getDegree()-j);
                array[pow]+= multi; 
            }          
        } 
        return Polynom.getInstanceReverted(array);
    }
    
    public static void main(String[] args){
        Polynom p1 = Polynom.getInstanceReverted(3,0,2,5);
        Polynom p2 = Polynom.getInstanceReverted(2,1,4);
        System.out.println(sum(p1,p2));
        
        Polynom a = Polynom.getInstanceReverted(1,3,5);
        Polynom b = Polynom.getInstanceReverted(2,1,4,4);
        System.out.println(multiply(a,b));
       
        
        
         
    }
}
