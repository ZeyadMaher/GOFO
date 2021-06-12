/**
 * This class represents User's E-wallet
 * @author Zeyad Maher Mahmoud
 */
public class Ewallet {
    private float balance;

    /**
     * This method sets User's balance to a certain value
     * @param balance the balance value
     */
    public void setBalance(float balance) {
        this.balance = balance;
    }

    /**
     * This method gets the user's balance
     * @return user's balance
     */
    public float getBalance() {
        return balance;
    }
}
