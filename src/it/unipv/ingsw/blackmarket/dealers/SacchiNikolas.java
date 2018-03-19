package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class SacchiNikolas extends Dealer {
    private int cheatedCount=0; //EMPTY ricevuti
    private int honestCount=0;  //FULL ricevuti
    private int honestCountMe=0; //FULL inviati

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
            if(roundNo==1){             //Al primo round conviene essere onesti
                honestCount=0;
                cheatedCount=0;
                honestCountMe=0;

                honestCountMe ++;
                return Briefcase.FULL;
            }
            if(roundNo==totRounds) return Briefcase.EMPTY; //all'ultimo round conviene essere disonesti (non viene controllato)
            else{
                if(honestCount>3||cheatedCount>1||honestCountMe>3) return Briefcase.EMPTY;
                else
                    return Briefcase.FULL;
            }
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        super.exchangeResult(exchange, roundNo, totRounds);

        if(exchange.secondBriefcase()==Briefcase.FULL) honestCount++;
        if(exchange.secondBriefcase()==Briefcase.EMPTY) cheatedCount++;
    }
}
