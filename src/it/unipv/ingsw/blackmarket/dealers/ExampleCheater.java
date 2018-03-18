package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

/**
 * Example class for an "extreme cheater" cit.
 */
public final class ExampleCheater extends Dealer {

    private long exchangeId;

    public ExampleCheater() {
        AntiClaudio.joinTheGuild(this);
    }

    @Override
    public final Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        return Briefcase.EMPTY;
    }

    @Override
    public final void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if (roundNo == 1) {
            exchangeId = System.currentTimeMillis();
        }
    }

    public long getExchangeId() {
        return exchangeId;
    }
}
