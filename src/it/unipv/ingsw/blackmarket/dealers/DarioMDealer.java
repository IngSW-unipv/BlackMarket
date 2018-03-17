package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class DarioMDealer extends Dealer{

    private Briefcase briefcase;
    private Briefcase firstBriefcase;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if(roundNo == 1){
            briefcase = Briefcase.FULL;
            return briefcase;
        }

        return briefcase;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {

        // Provo a fregarlo se é un Majority
        if (roundNo == totRounds / 2) {
            briefcase = Briefcase.EMPTY;
        }
        // Mi metto subito al riparo nel caso sia un TitForTat
        if (roundNo == (totRounds / 2) + 1) {
            briefcase = Briefcase.FULL;
        }
        // Capisco se é un TitForThat o un Majority
        if (roundNo == ((totRounds / 2) + 2) && exchange.secondBriefcase() == Briefcase.FULL) {
            briefcase = Briefcase.EMPTY;
        }
        // Frego il TitForTat
        if (roundNo == totRounds - 1) {
            briefcase = Briefcase.EMPTY;
        }
    }
}
