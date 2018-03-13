package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class FaustoCapelli extends Dealer{
    private int full, empty;
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if(roundNo==1)
            return Briefcase.FULL;
        if(roundNo<=totRounds*9/10)
            return Briefcase.EMPTY;
        if(full>empty+1)
            return Briefcase.FULL;
        return Briefcase.EMPTY;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if (roundNo==1) {
            full = 0;
            empty=0;
        }
        if (exchange.secondBriefcase().equals(Briefcase.FULL))
            full++;
        else
            empty++;
    }
}
