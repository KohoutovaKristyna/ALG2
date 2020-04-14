/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author kristyna kohoutova
 */
public class Comparing{
    public static void main(String[] args) {
        Student[] students = Datasource.loadDataAsArray();
               
        int[] array0 = {1,2,1,1,1,1,1,1};
        int[] array1 = {2,2,1,3,1,1,2,3};
        int[] array2 = {1,2,1,3,1,1,2,1};
        students[0].addGrades(array0);
        students[1].addGrades(array1);
        students[2].addGrades(array2);
        print(students);
        System.out.println("Sort by number");
        
        Arrays.sort(students);  //Student musi byt typovo kompatibilny s Comparable<Student>
        print(students);
       
        List<Student> students1 = Datasource.loadDataAsList();
        print(students1);
        
        
//        for (int i = 0; i < array.length; i++) {
//            students[1].addGrade(array[i]); 
//        }
        
        
        
        System.out.println("Sort by number");
        Collections.sort(students1);
        print(students1);
        
    }
     public static void print(Student[] array){
        for (Object o: array) {
            System.out.println(o);
        }
    }
     public static void print(List array){
      for (Object o: array) {
            System.out.println(o);
        }
     }
}
