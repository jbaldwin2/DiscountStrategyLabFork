package DiscountStrategySpring;

import java.text.NumberFormat;

/**
 * This class is a simulation of an invoice LineItem. The idea is that a line
 * item knows its product and the product knows its id, name and price.
 * Further, the product knows its discounts. Delegation is used to get the
 * total discount amount from the discount object.
 *
 * @author jlombardo
 */
public class LineItem {
    private Product product;
    private double qty;

    public LineItem(String prodId, double qty) {
        this.product = findProduct(prodId);
        this.qty = qty;
    }

    public double getTotalDiscount() {
        return roundUpCents(product.getTotalDiscount(qty));
    }

    public double getLineItemTotal() {
        return roundUpCents(product.getUnitCost() * qty - getTotalDiscount());
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }
    
    
    /*
     * In a future version, the implementation of this method could be
     * changed to query a database. Such a change would not break any existing
     * code because the methodology for finding a product is encapsulated
     * away in this method.
     */
    private Product findProduct(String productId) {
        Product product = null;

        for(Product p : FakeDatabase.products) {
            if(p.getId().equals(productId)) {
               product = p;
               break;
            }
        }

        return product;
    }


    // Quick and dirty solution, but it's not really the responsibility of
    // the LineItem class to do any formatting. In a better program we 
    // would have various formatting strategies.
    public String toString() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        NumberFormat cf = NumberFormat.getCurrencyInstance();
        nf.setMaximumFractionDigits(2);

        return Invoice.pad(product.getId(),Invoice.ID_MAX_LEN) + " "
            + Invoice.pad(product.getName(),Invoice.PROD_MAX_LEN) + " "
            + Invoice.pad(""+qty,Invoice.QTY_MAX_LEN) + " "
            + Invoice.pad(nf.format(roundUpCents(product.getUnitCost())),Invoice.AMT_MAX_LEN) + " "
            + Invoice.pad(nf.format(roundUpCents(this.getTotalDiscount())),Invoice.DISCOUNT_MAX_LEN) + " "
            + Invoice.pad(nf.format(roundUpCents(this.getLineItemTotal())),Invoice.AMT_MAX_LEN);
    }

    // Utility to round up factional cents
    private double roundUpCents(double value) {
        double result = value * 100;
        result = Math.round(result);
        result = result / 100;
        return result;
    }
}
