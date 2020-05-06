/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author kristyna kohoutova
 */
public class Dir extends Command{

    @Override
    public String execute(File actualDir) {
        File[] files;
        if(params.length == 1){
            files = actualDir.listFiles();
            return dirToString(files);
        }
        else if (params.length == 2  &&  params[1].equals("-o")) {
            System.out.println("podminka");
            files = actualDir.listFiles();
            Arrays.sort(files,Comparator.comparingLong(File::lastModified));
            
//            (files).toString();
           return dirToString(files);
        }
        return null;
    }

    private String dirToString(File[] files) {
        StringBuilder sb = new StringBuilder("");
        for (File file : files) {
            if(file.isDirectory()){
                sb.append(String.format("%s%n",file.getName()));
            }else{
                sb.append(String.format("%-20s%6d", file.getName(), file.length())); 
                sb.append(new Date(file.lastModified())).append("\n");
            }
            
        }
        String st = sb.toString();
        return st;
    }
    
}
