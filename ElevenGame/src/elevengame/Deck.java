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
public class Deck{
    private List<Card> deckCards;
    private int deckCardsSize = deckCards.size();
    private String[] symbol;
    private String[] value;
    private int[] nPoints;
    
    // methods

    public Deck(String[] symbol, String[] value, int[] points) {
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < value.length; j++) {
                deckCards.add(new Card(symbol[i],value[j], points[j]));          
            }
        }
        shuffle();
    }
    
    
    public int nCardsInDeck(){
        return deckCardsSize;
    }
    
    public Card deal(){
       deckCardsSize--;
       //return deckCards[deckCardsSize];
        
        
    }
    public void shuffle(){
        Collections.shuffle(deckCards);
    }

    @Override
    public String toString() {
        return "Deck{" + "deckCards=" + deckCards + ", deckCardsSize=" + deckCardsSize + '}';
    }
    public boolean isEmpty(){
        if(deckCards.size() == 0){
            return true;
        }
        return false;
    }

    public List<Card> getDeckCards() {
        return deckCards;
    }
    public Card getDeckCard(int index){
        return deckCards.get(index);
    }

 


    
    
    
    
}
