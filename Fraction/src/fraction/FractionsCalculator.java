/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fraction;

/**
 *
 * @author kristyna kohoutova
 */
public class FractionsCalculator {

    public static int minMultiple(int a, int b) {
        int tmp;
        if (a != b) {
            if (a > b) {
                tmp = b;
                b = a;
                a = tmp;
            }
            for (int i = a; i < a * b; i++) {  //a muze jit i od 1, ale pri velkych cislech je to efektivnejsi
                if ((a * i) % b == 0) {
                    return a * i;
                }
            }
        }
        return a;
    }

    public static Fraction plus(Fraction a, Fraction b) {
        int jmenovatel, citatel;
        int aJmen = a.giveDenominator();
        int bJmen = b.giveDenominator();
        int aCit = a.giveNumerator();
        int bCit = b.giveNumerator();

        jmenovatel = minMultiple(aJmen, bJmen);
        citatel = ((jmenovatel / aJmen) * aCit) + ((jmenovatel / bJmen) * bCit);

        return Fraction.getInstance(citatel, jmenovatel);
    }

    public static Fraction minus(Fraction a, Fraction b) {
        int jmenovatel, citatel;
        int aJmen = a.giveDenominator();
        int bJmen = b.giveDenominator();
        int aCit = a.giveNumerator();
        int bCit = b.giveNumerator();

        jmenovatel = minMultiple(aJmen, bJmen);
        citatel = ((jmenovatel / aJmen) * aCit) - ((jmenovatel / bJmen) * bCit);

        return Fraction.getInstance(citatel, jmenovatel);
    }

    public static Fraction multiply(Fraction a, Fraction b) {
        int jmenovatel, citatel;
        int aJmen = a.giveDenominator();
        int bJmen = b.giveDenominator();
        int aCit = a.giveNumerator();
        int bCit = b.giveNumerator();
        citatel = aCit * bCit;
        jmenovatel = aJmen * bJmen;

        return Fraction.getInstance(citatel, jmenovatel);

    }

    public static Fraction divide(Fraction a, Fraction b) {
        int jmenovatel, citatel;
        int aJmen = a.giveDenominator();
        int bJmen = b.giveDenominator();
        int aCit = a.giveNumerator();
        int bCit = b.giveNumerator();
        citatel = aCit * bJmen;
        jmenovatel = aJmen * bCit;

        return Fraction.getInstance(citatel, jmenovatel);

    }

    public static void main(String[] args) {
        Fraction f = Fraction.getInstance(4, 3);
        Fraction g = Fraction.getInstance(5, 10);
        //scitani
        Fraction h = plus(f, g);
        h.simplify();
        System.out.println(h.toString());
        //odecitani
        Fraction k = minus(f, g);
        k.simplify();
        System.out.println(k.toString());
        //nasobeni
        Fraction m = multiply(f, g);
        m.simplify();
        System.out.println(m.toString());
        //deleni
        Fraction n = divide(f, g);
        n.simplify();
        System.out.println(n.toString());

    }
}
