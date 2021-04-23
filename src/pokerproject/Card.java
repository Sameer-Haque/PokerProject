/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 * Date: 4/22/21
 */
package pokerproject;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 *
 * Date: 4/22/21
 * @author Sameer Haque
 * @author dancye
 * @author Phuong 
 */
public class Card implements Comparable{

    //default modifier for child classes
    public enum SUIT {
        HEARTS, DIAMONDS, SPADES, CLUBS;
    }

    public enum RANK {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
        TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);
        private final int value;
            
        private RANK(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    private final SUIT suit;
    private final RANK rank;

    public Card(RANK rank, SUIT suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a
     * regular playing card etc.
     */
    public SUIT getSuit() {
        return suit;
    }
    
    public RANK getRank() {
        return rank;
    }
    
    @Override
    public String toString() {
        return getRank() + " of " + getSuit();
    }
    
    @Override
    public int compareTo(Object o) {
       Card c = (Card)o;
       return this.rank.value - c.rank.value;
    }

}
