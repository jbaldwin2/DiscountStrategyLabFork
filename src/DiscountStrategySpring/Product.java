package DiscountStrategySpring;

/**
 * This class simulates a product. Note that it stores all discounts applied
 * to it internally in an array. We can add or remove discounts at will.
 *
 * @author jlombardo
 */
public class Product {
    private String id;
    private String name;
    private double unitCost;
    private DiscountStrategy[] discounts = new DiscountStrategy[0];

    public Product() {
    }

    public Product(String id, String name, double unitCost) {
        this.id = id;
        this.name = name;
        this.unitCost = unitCost;
    }

    public double getTotalDiscount(double qty) {
        // get a total of all discounts for this Product
        double totalDiscount = 0.0;
        for(DiscountStrategy discount : discounts) {
            discount.setQty(qty);
            discount.setPrice(getUnitCost());
            totalDiscount += discount.getDiscount();
        }
        return totalDiscount;
    }

    public void addDiscount(DiscountStrategy discount) {
        DiscountStrategy[] temp = new DiscountStrategy[discounts.length + 1];
        System.arraycopy(discounts, 0, temp, 0, discounts.length);
        temp[temp.length-1] = discount;
        discounts = temp;
    }

    public void removeDiscount(DiscountStrategy discount) {
        DiscountStrategy[] temp = new DiscountStrategy[discounts.length - 1];

        for(int i=0, j=0; j < discounts.length; i++, j++) {
            if(discounts[j].toString().equals(discount.toString())) {
                // skip it, but decrement the counter first
                --i;
            } else {
                // copy it
                temp[i] = discounts[j];
            }
        }

        discounts = temp;
    }

    public DiscountStrategy[] getDiscounts() {
        return discounts;
    }

    public void setDiscounts(DiscountStrategy[] discounts) {
        this.discounts = discounts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public String toString() {
        return id + ", " + name + ", " + unitCost;
    }
}
