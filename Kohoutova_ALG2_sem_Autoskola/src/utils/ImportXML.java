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
 *
 * @author kristyna kohoutova
 */
public class ImportXML {

   // public static File dataDirectory = new File(System.getProperty("user.dir") + File.separator + "data");
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
