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
public class Exit extends Command{

    @Override
    public String execute(File actualDir) {
//        setIsRunnig(false);
        System.exit(0);
        
        return "Ukoncuji program";
        
        
    }
    
}
