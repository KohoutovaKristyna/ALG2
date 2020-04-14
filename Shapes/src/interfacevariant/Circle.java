/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacevariant;

import shapes.*;

/**
 *
 * @author kristýna kohoutová
 */
public class Circle implements ShapeInterface {  //Cyrcle je typove kompatibilni s ShapeInterface, implementuje metody definovane v interface
       //data
    private double r;

    private Circle(double r) {
        this.r = r;
    }
    
    public static Circle getInstance(double d){
        return new Circle(d/2);
    }
     
    public static Circle getInstanceR(double r){
        return new Circle(r);
    }
    //To do udelat pomoci tovarni metody
//    public Circle(double d) {
//        this.r = d/2;
//    }

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
      //  return "Circle{" + "r=" + r + '}';
      return super.toString() + String.format(" r = %.2f", r);
    }
    
    @Override
    public double area(){
        return Math.PI*r*r;
    }
    public static void main(String[] args) {
        Circle c = Circle.getInstanceR(4);
        System.out.println(c);
        System.out.println(c.area());
        System.out.println(c.getShapeName());
    } 

    @Override
    public int compareTo(interfacevariant.ShapesApp o) {
        if((this.area() - o.area())>0){
            return 1;
        }
        else if((this.area() - o.area())<0){
            return -1;
        }
        else{
            return 0;
        }
    }

}
