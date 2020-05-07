/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author kristyna kohoutova
 */
public class Competition {
    private ArrayList<Runner> runners = new ArrayList<>();
    public void load(String startFile, String finishFile) throws FileNotFoundException, IOException {
        //nacitani pomoci Scanneru
        File startFileF = new File(startFile);
        Scanner inStart = new Scanner(startFileF);
        while(inStart.hasNext()){
            int number = inStart.nextInt();
            String firstname = inStart.next();
            String lastname = inStart.next();
            String startTime = inStart.next();
            Runner r = new Runner(firstname, lastname, number);
            r.setStartTime(startTime);
            runners.add(r);
        }
        
        //nacitani BufferedReader
        File finishFileF = new File(finishFile);
        BufferedReader inFinish = null;
        try {
            inFinish = new BufferedReader(new FileReader(finishFileF));
            String line;
            while ((line = inFinish.readLine()) != null) { //101 10:02:00:000
                String[] parts = line.split("[ ]+");
                Runner r = findRunner(Integer.parseInt(parts[0]));
                r.setFinishTime(parts[1]);
            }
        } finally {
            if (inFinish != null) {
                inFinish.close();
            }
        }
    }

    public String getResults() {
        Collections.sort(runners);
        Iterator<Runner>iterator = runners.iterator();
        StringBuilder sb = new StringBuilder("");
        int n = 1;
        while(iterator.hasNext()){
            Runner r = iterator.next();
            sb.append(String.format("%-4d. %s",n,r));
            n++;
        }
        return sb.toString();
    }
    
    public String toString(){
        return runners.toString();
    }
    
    public void saveResults(String resultFile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        Competition c = new Competition();
        try{
        c.load("start.txt", "finish.txt");
        System.out.println(c);
        }catch(FileNotFoundException e){
            System.out.println("Nenalezen soubor");
        }
    }

    private Runner findRunner(int parseInt) {
        
    }
    
}
