/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fraction;

/**
 *
 * @author týnka
 */
public class Fraction {

  
    private int numerator;
    private int denominator;

    private Fraction(int citatel, int jmenovatel) {
        this.numerator = citatel;
        this.denominator = jmenovatel;
    }

    public static Fraction getInstance(int citatel, int jmenovatel) {  //bere to jako hodnoty, ze kterych vytvori hned pole
        return new Fraction(citatel, jmenovatel);
    }

    public int giveDenominator() {
        return denominator;
    }

    public int giveNumerator() {
        return numerator;
    }

    @Override
    public String toString() {
        String output = "";
        if (denominator == 0) {
            throw new IllegalArgumentException("Can not divide by 0");
        }
        if (numerator == 0) {
            return "0";
        }
        output = numerator + "/" + denominator;
        return output;
    }

    public void simplify() {
        int c;
        int a = numerator;
        int b = denominator;
        while (b != 0) {
            c = b;
            b = a % b;
            a = c;
        }
        numerator = numerator / a;
        denominator = denominator / a;
    }

    public static void main(String[] args) {
        Fraction f = new Fraction(120, 60);
        System.out.println(f.giveNumerator());
        System.out.println(f.giveDenominator());
        f.simplify();
        System.out.println(f.giveNumerator());
        System.out.println(f.giveDenominator());
        System.out.println(f.toString());

    }
    
}
