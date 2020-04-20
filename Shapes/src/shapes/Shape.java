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
public abstract class Shape implements Comparable<Shape>{ //nebudou se z ni vytvaret objekty, jen k prekryti
    //data
    protected String name = "Geometric shape";
    
    //methods
    public abstract double area(); //kvli abstract nedavam tride kod, NESMI MIT KOD
    
    public String getShapeName(){
        return this.getClass().getSimpleName();
    }
    
    @Override
    public String toString(){
        return name + " " +  getShapeName();
    }
    
    @Override
    public int compareTo(Shape s){
         double EPS = 0.0001;
        double diff = area() - s.area();
        
        if(Math.abs(diff)<EPS){
            return 0;
        } else if(diff > 0){
            return 1;
        } else{
            return -1;
        }
    }
}
