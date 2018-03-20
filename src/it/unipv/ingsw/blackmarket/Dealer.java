package it.unipv.ingsw.blackmarket;


/**
 * A dealer in the black market.
 */
public abstract class Dealer implements Comparable<Dealer> {
    /// Money made so far.
    private long coins = 0;


    /**
     * Some more protections against extreme cheaters
     */
    private final CoinValidator cv = new CoinValidator();

    private final class CoinValidator {
        private long verifiedCoins = 0;

        private void setVerifiedCoins(long c) {
            verifiedCoins = c;
        }

        private boolean legit(long c) {
            if (verifiedCoins == c) return true;
            return false;
        }
    }

    /**
     * Checks if dealer's coins are legit
     */
    final boolean isCheater() {
        return !cv.legit(coins);
    }


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
    public final long getCoins() {
        return coins;
    }

    /**
     * Add some money to the profit of the dealer.
     * Setting coins value by using reflection is NOT allowed.
     */
    final void addCoins(long amount) {
        if (this.isCheater()) {
            coins = Long.MIN_VALUE;
            cv.setVerifiedCoins(coins);
            return;
        }

        try {
            coins = Math.addExact(coins, amount);
        } catch (ArithmeticException e) {
            coins = Long.MIN_VALUE;
        }
        cv.setVerifiedCoins(coins);
    }

    /**
     * Ask the dealer which briefcase is going to exchange with its business partner.
     * @param roundNo progressive number for the current exchange (between 1 and totRounds)
     * @param totRounds total number of rounds that will form this sequence of exchanges
     * @return the briefcase to be exchanged
     */
    abstract public Briefcase exchangeBriefcase(int roundNo, int totRounds);

    /**
     * Inform the dealer of the outcome of the last exchange.
     *
     * Note that this dealer is always the first one in the exchange object.
     *
     * @param exchange the last exchange
     * @param roundNo number of exchanges already done, between 1 and totRounds
     * @param totRounds number of exchanges in the series
     */
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        // By default, do nothing.
        // Derived classes may use this method to gather information for future exchanges.
    }

    /**
     * Note: this class has a natural ordering that is inconsistent with equals.
     *
     * @param   o the dealer to be compared.
     * @return  a negative integer, zero, or a positive integer as this object
     *          is less than, equal to, or greater than the specified object.
     */
    @Override
    public final int compareTo(Dealer o) {
        return Long.compare(this.coins, o.coins);
    }
}
