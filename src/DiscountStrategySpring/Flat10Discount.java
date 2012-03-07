/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DiscountStrategySpring;



/**
 *
 * @author Jake Baldwin
 */
public class Flat10Discount implements DiscountStrategy {

   private double baseRate;
    private double price;
    private double qty;
    private double min;

//    public Flat10Discount(double baseRate, double qty) {
//        this.baseRate = baseRate;
//        this.qty = qty;
//    }
 @Override
    public double getDiscount() {
        return 10.00;
    }
@Override
    public double getBaseRate() {
        return baseRate;
    }
@Override
    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }
@Override
    public double getPrice() {
        return price;
    }
@Override
    public void setPrice(double price) {
        this.price = price;
    }
@Override
    public double getQty() {
        return qty;
    }
@Override
    public void setQty(double qty) {
        this.qty = qty;
    }
@Override
    public double getMin() {
        return min;
    }
@Override
    public void setMin(double min) {
        this.min = min;
    }

@Override
    public String toString() {
        return "Flat 10 Dollar Discount";
    }
}