package it.unipv.ingsw.blackmarket.dealers;


import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class NgankemLaurence  extends Dealer {

    Briefcase case_;
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if(roundNo==1) {
            return Briefcase.FULL;
        }
        else
            return case_;
    }
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if (roundNo == 1)
            case_ = exchange.secondBriefcase();
    }
}
