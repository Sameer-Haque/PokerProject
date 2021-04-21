/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
