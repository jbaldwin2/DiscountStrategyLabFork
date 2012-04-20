package DiscountStrategySpring;

/**
 * This class starts the program and fakes some input. In a real program you
 * would start up a GUI and get the input there, and then the GUI would talk
 * to the CashRegister.
 *
 * Rigidity check: this class is highly coupled to the CashRegister class.
 * This is not necessarily a bad thing because in this simple program, the
 * CashRegister will never change. However, in a more sophisticated system we
 * may need different kinds of CashRegister implementations, and then we
 * would base this class on an interface and use dependency injection to
 * provide the implementation object.
 *
 * @author jlombardo
 */
public class StartDemo {
    public static void main(String[] args) {
 
        CashRegister cr = new CashRegister();

        // NOTICE the actual work is encapsulated inside the CashRegister.
        // No unnecessary details are exposed!
        
        // buy 3 items
        cr.startNewSale("1234");
        cr.addNewLineItem("A100", 2);
        cr.addNewLineItem("B321", 9);
        cr.addNewLineItem("C444", 1);

        cr.displayInvoice();

        /*
         * Results should have the following data:
         *
         * Item A100 should have a discount of 5.99, and a Subtotal of 33.91
         * Item B321 should have a discount of 16.88  and a Subtotal of 95.62
         * Item C444 should have a discount of 0 and a Subtotal of 6.25
         * Inoice total due should be 135.78
         * Invoice total discount should be 22.87
         */
    }
}
