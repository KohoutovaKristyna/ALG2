/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 * This class enables to create the TestPerson object type 
 * @author kristyna kohoutova
 */
public class TestPerson {
    private String jmeno;
    private String prijmeni;
    /**
     * Method creates the object with the name and the surname
     * @param jmeno takes the name of the tested person
     * @param prijmeni takes the surname of the tested person
     */
    public TestPerson(String jmeno, String prijmeni) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
    }
    /**
     * Method enables to get the name of the person
     * @return the name of the person (firstname)
     */
    public String getJmeno() {
        return jmeno;
    }
    /**
     * Method enables to get the surname of the person
     * @return the surname of the person
     */
    public String getPrijmeni() {
        return prijmeni;
    }
    
}
