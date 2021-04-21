package pokerproject;

import java.util.ArrayList;

public class PokerGame extends Game {

    public PokerGame(String string) {
        super(string);
    }
    
    public void dealPlayerCards(){
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}