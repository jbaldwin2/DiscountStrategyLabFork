package DiscountStrategySpring;

/**
 * This is the general contract for all DiscountStrategy implementations.
 * Note that the job of a DiscountStrategy is to provide the calculated
 * discount. To do that we have to assume certain values are availalbe such
 * as qty, price and minimum qty for quantity discount.
 *
 * @author jlombardo
 */
public interface DiscountStrategy {

    double getBaseRate();

    double getDiscount();

    double getMin();

    double getPrice();

    double getQty();

    void setBaseRate(double baseRate);

    void setMin(double min);

    void setPrice(double price);

    void setQty(double qty);

    String toString();

}
