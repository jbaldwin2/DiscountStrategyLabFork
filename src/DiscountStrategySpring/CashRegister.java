package DiscountStrategySpring;

/**
 * This class simulates a simple Cash Register, whose responsibility is input
 * and output only. To accomplish this, the CashRegister delegates work to
 * the component Invoice object.
 *
 * Rigidity check: the only real dependency here is to the Invoice class.
 * That's not necessarily a bad thing. In a simple program like this the
 * Invoice implementation will never change. However, in a more sophisticated
 * app, where multiple invoice implementations are needed, we would have to
 * use abstraction and base our Invoice on an interface. Then we would use
 * dependency injection to inject the proper implementation.
 *
 * @author jlombardo
 */
public class CashRegister {
    private Invoice invoice;

    // Input is delegated to Invoice
    public void startNewSale(String customerActNo) {
        invoice = new Invoice(customerActNo);
    }

    // Input is delegated to Invoice
    public void addNewLineItem(String productId, double qty) {
        // Note: the CashRegister only knows about the Invoice, thereby
        // minimizing the dependencies
        invoice.addLineItem(productId, qty);
    }

    /*
     * We can argume that the Single Responsibility of the CashRegister
     * is to handle input/output -- this is the output. However, we could
     * make this even more flexible by using various output strategies, such
     * as outputting to console or GUI or file or whatever.
     */
    public void displayInvoice() {
        System.out.println(invoice.getFormattedInvoice());
    }
}
