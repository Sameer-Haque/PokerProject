package pokerproject;

public class PokerPlayer extends Player {

    private String name;
    private double money;
    private Hand hand;
    private boolean folded;
    
    
    public PokerPlayer(String name, double money, Hand hand, boolean Folded) {
        super(name);
        this.money = money;
        this.hand = hand;
        this.folded =folded;
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
         if(getMoney()-amount >= 0)
            setMoney(getMoney()-amount);
     }
     
     public void check() {
         bet(0);
     }
     public double calcBlind() {
         return getMoney() * 0.07;
     }
     public void takeBlind(double blindAmount) {
         setMoney(getMoney() - blindAmount);
     }

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}