/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparing;

import comparing.mycomparing.ComparatorInterface;
import comparing.mycomparing.ComparatorStudentByFirstname;
import comparing.mycomparing.ComparatorStudentByNum;

/**
 *
 * @author kristyna kohoutova
 */
public class MyComparing {
    public static void main(String[] args) {
        Student[] students = Datasource.loadDataAsArray();
        System.out.println(students[0].equals(students[1]));
        print(students);
        System.out.println("Sort by number");
        sortByNumber(students);
        print(students);
        System.out.println("Sort by age");
        sortByAge(students);
        print(students);
        System.out.println("Sort by number");
        sort(students);
        print(students);
        sort(students, new ComparatorStudentByNum());
        print(students);
        sort(students, new ComparatorStudentByFirstname());
        print(students);
    }
    
    public static void sort(CompareInterface[] array){
         for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length-i; j++) {
                if (array[j-1].isSmaller(array[j])) {
                    CompareInterface temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
   
            }
        }
    }
    
    public static void sort(Object [] array, ComparatorInterface o){
          for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length-i; j++) {
                if (o.bigger(array[j-1], array[j])) {
                    Object temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
   
            }
        }
    }
    
    Student[] students = Datasource.loadDataAsArray();
    
    private static void sortByNumber(Student[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length-i; j++) {
                if (array[j-1].startLater(array[j])) {
                    Student temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
   
            }
        }
    
    } 

       private static void sortByAge(Student[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length-i; j++) {
                if (array[j-1].isOlder(array[j])) {
                    Student temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
   
            }
        }
    
    } 
    
    public static void print(Student[] array){
        for (Object student: array) {
            System.out.println(student);
        }
    }
    
}
