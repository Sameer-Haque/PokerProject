package pokerproject;

import java.util.ArrayList;

public class PokerGame extends Game {

    public PokerGame(String string) {
        super(string);
    }
    
    public void dealPlayerCards(){
        for(int i = 0; i<deck.size(); i+=2){
            player1.add(deck.get(i));
            player2.add(deck.get(i+1));
         
        }
        
    }

    public void dealBoardCards(ArrayList<Player> players){
        
        
    }
    
    public void flipBoardCards(int i){
        for (int a = 0; a <= i; a++){
            System.out.println(); // print the cards in dealBoardCard method
        }
    }
    
    
    
    @Override
    public void play() {
        System.out.println("Playing the Card Game");
        System.out.println();
    }

    @Override
    public void declareWinner() {
        
        if (player1.handSize() > player2.handSize()) {
            System.out.println(player1.getName().toUpperCase() + " WINS " +
                "WITH A TOTAL OF " + player1.handSize() + " CARDS!");
        }
        else if (player2.handSize() > player1.handSize()) {
            System.out.println(player2.getName().toUpperCase() + " WINS " +
                "WITH A TOTAL OF " + player2.handSize() + " CARDS!");
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
