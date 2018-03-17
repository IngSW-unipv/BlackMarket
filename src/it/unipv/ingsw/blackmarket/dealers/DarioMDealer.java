package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class DarioMDealer extends Dealer{

    private Briefcase briefcase;
    private Briefcase briefcaseRound1;
    private Briefcase briefcaseRound2;
    private boolean tooGreedy = false;

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

        if(roundNo == 1){
            briefcaseRound1 = exchange.secondBriefcase();
        }

        if (roundNo == 2){
            briefcaseRound2 = exchange.secondBriefcase();
        }

        if(roundNo == 2 && exchange.secondBriefcase() == Briefcase.EMPTY && briefcaseRound1 == Briefcase.EMPTY){
            briefcase = Briefcase.EMPTY;
            tooGreedy = true;
        }

        // Segnalo quando sto giocando contro qualcuno troppo greedy
        if(roundNo == 3 && exchange.secondBriefcase() == Briefcase.EMPTY && (briefcaseRound1 == Briefcase.EMPTY || briefcaseRound2 == Briefcase.EMPTY)){
            tooGreedy =true;
            briefcase = Briefcase.EMPTY;
        }

        // Provo a fregarlo se é un Majority
        if (roundNo == (totRounds / 2)) {
            briefcase = Briefcase.EMPTY;
        }

        // Mi metto subito al riparo nel caso sia un TitForTat
        if (roundNo == (totRounds / 2) + 1 && !tooGreedy) {
            briefcase = Briefcase.FULL;
        } else if(roundNo == (totRounds / 2) + 1 && tooGreedy){
            briefcase = Briefcase.EMPTY;
        }

        // Capisco se é un TitForThat o un Majority
        if (roundNo == ((totRounds / 2) + 2) && exchange.secondBriefcase() == Briefcase.FULL) {
            briefcase = Briefcase.EMPTY;
        }

        // Frego il TitForTat
        if (roundNo == totRounds - 1) {
            briefcase = Briefcase.EMPTY;
            tooGreedy = false;
        }
    }
}
