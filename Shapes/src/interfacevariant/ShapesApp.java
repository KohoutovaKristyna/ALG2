/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacevariant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;



/**
 *
 * @author kristyna kohoutova
 */

//pridat case 9, k setrideni

public class ShapesApp implements ShapeInterface, Comparable<ShapesApp>  {
    public static Scanner sc = new Scanner(System.in);
    public static List<ShapeInterface> shapes = new ArrayList<>();
        
    public static void main(String[] args) {
        int choise;
        do{
            displayMenu();
            choise = readChoise();
            switch(choise){
                case 0:
                    break;
                case 1:
                    ClearObjects();
                    break;
                case 2:
                    addSquare();
                    break;
                case 3:
                    addRectangle();
                    break;
                case 4:
                    addCircle();
                    break;
                case 5:
                    printObjects();
                    break;
                case 6:
                    computeArea();
                    break;
                case 7:
                    findWidthMaxArea();
                    break;
                case 8:
                    getObjectInfo();
                    break;
                case 9:
                    sortObjects();
                    break;
                default:
                    System.out.println("Chybna volba");

            }
        }while(choise !=0);

    }

    private static void displayMenu(){
        System.out.println("");
        System.out.println("1. Nova sada");
        System.out.println("2. Pridej ctverec");
        System.out.println("3. Pridej obdelnik");
        System.out.println("4. Pridej kruh");
        System.out.println("5. Vypis geometricke objekty");
        System.out.println("6. Vypocti celkovou plochu");
        System.out.println("7. Vypis objekt s nejvetsi plochou");
        System.out.println("8. Vypis plochu objektu");
        System.out.println("9. Srovnani objektu");
        System.out.println("0. Konec programu");
    }

    private static int readChoise() {
        return sc.nextInt();
    }

    private static void ClearObjects() {
        shapes.clear();
    }

    private static void addSquare() {
        System.out.println("Zadejte delku strany");
        double strana = sc.nextDouble();
        Square s = new Square(strana);
        shapes.add(s);
    }

    private static void addRectangle() {
        System.out.println("Zadejte delku strany");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        Rectangle r = new Rectangle(a,b);
        shapes.add(r);
    }

    private static void addCircle() {
        // jeste vyresit zadavani s prumerem
        System.out.println("Vyberte zda chcete prumer nebo polomer 1 / 2");
        int choice = sc.nextInt();
        double input;
        if (choice == 1) {
            System.out.println("Zadej prumer");
            input = sc.nextDouble();
            Circle c = Circle.getInstance(input);
            shapes.add(c);
        } else {
            System.out.println("Zadejte polomer");
            input = sc.nextDouble();
            Circle c = Circle.getInstanceR(input);
            shapes.add(c);
        }
    }

    private static void computeArea() {
        double areaAll = 0;
            for(ShapeInterface s: shapes){
                areaAll += s.area();
            }
            System.out.println(areaAll);
    }

    private static void findWidthMaxArea() {
        double max = Double.MIN_VALUE;
        for(ShapeInterface s : shapes){
            if(s.area()>max){
                max = s.area();
            }
        }
        System.out.println("Obsah nejvetsiho objektu je: "+max);
    }

    private static void printObjects() {
        for (int i = 0; i < shapes.size(); i++) {
           System.out.println("Typ: "+ shapes.toString().getClass().getSimpleName()+", obsah: "+shapes.get(i).area()); 
        }
    }


    private static void getObjectInfo() {
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println(i+". "+shapes.get(i).toString());
        }
        System.out.println("Zadej cislo objektu");
        int input = sc.nextInt();
        System.out.println( "Typ: " +shapes.getClass().getSimpleName()+", obsah: "+shapes.get(input).area());
    }
    //TODO
    //setridi objekty podle plochy, pouzit Collections.sort

    static final Comparator<ShapeInterface> myComparator = new Comparator<ShapeInterface>() {

        @Override
        public int compare(ShapeInterface o1, ShapeInterface o2) {
            if (o1.area() < o2.area()) {
                return -1;
            } else if (o1.area() > o2.area()) {
                return 1;
            } else {
                return 0;
            }
        }
    };

    private static void sortObjects() {

        List<ShapeInterface> list = new ArrayList<>();
        for (ShapeInterface s: shapes) {
            list.add(s);
        }
        //Comparator c = this.computeArea();
        //list.sort(c);
        //Collections.sort(list);
        Collections.sort(shapes, myComparator);

    }

    //@Override
    @Override
    public int compareTo(ShapesApp o) {
        double EPS = 0.0001;
        double diff = area() - o.area();
        
        if(Math.abs(diff)<EPS){
            return 0;
        }
        else if(diff > 0){
            return 1;
        }
        else{
            return -1;
        }
//        if((this.area() - o.area())>EPS){
//            return 1;
//        }
//        else if((this.area() - o.area())<0){
//            return -1;
//        }
//        else{
//            return 0;
//        }
    }

    @Override
    public double area() {
        return this.area();
    }


}
