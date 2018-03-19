package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class Curcio extends Dealer {
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
        if(roundNo<=5) {
            last = exchange.secondBriefcase();
        }
        else {
            last=Briefcase.EMPTY;
        }
    }
}
