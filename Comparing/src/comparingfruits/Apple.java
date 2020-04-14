/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparingfruits;

/**
 *
 * @author tynka
 */
import comparing.CompareInterface;
public class Apple implements CompareInterface 
{
    private String name;
    private int sweetness;
    
    public Apple(String name, int sweetness){
        this.name = name;
        this.sweetness = sweetness;
    }
    @Override
    public String toString(){
        return "Apple{"+ " name= "+ name+ ", sweetness ="+ sweetness +'}';
    }
    @Override
    public boolean isSmaller(CompareInterface o){
        return this.sweetness > ((Apple)o).sweetness;
    }
}
