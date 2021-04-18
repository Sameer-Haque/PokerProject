package pokerproject;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {

    private final HAND_VALUE value;
    private boolean check;

    public enum HAND_VALUE {
        HIGH, ONE_PAIR, TWO_PAIR, THREE_OF_KIND, STRAIGHT, FLUSH,
        FULL_HOUSE, FOUR_OF_KIND, STRAIGHT_FLUSH, ROYAL_FLUSH
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

    public HAND_VALUE getValue() {
        return value;
    }

    public ArrayList<Card> getCards() {
        return Cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.Cards = cards;
    }


    public HAND_VALUE findBestHand() {

        return null;
    }
    
    protected boolean isTwoPair() {
        ArrayList<Card> cards = getCards();
        Collections.sort(cards);
        for(int i = 0; i < cards.size(); i++)
    {
        for(int j = i + 1; j < cards.size(); j++)
        {
            if(cards.get(i).getRank() == cards.get(j).getRank())
            {
                return true;
            }
        }
    }
        return false;
    }

}
