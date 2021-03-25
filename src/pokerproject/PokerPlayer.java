package pokerproject;

public class PokerPlayer extends Player {

    private String name;
    private double money;
    private Hand hand;
    
    
    public PokerPlayer(String name, double money, Hand hand) {
        super(name, money);
        this.name = name;
        this.money = money;
        this.hand = hand;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    
   
     

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}