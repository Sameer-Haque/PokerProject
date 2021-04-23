package pokerproject;

/**
 * play the Poker Game
 * @author Sameer
 * Date: 4/22/21
 * makes a pokergame that you can play
 */

import java.util.ArrayList;
import java.util.Scanner;

public class PokerGame extends Game {

    public PokerGame(String string) {
        super(string);
    }
    
    public static void main(String[] args) {
        PokerGame game = new PokerGame("Texus Hold'em");
        game.play();
    }
    public void dealBoardCard(ArrayList<PokerPlayer> players,
            GroupOfCards deck) {
        Card card = deck.getCards().get(0);
        System.out.println(card);
        for (PokerPlayer player : players) {
            player.getHand().getCards().add(card);
        }
        deck.getCards().remove(0);
    }

    @Override
    public void play() {
        Pot pot = Pot.getInstance();
        double buyIn;
        Scanner sc = new Scanner(System.in);
        ArrayList<PokerPlayer> players = new ArrayList<PokerPlayer>();
        GroupOfCards deck = new GroupOfCards(52);
        deck.fillDeck();
        deck.shuffle();

        System.out.println("Welcome to group 2's Poker Game");
        buyIn = getBuyIn();
        System.out.println("What is Player Ones name");
        String name = sc.nextLine();
        players.add(new PokerPlayer(name, buyIn,
                new Hand(new ArrayList<Card>())));
        System.out.println("What is Player Twos name");
        name = sc.nextLine();
        players.add(new PokerPlayer(name, buyIn,
                new Hand(new ArrayList<Card>())));
        while (players.get(0).getMoney() > 0 && players.get(1).getMoney() > 0) {
            players.get(0).dealPlayerCards(deck);
            players.get(1).dealPlayerCards(deck);
            players.get(0).play();
            players.get(1).play();
            dealBoardCard(players, deck);
            dealBoardCard(players, deck);
            dealBoardCard(players, deck);
            players.get(0).play();
            players.get(1).play();
            dealBoardCard(players, deck);
            players.get(0).play();
            players.get(1).play();
            dealBoardCard(players, deck);
            if (players.get(0).isFolded()) {
                players.get(1).displayRoundWinner(pot);
            } else if (players.get(1).isFolded()) {
                players.get(0).displayRoundWinner(pot);
            } else {
                if (players.get(0).getHand().findBestHandValue().getCompareNum()
                        > players.get(1).getHand().findBestHandValue().getCompareNum()) {
                    players.get(0).displayRoundWinner(pot);
                }
                else if (players.get(1).getHand().findBestHandValue().getCompareNum()
                        > players.get(0).getHand().findBestHandValue().getCompareNum()) {
                    players.get(1).displayRoundWinner(pot);
                }
                else {
                    System.out.println("TIE");
                    players.get(0).setMoney(players.get(0).getMoney() + (pot.getMoney()/2));
                    players.get(1).setMoney(players.get(1).getMoney() + (pot.getMoney()/2));
                }
                 pot.emptyPot();
                 players.get(0).getHand().getCards().clear();
                 players.get(0).getHand().getCards().clear();
            }

        }
        if (players.get(0).getMoney() > 0) {
            System.out.println(players.get(0).getName()+" WON THE POKER GAME");
        }
        else
            System.out.println(players.get(1).getName()+" WON THE POKER GAME");
    }
    public static double getBuyIn() {
        Scanner sc = new Scanner(System.in);
        double buyIn;
        do {
            System.out.println("How much money would you like to play with(buy-in)"
                    + "\nMin: 10.0$\tMax: 100.0$");
            buyIn = sc.nextDouble();
        } while (buyIn >= 10.0 && 100.0 <= buyIn);
        return buyIn;
    }
}
