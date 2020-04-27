/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevengame;

/**
 *
 * @author kristyna kohoutova
 */
public interface BordInterface {

    public String getName();
   
    public boolean isAnotherPlayPossible();

    public int nCards();
     
    public int getDeckSize();
     
    public String getCardDescriptionAt(int index);

    public boolean playAndReplace(String[] selectedCardsPositions);

    public boolean hasWon();

   

    
    
    

}
