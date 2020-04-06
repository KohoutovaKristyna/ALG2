/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kohoutova_bank;

/**
 *
 * @author kristýna kohoutová
 */
public class Company extends Client {
    private String nameC;

    public Company(String nameC) {
        this.nameC = nameC;
    }
    
    @Override
    public String getName(){
        return "firma " + nameC;
    }
    
   
}
