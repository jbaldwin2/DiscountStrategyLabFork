/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DiscountStrategySpring;

/**
 *
 * @author jbaldwin2
 */

    public class FakeDatabase {
    public static final Product[] products = new Product[3];
    public static final Customer[] customers = new Customer[2];

    static {
        products[0] = new Product("A100", "Lions Cap", 20.00);
        products[0].addDiscount(new Flat10Discount());

        products[1] = new Product("B321", "Large White Shirt", 30.00);
        products[1].addDiscount(new SchoolDiscount());
        products[1].addDiscount(new QuantityDiscount());

        products[2] = new Product("C444", "Felt Tip Pen, Black", 10.00);
        products[2].addDiscount(new NoDiscount());

        customers[0] = new Customer("Smith", "Porkchop", "1234");
        customers[1] = new Customer("Doe", "Jane", "4321");
    }
}

