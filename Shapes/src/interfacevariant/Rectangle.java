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
public class Rectangle implements ShapeInterface{
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public String toString() {
        //return "Rectangle{" + "a=" + a + ", b=" + b + '}';
        return super.toString() + String.format(" a = %.2f",a, b);
    }
    @Override
    public double area(){
        return a*b;
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
