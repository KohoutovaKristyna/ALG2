/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * The class answer enables to create object type Answer
 * @author tynka
 */
@XmlAccessorType(XmlAccessType.FIELD)

/**
 *  This class enables to create the Answer object type 
 * @author kristyna kohoutova
 */

public class Answer {
    @XmlAttribute(name = "YourAnswer", required = false)
    private boolean yourAnswer = false;
    @XmlAttribute(name = "Id", required = true)
    private String anwerID;
    @XmlAttribute(name = "IsCorrect", required = true)
    private boolean isCorrect;
    @XmlValue()
    private String text;
    
    /**
     * Method returns if it is the answer from user
     * @return if it is the answer from user
     */
    public boolean isYourAnswer() {
        return yourAnswer;
    }

    /**
     * Method sets the answer from the user
     * @param yourAnswer is the answer from user
     */
    public void setYourAnswer(boolean yourAnswer) {
        this.yourAnswer = yourAnswer;
    }
    /**
     * Enables to get the answer id
     * @return the id of the answer
     */
    public String getAnwerID() {
        return anwerID;
    }
    /**
     * Returs the correctnes of the answer
     * @return if the answer is correct
     */
    public boolean isIsCorrect() {
        return isCorrect;
    }
    /**
     * Enables to get the text of the answer
     * @return the answer text
     */
    public String getText() {
        return text;
    }
    /**
     * Enables to set the answer id
     * @param anwerID is the id of the answer
     */
    public void setAnwerID(String anwerID) {
        this.anwerID = anwerID;
    }
    /**
     * Enables to set if the answer is correct
     * @param isCorrect sets true if the answer is correct otherwise false
     */
    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
    /**
     * Enables to set the answer text
     * @param text is the answer text
     */
    public void setText(String text) {
        this.text = text;
    }
    
}
