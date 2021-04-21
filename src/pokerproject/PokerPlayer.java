package pokerproject;

import java.util.Scanner;

public class PokerPlayer extends Player {

    private String name;
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
        this.folded = folded;
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
        setMoney(getMoney() - amount);
    }

    public void check() {
        bet(0);
    }

    public boolean canBet(double amount) {
        return getMoney() - amount >= 0;
    }

    public double calcBlind() {
        return getMoney() * 0.07;
    }

    public void takeBlind(double blindAmount) {
        setMoney(getMoney() - blindAmount);
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

}
