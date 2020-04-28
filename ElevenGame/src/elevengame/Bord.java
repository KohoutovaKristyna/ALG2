/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevengame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kristyna kohoutova
 */
public class Bord implements BordInterface{
//    Card[] cards;
    Deck deck;
    private List<Card> bordCards = new ArrayList();
    private int size;
    
    //methods

    @Override
    public String getName() {
        return "Hra jedenactka";
    }

    @Override
    public int nCards() {
        return bordCards.size();
    }

    @Override
    public int getDeckSize() {
        return deck.nCardsInDeck();
    }
    
    @Override
    public String getCardDescriptionAt(int index){
        return bordCards.get(index).getSymbol()+bordCards.get(index).getValue();
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
        int cQ=0,cK=0,cJ=0;
        boolean goOn = false;
        if(selectedCardsPositions.length == 2){
            if(bordCards.get(Integer.parseInt(selectedCardsPositions[0])-1).getnPoints()
                    +bordCards.get(Integer.parseInt(selectedCardsPositions[1])-1).getnPoints()==11){
                goOn = true;
            }
        
        }
        else if(selectedCardsPositions.length == 3){
            for (int i = 0; i < 3; i++) {
              if(bordCards.get(Integer.parseInt(selectedCardsPositions[i])-1).getValue()=="J"){
                  cJ++;
              } 
              if(bordCards.get(Integer.parseInt(selectedCardsPositions[i])-1).getValue()=="Q"){
                  cQ++;
              }
              if(bordCards.get(Integer.parseInt(selectedCardsPositions[i])-1).getValue()=="K"){
                  cK++;
              }
            }
            if(cJ == 1 && cQ == 1 && cK == 1){
                goOn = true;
            }            
        }
        if(goOn = true){
            for (int i = 0; i < selectedCardsPositions.length; i++) {
                bordCards.remove(Integer.parseInt(selectedCardsPositions[i])-1);
            }
            for (int i = 0; i < selectedCardsPositions.length; i++) {
                bordCards.add(deck.getDeckCard(i));
                deck.deal();
            }
        }
       return goOn; 
    }

    @Override
    public boolean isAnotherPlayPossible() {
        int cQ=0,cK=0,cJ=0;
        for (int i = 0; i < bordCards.size(); i++) {
            for (int j = 1; j < bordCards.size()-i; j++) {              
                if(bordCards.get(i).getnPoints()+bordCards.get(j).getnPoints()== 11){
                return true;
                }
            }
            if(bordCards.get(i).getValue()=="J" ){
                 cJ++;   
            }
            if (bordCards.get(i).getValue()=="Q") {
               cQ++; 
            }
            if (bordCards.get(i).getValue()=="K") {
                cK++;
            }
        }
        if(cJ > 0 && cQ >0 && cK >0){
            return true;
        }
        return false;
    }

    public Bord(String[] symbol, String[] value, int[] points, int size) {
         deck = new Deck(symbol, value, points);
        
        this.size = size;
        for (int i = 0; i < size; i++) {
            bordCards.add(deck.getDeckCard(i+1));
        }
        
        
    }
    
    
}
