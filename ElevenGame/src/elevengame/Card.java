package elevengame;

/**
 *
 * @author kristyna kohoutova
 */
public class Card {
    private String symbol;  //suit
    private String value;  //rank
    private int nPoints;  //A-J, J,Q,K -0
    
    //methods

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    public int getnPoints() {
        return nPoints;
    }
    
}
