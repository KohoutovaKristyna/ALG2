/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author kristyna kohoutova
 */
public class IllegalFilenameException extends RuntimeException {
    /**
     * throws the exception with the personalized text message
     * @param messageToUser the text to the user
     */
    public IllegalFilenameException(String messageToUser) {
        super(messageToUser);
    }
    
}
