package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class JurkicLucenti extends Dealer {
    Briefcase case_;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo == 1)
            return (Briefcase.FULL);
        else {
            return case_;
        }
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {

        for(int i = 1; i <= totRounds; i++) {
            if(i == (roundNo)){
                case_ = exchange.secondBriefcase();
            }
        }
    }
}
