package DiscountStrategySpring;

/**
 * This class represents a Customer. In a more sophisticated program you
 * would have many more properties.
 *
 * @author jlombardo
 */
public class Customer {
    private String lastName;
    private String firstName;
    private String accountNo;

    public Customer(String lastName, String firstName, String accountNo) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return firstName + " " + lastName + "\n"
                + "Account No: " + accountNo;
    }
}
