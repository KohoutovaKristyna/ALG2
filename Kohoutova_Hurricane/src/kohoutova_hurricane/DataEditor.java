/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kohoutova_hurricane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kristyna kohoutova
 */

public class DataEditor  implements HurricaneInterface{

    
    
    ArrayList<Hurricane> hurricane = new ArrayList<>();
    @Override
    public void load()throws FileNotFoundException, IOException{
        File hData = new File("hurricanedata.txt");
        Scanner load = new Scanner(hData);
        while(load.hasNext()){
            int year = load.nextInt();
            String month = load.next();
            int pressure = load.nextInt();
            int speed = load.nextInt();
            String name = load.next();
            Hurricane h = new Hurricane(year, month, pressure, speed, name); 
            hurricane.add(h);
        }   
    } 
    
    @Override
    public String hurricanesInYears(int y1, int y2){
        StringBuilder sb = new StringBuilder("");
        for (Hurricane h: hurricane) {
            if(h.getYear() >= y1 && h.getYear() <= y2){
                sb.append(h);
                sb.append("\n");
            }
        }
        return sb.toString();
        
    }
    
    @Override
    public String hurricaneByName(String name){
       for (Hurricane h: hurricane) {
           if(h.getName().equals(name)){
               return "category: "+h.getHurricaneCategory() + " speed: " + h.getSpeedInKmH() + "km/h";
           }
       }
       return "Hurricane does not found";
    }
    
    @Override
    public String hurricaneInfoBySpeed(){      
        Collections.sort(hurricane, Comparator.comparing(Hurricane::getSpeedInKmH));
        StringBuilder sb = new StringBuilder();
        for (Hurricane h: hurricane) {
            sb.append(h.toString());
            sb.append("\n");
        }
        return sb.toString();       
    }
   
//
//    @Override
//    public int compareTo(Hurricane o) {
//        if (getSpeed() - o.getSpeed() < 0){
//            return 1;
//        }
//        else if (getSpeed() - o.getSpeed() > 0){
//            return -1;
//        }
//        else{
//            return 0;
//        }
//
//    }
     
    

    
    
}
