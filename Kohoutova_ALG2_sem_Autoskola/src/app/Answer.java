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

@XmlAccessorType(XmlAccessType.FIELD)

/**
 *
 * @author kristyna kohoutova
 */

public class Answer {
    @XmlAttribute(name = "Id", required = true)
    private String anwerID;
    @XmlAttribute(name = "IsCorrect", required = true)
    private boolean isCorrect;
    @XmlValue()
    private String text;

    public String getAnwerID() {
        return anwerID;
    }

    public boolean isIsCorrect() {
        return isCorrect;
    }

    public String getText() {
        return text;
    }

    public void setAnwerID(String anwerID) {
        this.anwerID = anwerID;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
}
