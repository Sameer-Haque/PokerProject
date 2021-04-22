package pokerproject;

import java.util.ArrayList;

public class PokerGame extends Game {
    
    private String name;
    private double money;
    private Hand hand;
    private boolean folded;
    private static player1 player =10;
    private static player2 player = 10;
    Private HAND_VALUE value;
    

    public enum HAND_VALUE {
        HIGH, ONE_PAIR, TWO_PAIR, THREE_OF_KIND, STRAIGHT, FLUSH,
        FULL_HOUSE, FOUR_OF_KIND, STRAIGHT_FLUSH, ROYAL_FLUSH;
    }


    public PokerGame(String string) {
        super(string);
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
    
    public void dealPlayerCards(){
        for(int i = 0; i<deck.size(); i+=2){
            player1.add(deck.get(i));
            player2.add(deck.get(i+1));
         
        }
        
    }

    public void dealBoardCards(ArrayList<Player> players, GroupOfCards deck, int flipedAmount){
       deck.getCards().get(0)
        deck.getCards().remove(0)  
            
        
        
    }
    
    public void flipBoardCards(int i){
        for (int a = 0; a <= i; a++){
            System.out.println(EARTS, DIAMONDS, SPADES, CLUBS;);// print the cards in dealBoardCard method
        }
    }
    
    
    
    @Override
    public void play() {
       if (!isFolded()) {
                Scanner sc = new Scanner(System.in);
                boolean success = false;
                Pot pot = Pot.getInstance();
                do {
                System.out.println("What do you want to do?\n"
                        + "Bid[B] | Fold[F] | Check[C]");
                String input = sc.next();
                try {
                    if (input.equalsIgnoreCase("B")) {
                        System.out.println("Enter how much you want to bid");
                        double amount = Double.parseDouble(sc.next());
                        if(canBet(amount)) {
                            bet(amount);
                            pot.addMoney(amount);
                            success = true;
                        }
                        else
                            success = false;
                    }
                    else if (input.equalsIgnoreCase("F")) {
                        fold();
                        success = true;
                    }
                    else if (input.equalsIgnoreCase("C")) {
                        check();
                        success = true;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Error Number not entered.");
                }
            } while(!success);
        
        }
    }

    @Override
    public void declareWinner() {
        
        if (player1.baseHand() > player2.baseHand()) {
            System.out.println(player1.getName().toUpperCase() + " WINS " +
                "WITH A TOTAL OF " + player1.baseHand() + " CARDS!");
        }
        else if (player2.baseHand() > player1.baseHand()) {
            System.out.println(player2.getName().toUpperCase() + " WINS " +
                "WITH A TOTAL OF " + player2.baseHand() + " CARDS!");
        }
        else {
            System.out.println("THE GAME IS TIED");
        }

        System.out.println();
            
 // display the final score
    player1.displayScore();
     player2.displayScore();
    }
}
