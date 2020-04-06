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
public class Person extends Client {
    private String nameP;

    public Person(String nameP) {
        this.nameP = nameP;
    }

    @Override
    public String getName(){
        if(nameP.contains("ova")){
            return "pani " + nameP;
        }
        return "pan " + nameP;
    }
    
}
