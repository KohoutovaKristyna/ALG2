/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;
import java.util.ArrayList;
/**
 *
 * @author kristýna kohoutová
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circle c1 = Circle.getInstanceR(1);
        Circle c2 = Circle.getInstanceR(2);
        Rectangle r1 = new Rectangle(2,3);
        Square s1 = new Square(3);
        //double areaAll = c1.area()+ c2.area()+ r1.area() + s1.area();
        
        ArrayList shapes = new ArrayList();
        shapes.add(c1);//Circle IS A object
        shapes.add(c2);
        shapes.add(r1);
        shapes.add(s1); //Square IS A Rectangle IS A Object
        
        double areaAll1 = 0;
        for (int i = 0; i < shapes.size(); i++) {
            
            if(shapes.get(i) instanceof Circle){
                areaAll1 += ((Circle)shapes.get(i)).area();
            }
            else if(shapes.get(i) instanceof Rectangle){
                areaAll1 += ((Rectangle)shapes.get(i)).area();
            }
            System.out.println(areaAll1);
            //areaAll1 = areaAll1 + shapes.get(i).
            
        ArrayList <Shape> shapes1 = new ArrayList();
        shapes1.add(c1);
        shapes1.add(c2);
        shapes1.add(r1);
        shapes1.add(s1);
        
        double areaAll2 = 0;
            for(Shape s: shapes1){
                areaAll2 += s.area();  //polymorfizmus
            }
            System.out.println(areaAll2);
        }
    }
    
    
}
