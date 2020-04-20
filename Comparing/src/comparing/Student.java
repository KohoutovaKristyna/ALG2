/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparing;

/**
 *
 * @author kristyna kohoutova
 */
public class Student implements CompareInterface, Comparable<Student>{
  private String firstName;
  private String lastName;
  private int age;
  private int number;
  private int [] grades;  //max 10
  final private int numberOfGrades = 10;
  private double average;

    public Student(String firstName, String latsName, int number, int age) {
        this.firstName = firstName;
        this.lastName = latsName;
        this.age = age;
        this.number = number;
        grades = new int[numberOfGrades];
        for (int i = 0; i < numberOfGrades; i++) {
            grades[i] = -1;
        }
    }

//    @Override
//    public String toString() {
//        return "Student{" + "firstName=" + firstName + ", latsName=" + latsName + ", age=" + age + ", number=" + number + '}';

    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", number=" + number + ", grades=" + getGrades() + ", average=" + String.valueOf(getAverage()) + '}';
    }

    
    private String getGrades() {
        String returnValue = "";
        for (int i = 0; i < numberOfGrades; i++) {
            if (i == 0) {
                if (this.grades[i] != -1) {
                    returnValue += this.grades[i];
                }
            } else {
                if (this.grades[i] != -1) {
                    returnValue += "," + this.grades[i];
                }
            }
        }
        return returnValue;
    }
    
    private double getAverage() {
        double returnValue = 0;
        int counter = 0;
        for (int i = 0; i < numberOfGrades; i++) {
            if (this.grades[i] != -1) {
                returnValue += this.grades[i];
                counter++;
            }
        }
        return this.average = returnValue / counter;
         
    }
        
    
//    }
    boolean startLater(Student student) {
        return this.number > student.number;
    }
    boolean isOlder(Student student){
        return this.age > student.age;
    }

    @Override
    public boolean isSmaller(CompareInterface o) {
        return this.number > ((Student)o).number;
    }

//    @Override
//    public int compareTo(Object o) {  //zaporne, 0, kladne int
//        return this.number - ((Student)o).number;
//    }

//    @Override
//    public int compareTo(Student o) { //genericita, umoznuje doplnit typy objektu, ktere se porovnavaji
//        return this.number - o.number;
//    }
    
     @Override
    public int compareTo(Student o) { //genericita, umoznuje doplnit typy objektu, ktere se porovnavaji
        double EPS = 0.0001;
        double diff = getAverage() - o.getAverage();
        
        if(Math.abs(diff) < EPS){
            return 0;
        }
        else if(diff > 0){
            return 1;
        }
        else{
            return -1;
        }
        
        
//        if((this.average - o.average)>0){
//            return 1;
//        }
//        else if((this.average - o.average)<0){
//            return -1;
//        }
//        else{
//            return 0;
//        }
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getNumber() {
        return number;
    }

    public String getLastName() {
        return lastName;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.number;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.number != other.number) {
            return false;
        }
        return true;
    }

 


    
    
    public void addGrades(int[] grades){
        for (int i = 0; i < grades.length; i++) {
            if (i < numberOfGrades) {
                this.grades[i] = grades[i];
            }
        }
    }
    
    public void addGrade(int grade){
        for (int i = 0; i < numberOfGrades; i++) {
           if (grades[i] == -1) {
               grades[i] = grade;
           }
        }
    }

    
    
    
    
    //TODO
    //doprogramovat promennu, kde budeme davat pole znamek, aby se mu mohly pridavat znamky
    //vypocitat prumer
    //zmenit metodu compareTo, aby se tridilo podle prumeru (pouzit porovnani realnych cisel) -1 0 1, vyzkouset, jestli to v comparing bude tridit podle prumeru
  
}
