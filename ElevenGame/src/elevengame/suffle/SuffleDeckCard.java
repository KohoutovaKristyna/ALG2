/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevengame.suffle;

import elevengame.Deck;
import java.util.Collections;
import elevengame.ShuffleInterface;
import java.util.List;

/**
 *
 * @author tynka
 */
public class SuffleDeckCard implements ShuffleInterface {

    @Override
    public void Suffle(ShuffleInterface o) {
        Collections.shuffle((List<?>) o);
    }
    
}
