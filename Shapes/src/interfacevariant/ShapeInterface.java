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
public interface ShapeInterface { //nebudou se z ni vytvaret objekty, jen k prekryti
    final String NAME = "Geometric shape";
    //methods
    public double area(); 
    
    default String getShapeName(){
        return this.getClass().getSimpleName();
    }    

    public int compareTo(ShapesApp o);
    
}
