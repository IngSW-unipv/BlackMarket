package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;


public class Cabrini extends Dealer {
    Briefcase case_;
    Boolean controllo = false;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {

        if(roundNo == 1)
            return Briefcase.FULL;
        else if (controllo == true)
            return case_;
        else
            return case_;

    }


    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if(exchange.secondBriefcase().equals(Briefcase.EMPTY) ) {
            controllo = true;
            case_ = Briefcase.EMPTY;
        }
        else
            case_ = Briefcase.EMPTY;
    }
}
