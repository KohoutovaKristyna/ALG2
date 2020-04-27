/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevengame;

import java.util.Collections;
import java.util.List;

/**
 * Reprezentuje balicek karet
 * @author kristyna kohoutova
 */
public class Deck {
    List<Card> deckCards;
    
    // methods

    public Deck(String[] symbol, String[] value, int[] points) {
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < value.length; j++) {
                if(value[j]=="A"){
                  deckCards.add(new Card(symbol[i],value[j], points[j]));
                }              
            }
        }
        shuffle();
    }
    
    
    public int nCardsInDeck(){
        return deckCards.size();
    }
    
    public int deal(){
        return deckCards.size()-1;
    }
    public void shuffle(){
        Collections.shuffle(deckCards);
    }
    
    
}
