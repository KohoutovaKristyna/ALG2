/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalendar;

import java.util.Scanner;
import java.lang.StringBuffer;
/**
 *
 * @author tynka
 */
public class Kalendar {

 private int day;
    private int month; 
    private int year;
    private int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
    static Scanner sc = new Scanner(System.in);   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //inicializace

        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();
        int weekDay = 0;
        Kalendar kl = new Kalendar(day, month, year);
        //System.out.println(isLeapYear(year));
        System.out.println(kl.getCalendar());
        int vysledek = kl.getMenu();
        if(vysledek == 1){
            kl.nextMonth();
        }
        else if(vysledek == -1){
            kl.previousMonth();
        }
        else{
            System.out.println("Spatna volba, zkuste to znovu");
            kl.getMenu();
        }
        System.out.println(kl.getCalendar());
        
    }
 
    public int getMenu(){
        int choise;
        System.out.println("Pro posouvani mezi mesici je potrebne vybrat volbu:");
        System.out.println("Pro posun dopredu 1, pro posun o mesic zpet -1");
        choise = sc.nextInt();
        if(choise == 1){
            return 1;
        }
        else if(choise == -1){
            return -1;
        }
        else{return 0;}
    }
  
    public String getCalendar() {
        int daysmonth = daysInMonth[(this.month)-1];
        //System.out.println((this.month)-1);
        StringBuilder sb = new StringBuilder();
        sb.append("po ");
        sb.append("ut ");
        sb.append("st ");
        sb.append("ct ");
        sb.append("pa ");
        sb.append("so ");
        sb.append("ne");

        sb.append("\n");

        if (isLeapYear(year) == true && month == 2) {
            daysmonth += 1;
        }
        for (int i = 1; i < getZeller(1, month, year); i++) {
            sb.append("   ");

        }
        //System.out.println(getZeller(1, month, year));

        for (int i = 1; i <= daysmonth; i++) {
            if (i < 10) {
                sb.append(i + "  ");
            } else {
                sb.append(i + " ");
            }

            if (getZeller(i, month, year) == 7) {
                sb.append("\n");
            }

        }
        String st = sb.toString();
        return st;
    }
    
    public void nextMonth(){
        this.day = 1;
        if(this.month == 12){
            this.month = 1;
        }
        else{
           this.month += 1; 
        }
        
    }
    
    public void previousMonth(){
        this.day = 1;
        if(this.month == 1){
            this.month = 12;
        }
        else{
          this.month -= 1;  
        }
        
    }
    public Kalendar(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }


    public int getZeller(int day, int month, int year){
        int dayOfWeek;
        int h;
        int q = day;
        int m = month;
        if(m == 1){
            m = 13;
        }
        else if(m == 2){
            m = 14;
        }
        int K = year%100;
        
        int J = year/100;
        
         h = (q + ((13 * (m + 1)) / 5) + K + (K / 4) + (J / 4) + 5 * J) % 7;
         
        dayOfWeek = ((h+5) % 7)+1;
        return dayOfWeek;
    }
    public static boolean isLeapYear(int year){
        if((year%4 == 0 && year%100 !=0 )|| year %400==0){
            return true;
        }
        return false;
    }
    public static int getDaysOfYear(int year){
        if(isLeapYear(year)){
            return 366;
        }
        return 365;
    }
    
}
