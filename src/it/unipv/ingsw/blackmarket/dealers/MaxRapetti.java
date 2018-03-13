package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class MaxRapetti extends Dealer {
    Briefcase case_;

    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
       
        return Briefcase.EMPTY;
    }

    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        case_ = exchange.secondBriefcase();
    }


}
