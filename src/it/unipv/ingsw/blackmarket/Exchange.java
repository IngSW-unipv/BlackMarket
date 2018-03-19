package it.unipv.ingsw.blackmarket;


/**
 * An exchange of briefcases.
 */
public final class Exchange {
    /** Value obtained when buying a case of goods. */
    public static final int VALUE_FOR_BUYER = 14;
    /** Value lost when selling a case of goods. */
    public static final int VALUE_FOR_SELLER = 10;

    /// Case exchanged by the first dealer.
    private final Briefcase case1;
    /// Case exchanged by the second dealer.
    private final Briefcase case2;

    /**
     * Create a new exchange.
     * @param case1 case exchanged by the first dealer.
     * @param case2 case exchanged by the second dealer.
     */
    public Exchange(Briefcase case1, Briefcase case2) {
        this.case1 = case1;
        this.case2 = case2;
    }

    /**
     * Return the case exchanged by the first dealer.
     */
    public Briefcase firstBriefcase() {
        return case1;
    }

    /**
     * Return the case exchanged by the second dealer.
     */
    public Briefcase secondBriefcase() {
        return case2;
    }

    /**
     * Return the gain of for first dealer resulting from the exchange.
     */
    public int firstReward() {
        return computeReward(case1, case2);
    }

    /**
     * Return the gain of for second dealer resulting from the exchange.
     */
    public int secondReward() {
        return computeReward(case2, case1);
    }

    /**
     * Make a new exchange with the dealers inverted.
     */
    public Exchange reverse() {
        return new Exchange(case2, case1);
    }

    /**
     * Compute the gain for a dealer when it trades a briefcase with another.
     * @param dealerCase the case traded by the dealer
     * @param otherCase  the case traded by its business partner
     */
    private int computeReward(Briefcase dealerCase, Briefcase otherCase) {
        int loss = (dealerCase == Briefcase.FULL ? VALUE_FOR_SELLER : 0);
        int gain = (otherCase == Briefcase.FULL ? VALUE_FOR_BUYER : 0);
        return gain - loss;
    }
}
