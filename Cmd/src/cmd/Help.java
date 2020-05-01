/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.io.File;

/**
 *
 * @author kristyna kohoutova
 */
public class Help extends Command{

    @Override
    public String execute(File actualDir) {
        
        String help = "HELP\n" 
                + String.format("%-7s %s\n", "help", "Display help")
                + String.format("%-7s %s\n", "dir", "Display list of files and folders");
        return help;
    }
    
}
