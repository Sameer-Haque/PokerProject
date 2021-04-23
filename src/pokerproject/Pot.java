/**
 * singleton pot
 * @author Sameer
 * Date: 4/22/21
 * makes a single Pot object to store money
 */
package pokerproject;

/**
 *
 * @author Sameer
 */
public final class Pot {
    
    private static Pot INSTANCE;
    private double money;
    
    private Pot() {
        this.money = 0.0;
    }
    
    public static Pot getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Pot();
        }
        return INSTANCE;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    
    public void addMoney(double amount) {
        money += amount;
        
    }
    public void emptyPot() {
        money = 0.0;
    }
    
    
}
