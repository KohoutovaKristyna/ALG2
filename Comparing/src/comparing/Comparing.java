/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparing;

import comparing.mycomparing.ComparatorStudentByNum;
import comparing.mycomparing.ComparatorStudentByFirstname;
import static comparing.MyComparing.sort;
import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

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
        
        
        System.out.println("Sort by number");
        Collections.sort(students1);
        print(students1);
        System.out.println("Sort by name");
         sort(students, new ComparatorStudentByFirstname());
        print(students);
         sort(students, new ComparatorStudentByNum());
        print(students);
        
        //anonymni trida
        System.out.println("Sort by lastname");
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                Collator col = Collator.getInstance(new Locale("cs","CZ"));
                return col.compare(o1.getLastName(), o2.getLastName());
                //return o1.getLastName().compareTo(o2.getLastName());
            }
        });
       // Arrays.sort(students, (Student o1, Student o2) -> o1.getLastName().compareTo(o2.getLastName()));  //lambda vyraz   - dalsi moznost
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
