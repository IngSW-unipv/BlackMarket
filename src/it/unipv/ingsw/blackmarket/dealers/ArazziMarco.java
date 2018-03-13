package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class ArazziMarco extends Dealer {

    Briefcase case_;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if(roundNo==1){
            case_=Briefcase.FULL;
        }

        else{
            case_=Briefcase.EMPTY;
        }

        return case_;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if(roundNo!=1){
            exchange.reverse();
        }
    }
}
