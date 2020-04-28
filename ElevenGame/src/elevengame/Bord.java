/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevengame;

import java.util.List;

/**
 *
 * @author kristyna kohoutova
 */
public class Bord implements BordInterface{
    Card[] cards;
    Deck deck;
    private List<Card> bordCards;
    private int size;
    
    //methods

    @Override
    public String getName() {
        return "Hra jedenactka";
    }

    @Override
    public int nCards() {
        return cards.length;
    }

    @Override
    public int getDeckSize() {
        return 43;
    }
    
    @Override
    public String getCardDescriptionAt(int index){
        return cards[index].getSymbol()+cards[index].getValue();
    }

    @Override
    public boolean hasWon() {
        if(deck.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public boolean playAndReplace(String[] selectedCardsPositions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAnotherPlayPossible() {
        int cQ=0,cK=0,cJ=0;
        for (int i = 0; i < cards.length; i++) {
            for (int j = 1; j < cards.length-i; j++) {
                if(cards[i].getnPoints()+cards[j].getnPoints()==11){
                return true;
                }
            }
            if(cards[i].getValue()=="J" ){
                 cJ++;   
            }
            if (cards[i].getValue()=="Q") {
               cQ++; 
            }
            if (cards[i].getValue()=="K") {
                cK++;
            }
        }
        if(cJ < 0 && cQ <0 && cK<0){
            return true;
        }
        return false;
    }

    public Bord(String[] symbol, String[] value, int[] points,int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            bordCards.add(deck.getDeckCard(i));
        }
        
        
    }
    
    
}
