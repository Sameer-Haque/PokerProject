package pokerproject;

/**
 * the poker player
 * @author Sameer
 * Date: 4/22/21
 * models a poker player
 */

import java.util.Scanner;

public class PokerPlayer extends Player {

    private double money;
    private Hand hand;
    private boolean folded;

    public PokerPlayer(String name, double money, Hand hand) {
        super(name);
        this.money = money;
        this.hand = hand;
        folded = false;
    }

    public boolean isFolded() {
        return folded;
    }

    public void setFolded(boolean isFolded) {
        this.folded = isFolded;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void fold() {
        setFolded(true);
    }

    public void bet(double amount) {
        if (canBet(amount))
            setMoney(getMoney() - amount);
    }

    public void check() {
        bet(0);
    }

    public boolean canBet(double amount) {
        return (getMoney() - amount) >= 0.0;
    }

    public double calcBlind() {
        return getMoney() * 0.07;
    }

    public void takeBlind(double blindAmount) {
        setMoney(getMoney() - blindAmount);
    }
    
    public void dealPlayerCards(GroupOfCards deck) {
        hand.getCards().add(deck.getCards().get(0));
        System.out.println("Cards:");
        System.out.println(deck.getCards().get(0));
        deck.getCards().remove(0);
        hand.getCards().add(deck.getCards().get(0));
        System.out.print("\t");
        System.out.println(deck.getCards().get(0));
        deck.getCards().remove(0);
    }

    @Override
    public void play() {
        if (!isFolded()) {
            Scanner sc = new Scanner(System.in);
            boolean success = false;
            Pot pot = Pot.getInstance();
            do {
                System.out.println("What do you want to do?\n"
                        + "Bid[B] | Fold[F] | Check[C] | Check Money[CM]");
                String input = sc.next();
                try {
                    if (input.equalsIgnoreCase("B")) {
                        System.out.println("Enter how much you want to bid");
                        double amount = Double.parseDouble(sc.next());
                        if (canBet(amount)) {
                            bet(amount);
                            pot.addMoney(amount);
                            success = true;
                        }
                    } else if (input.equalsIgnoreCase("F")) {
                        fold();
                        success = true;
                    } else if (input.equalsIgnoreCase("C")) {
                        check();
                        success = true;
                    } else if (input.equalsIgnoreCase("CM")) {
                        System.out.println(getMoney());
                        play();
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Error Number not entered.");
                }
            } while (!success);

        }
    }
    public void displayRoundWinner(Pot pot) {
        System.out.println(getName() + "Wins the round with a" +
                hand.findBestHandValue());
        setMoney(money+ pot.getMoney());
    }

}
