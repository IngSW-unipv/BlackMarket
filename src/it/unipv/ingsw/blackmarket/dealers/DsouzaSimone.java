package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Exchange;
import it.unipv.ingsw.blackmarket.Dealer;

public class DsouzaSimone {
    Briefcase case_;


    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {

        if(roundNo == 1) {

            return Briefcase.EMPTY;
        }

        else {

            return case_;
        }
    }


    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if(roundNo==2)
            case_ = exchange.secondBriefcase();

    }
}
