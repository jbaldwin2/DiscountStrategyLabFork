package DiscountStrategySpring;

import java.text.NumberFormat;

/**
 * This class is a simulation of an Invoice. Note that it delegates some of
 * the work to the Customer and LineItem classes. But it also provides a
 * display service. This could be made more flexible by creating various
 * DisplayStrategy objects.
 *
 * @author jlombardo
 */
public class Invoice {
    public static final int ID_MAX_LEN = 5;
    public static final int PROD_MAX_LEN = 30;
    public static final int QTY_MAX_LEN = 5;
    public static final int DISCOUNT_MAX_LEN = 10;
    public static final int AMT_MAX_LEN = 10;

    private Customer customer;
    private LineItem[] lineItems = new LineItem[0];

    public Invoice(String customerActNo) {
        customer = this.findCustomer(customerActNo);
        if(customer == null) {
            customer = new Customer("Unknown", "Unknown", "Unknown");
        }
    }

    // NOte the Invoice only knows about Customer and LineItem, thereby
    // minimizing dependencies. Why should the Invoice know about Product?
    // Only the LineItem needs to know that.
    public void addLineItem(String prodId, double qty) {
        LineItem[] temp = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        temp[temp.length-1] = new LineItem(prodId, qty);
        lineItems = temp;
    }

    /*
     * In a better program we would use various formatting strategies to
     * make this more flexible. Right now the formatting rules are hard
     * coded into this class, making this feature rather rigid. Note the
     * different places the data come from -- customer info from Customer,
     * line item info from LineItem, totals from Invoice. Each component
     * contributes to the final Invoice.
     */
    public String getFormattedInvoice() {
        double totalDue = 0.0;
        double totalDiscount = 0.0;
        String invoice = "SOLD TO:\n" + customer.toString() + "\n\n";
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        invoice += pad("ID", ID_MAX_LEN) +" ";
        invoice += pad("Product", PROD_MAX_LEN) +" ";
        invoice += pad("Qty", QTY_MAX_LEN) +" ";
        invoice += pad("Price", AMT_MAX_LEN) +" ";
        invoice += pad("Discount", DISCOUNT_MAX_LEN) +" ";
        invoice += pad("Ext. Price", AMT_MAX_LEN) +"\n";

        invoice += "----------------------------------------------------------------------------\n";

        for(LineItem item : lineItems) {
            invoice += item.toString() + "\n";
        }

        for(LineItem item : lineItems) {
            totalDue += item.getLineItemTotal();
            totalDiscount += item.getTotalDiscount();
        }

        invoice += "\n-----------------------";

        invoice += "\nTotal Amount Due: ";
        invoice += nf.format(totalDue);
        invoice += "\nTotal Discount: ";
        invoice += nf.format(-totalDiscount);


        return invoice;
    }

    /*
     * In a future version, the implementation of this method could be
     * changed to query a database. Such a change would not break any existing
     * code because the methodology for finding a customer is encapsulated
     * away in this method.
     */
    private Customer findCustomer(String actNo) {
        Customer customer = null;

        for(Customer c : FakeDatabase.customers) {
            if(c.getAccountNo().equals(actNo)) {
               customer = c;
               break;
            }
        }

        return customer;
    }

    /**
     * Right justifies output.
     * @param value - the value to padd on left side
     * @param maxLength - the available space which includes the pad on the
     * left + the value on the right
     * @return a padded value
     */
    public static final String pad(String value, int maxLength) {
        int diff = maxLength - value.length();
        String padded = "";

        for(int i=0; i < diff; i++) {
            padded += " ";
        }

        return padded + value;
    }
}
