/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package pokerproject;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public class Card {
    //default modifier for child classes
    public enum SUIT {
        HEARTS, DIAMONDS, SPADES, CLUBS
    }
    
    public enum RANK {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, 
        JACK, QUEEN, KING, ACE
    }

    public Card(RANK rank, SUIT suit) {
        
    }
    
    
    /**
	 * Students should implement this method for their specific children classes
	 * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
	 */
   
    
    @Override
	public String toString(){
        
        return null;
    }

}
