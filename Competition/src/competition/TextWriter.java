/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author kristyna kohoutova
 */
public class TextWriter extends Writer{

    @Override
    public void save(String resultFilepath, List<Runner> runners) {
        String resultFile;
        try(PrintWriter outResultFile = new PrintWriter(new BufferedWriter(new FileWriter(new File(resultFile),true)))){
            //outResultFile = new PrintWriter(new OutputStreamWriter(<File>, <encoding>, <append>)
            int n = 1;
            for (Runner runner : runners) {
                outResultFile.print(n + ".");
                outResultFile.println(n);
                n++;
            }
        
        }
    }
    
}
