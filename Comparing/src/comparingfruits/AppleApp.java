/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparingfruits;
import comparing.MyComparing;
/**
 *
 * @author tynka
 */
public class AppleApp {
    public static void main(String[] args) {
        Apple[] apples = {new Apple("Gala",4), new Apple("Jonatan",2), new Apple("Idared",3)};
        
        //MyComparing.print(apples);
        System.out.println("Sorting by sweetness");
        MyComparing.sort(apples);
        //MyComparing.print(apples);
    }
}
