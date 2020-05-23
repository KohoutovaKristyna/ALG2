/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import app.QuestionList;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * This class enables to work with the data in the XML files
 * @author kristyna kohoutova
 */
public class ImportXML {

   /**
    * Method enables the program to get the questions 
    * @param fileName is the name of the file from which we need the data to the program
    * @return list of questions
    */
    public static QuestionList readFromXML(String fileName) {
        
        app.QuestionList questions = null;
        
        File xmlFile = new File(fileName);
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(app.QuestionList.class);
            Unmarshaller uumarshaller = jaxbContext.createUnmarshaller();
            questions = (app.QuestionList) uumarshaller.unmarshal(xmlFile);
        }catch(JAXBException e){
            e.printStackTrace();
        }
        return questions;
    }
    
}
