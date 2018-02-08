package it.unipv.ingsw.blackmarket;

import java.util.List;


/**
 * A dealer in the black market.
 */
public abstract class Dealer {
    /// Money made so far.
    private int balance = 0;

    /**
     * Get the name of the Dealer.
     */
    public final String getName() {
        /// Since we plan to have only one dealer for each class, we use the name of the class.
        return this.getClass().getSimpleName();
    }

    /**
     * Return the profit made by this dealer in its trading activities.
     */
    public final int getBalance() {
        return balance;
    }

    /**
     * Add some money to the profit of the dealer.
     */
    public final void addToBalance(int amount) {
        balance += amount;
    }

    /**
     * Ask the dealer which briefcase is going to exchange with its business partner.
     * @param history briefcases received from the partner in the previous exchange rounds
     * @param rounds total number of rounds that will form this sequence of exchanges
     * @return the briefcase to be exchanged
     */
    abstract public Briefcase exchangeBriefcase(List<Briefcase> history, int rounds);
}
