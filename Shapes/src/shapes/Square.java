/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

/**
 *
 * @author kristýna kohoutová
 */
public class Square extends Rectangle{
    private double a;
    
    public Square(double a){
        super(a,a);
    }
    public static void main(String[] args) {
        Square s = new Square(4);
        System.out.println(s.area());
    }

}
