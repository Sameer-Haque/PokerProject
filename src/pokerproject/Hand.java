package pokerproject;

/**
 * Hand
 * @author Sameer
 * Date: 4/22/21
 * makes a hand class that has a value
 */

import java.util.ArrayList;
import java.util.Collections;
import static pokerproject.Hand.HAND_VALUE.*;

public class Hand {

    private HAND_VALUE value;

    public enum HAND_VALUE {
        
        HIGH(1), ONE_PAIR(2), TWO_PAIR(3), THREE_OF_KIND(4), STRAIGHT(5),
        FLUSH(6),FULL_HOUSE(7), FOUR_OF_KIND(8), STRAIGHT_FLUSH(9), ROYAL_FLUSH(10);
        private int compareNum;
        
        private HAND_VALUE(int compareNum) {
            this.compareNum = compareNum;
        }
        public int getCompareNum() {
            return compareNum;
        }
    }

    ArrayList<Card> Cards = new ArrayList<Card>();

    public Hand(ArrayList<Card> cards) {
        this.value = null;
        this.Cards = cards;
    }

    public Hand(ArrayList<Card> cards, HAND_VALUE value) {
        this.value = value;
        this.Cards = cards;
    }

    public void setValue(HAND_VALUE value) {
        this.value = value;
    }

    public HAND_VALUE getValue() {
        return value;
    }

    public ArrayList<Card> getCards() {
        return Cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.Cards = cards;
    }
    
    
    public HAND_VALUE findBestHandValue() {

        if (isRoyalFlush()) {
            return ROYAL_FLUSH;
        } else if (isStraightFlush()) {
            return STRAIGHT_FLUSH;
        } else if (isFourOfKind()) {
            return FOUR_OF_KIND;
        } else if (isFullHouse()) {
            return FULL_HOUSE;
        } else if (isFlush()) {
            return FLUSH;
        } else if (isStraight()) {
            return STRAIGHT;
        } else if (isThreeOfKind()) {
            return THREE_OF_KIND;
        } else if (isTwoPair()) {
            return TWO_PAIR;
        } else if (isOnePair()) {
            return TWO_PAIR;
        } else {
            return HIGH;
        }
    }

    protected boolean isOnePair() {
        ArrayList<Card> cards = getCards();
        Collections.sort(cards);

        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getRank() == cards.get(i + 1).getRank()) {
                return true;
            }
        }
        return false;
    }

    private boolean isThreeOfKind() {
        ArrayList<Card> cards = getCards();
        Collections.sort(cards);

        try {
            for (int i = 0; i < cards.size(); i++) {
                if (cards.get(i).getRank() == cards.get(i + 1).getRank()
                        && cards.get(i + 2).getRank() == cards.get(i).getRank()) {
                    return true;
                }
            }
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
        return false;
    }

    private boolean isFourOfKind() {
        ArrayList<Card> cards = getCards();
        Collections.sort(cards);
        try {
            for (int i = 0; i < cards.size() - 1; i++) {
                if (cards.get(i).getRank() == cards.get(i + 1).getRank()
                        && cards.get(i + 2).getRank() == cards.get(i).getRank()
                        && cards.get(i + 3).getRank() == cards.get(i).getRank()) {
                    return true;
                }
            }
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
        return false;
    }

    private boolean isTwoPair() {
        ArrayList<Card> cards = getCards();
        Collections.sort(cards);
        int counter = 0;
        if (isOnePair()) {
            for (int i = 0; i < cards.size() - 1; i++) {
                if (cards.get(i).getRank() == cards.get(i + 1).getRank()) {
                    counter++;
                    if (counter >= 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isStraight() {
        ArrayList<Card> cards = getCards();
        Collections.sort(cards);
        int counter = 0;
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getRank().getValue()
                    == cards.get(i + 1).getRank().getValue() - 1) {
                counter++;
            }
        }
        if (cards.get(cards.size() - 1).getRank().getValue() - 1
                == cards.get(cards.size() - 2).getRank().getValue()) {
            counter++;
        }
        return counter >= 4;
    }

    private boolean isFlush() {
        ArrayList<Card> cards = getCards();
        int diaCounter = 0;
        int spaCounter = 0;
        int cluCounter = 0;
        int heaCounter = 0;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getSuit() == Card.SUIT.DIAMONDS) {
                diaCounter++;
            } else if (cards.get(i).getSuit() == Card.SUIT.CLUBS) {
                cluCounter++;
            } else if (cards.get(i).getSuit() == Card.SUIT.HEARTS) {
                heaCounter++;
            } else {
                spaCounter++;
            }
        }
        return diaCounter >= 5 || spaCounter >= 5
                || cluCounter >= 5 || heaCounter >= 5;
    }

    private boolean isStraightFlush() {
        if (isStraight()) {
            if (isFlush()) {
                return true;
            }
        }
        return false;
    }

    private boolean isFullHouse() {
        if (isTwoPair()) {
            if (isThreeOfKind()) {
                return true;
            }
        }
        return false;
    }

    private boolean isRoyalFlush() {

        if (isStraightFlush()) {
            ArrayList<Card> cards = getCards();
            Collections.sort(cards);
            if (cards.get(cards.size() - 1).getRank() == Card.RANK.ACE) {
                if (cards.get(cards.size() - 5).getRank() == Card.RANK.TEN) {
                    return true;
                }
            }
        }
        return false;
    }
}
