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
 * @author kristyna kohoutova
 */
public class Kalendar {

    private int day;
    private int month;
    private int year;
    private int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //inicializace
        System.out.println("Zadejte den, mesic a rok");
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        Kalendar kl = new Kalendar(day, month, year);
        System.out.println(kl.getCalendar());
        callMenu(kl);

    }

    public static void callMenu(Kalendar k) {
        int vysledek = k.getMenu();
        while (vysledek != 0) {
            if (vysledek == 1) {
                k.nextMonth();
            } else if (vysledek == -1) {
                k.previousMonth();
            }
            System.out.println(k.getCalendar());
            vysledek = k.getMenu();
        }
    }

    public int getMenu() {
        int choise;
        System.out.println("Pro posouvani mezi mesici je potreba vybrat volbu:");
        System.out.println("Pro posun na dalsi mesic 1, pro posun o mesic zpet -1, pro ukonceni programu 0");
        choise = sc.nextInt();
        if (choise == 1) {
            return 1;
        } else if (choise == -1) {
            return -1;
        } else {
            return 0;
        }
    }

    public String getCalendar() {
        int daysmonth = daysInMonth[(this.month) - 1];
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

        for (int i = 1; i <= daysmonth; i++) {
            if (i < 10) {
                sb.append(i).append("  ");
            } else {
                sb.append(i).append(" ");
            }

            if (getZeller(i, month, year) == 7) {
                sb.append("\n");
            }

        }
        String st = sb.toString();
        return st;
    }

    public void nextMonth() {
        this.day = 1;
        if (this.month == 12) {
            this.month = 1;
        } else {
            this.month += 1;
        }

    }

    public void previousMonth() {
        this.day = 1;
        if (this.month == 1) {
            this.month = 12;
        } else {
            this.month -= 1;
        }

    }

    public Kalendar(int day, int month, int year) {

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Takovy mesic neexistuje");
        } else {
            this.month = month;
        }
        if (day < 1 || day > daysInMonth[month - 1]) {
            if (isLeapYear(year) == false) {
                throw new IllegalArgumentException("Takovy den neexistuje");
            }
//            if (isLeapYear(year)) {
//                if (month != 2) {
//                    throw new IllegalArgumentException("Takovy den neexistuje");          //tato cast zpusobovala chyby, nevim, proc
//                } else if (day > 29) {
//                    throw new IllegalArgumentException("Takovy den neexistuje");
//                } 
//            }
            else {
                this.day = day;
            }

            this.year = year;

        }
    }

    public int getZeller(int day, int month, int year) {
        int dayOfWeek;
        int h;
        int q = day;
        int m;
        int K = year % 100;
        int J = year / 100;

        switch (month) {
            case 1:
                m = 13;
                K -= 1;
                break;
            case 2:
                m = 14;
                K -= 1;
                break;
            default:
                m = month;
                break;
        }

        h = (q + ((13 * (m + 1)) / 5) + K + (K / 4) + (J / 4) + 5 * J) % 7;

        dayOfWeek = ((h + 5) % 7) + 1;
        return dayOfWeek;
    }

    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }

    public static int getDaysOfYear(int year) {
        if (isLeapYear(year)) {
            return 366;
        }
        return 365;
    }

}
