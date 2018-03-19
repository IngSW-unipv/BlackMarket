package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

/**
 * A dealer who starts behaving honestly and then retaliates when gets cheated by his partner.
 */
public class TitForTat extends Dealer {
    private Briefcase last;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo == 1)
            return Briefcase.FULL;
        else
            return last;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        last = exchange.secondBriefcase();
    }
}
