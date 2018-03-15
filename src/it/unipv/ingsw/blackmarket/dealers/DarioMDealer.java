package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class DarioMDealer extends Dealer{

    private Briefcase briefcase = Briefcase.FULL;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        return briefcase;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if(exchange.firstReward() > 0){
            briefcase = exchange.firstBriefcase();
        }
        else{
            briefcase = exchange.secondBriefcase();
        }
    }
}
