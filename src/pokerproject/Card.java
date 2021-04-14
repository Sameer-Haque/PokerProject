/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package pokerproject;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @author Phuong 
 */
public class Card {
    //default modifier for child classes
    public enum SUIT {
        HEARTS("Heart"), DIAMONDS("Diamons"), SPADES("Spades"), CLUBS("Clubs");

        private final String suitText;

        private SUIT(String suitText) {
            this.suitText = suitText;
        }

        public String getSuit() {
            return suitText;
        }
    }

    public enum RANK {
        TWO("Two"), THREE("Three"), FOUR("Four"), FIVE("Five"), SIX("Six"), SEVEN("Seven"), EIGHT("Eight"), NINE("Nine"), TEN("Ten"),
        JACK("Jack"), QUEEN("Queen"), KING("King"), ACE("Ace");

        private final String rankValue;

        private RANK(String rankValue) {
            this.rankValue = rankValue;
        }

        public String getRank() {
            return rankValue;
        }
    }

    private SUIT suit;
    private RANK rank;

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
    public String getSuit() {
        return suit.getSuit();
    }
    
    public String getRank() {
        return rank.getRank();
    }
    
    @Override
    public String toString() {
        return rank.getRank() + "of" + suit.getSuit();
    }

}
