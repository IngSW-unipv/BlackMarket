package it.unipv.ingsw.blackmarket;

public class Exchange {
    /** Value obtained when buying a case of goods. */
    public static final int VALUE_FOR_BUYER = 14;
    /** Value lost when selling a case of goods. */
    public static final int VALUE_FOR_SELLER = 10;

    private Briefcase case1;
    private Briefcase case2;

    public Exchange(Briefcase case1, Briefcase case2) {
        this.case1 = case1;
        this.case2 = case1;
    }

    public Briefcase firstBriefcase() {
        return case1;
    }

    public Briefcase secondBriefcase() {
        return case2;
    }

    public int firstReward() {
        return computeReward(case1, case2);
    }

    public int secondReward() {
        return computeReward(case2, case1);
    }

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
