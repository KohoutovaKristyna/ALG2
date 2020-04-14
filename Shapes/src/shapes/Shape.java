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
public abstract class Shape { //nebudou se z ni vytvaret objekty, jen k prekryti
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
    
}
