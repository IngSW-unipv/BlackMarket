package it.unipv.ingsw.blackmarket.dealers;
//Simone Andreini mat 436740

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.util.Random;

public class AndreiniSimone extends Dealer{
    private Briefcase case_;
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        Briefcase borsa;
        if(roundNo==1){
            return Briefcase.EMPTY;
        }
        return scelta(roundNo);
    }

    private Briefcase scelta(int roundNo) {
        Random randomGenerator = new Random();
        if (roundNo%3==0){
            if (case_==Briefcase.FULL) {
                return (randomGenerator.nextBoolean() ? Briefcase.EMPTY : Briefcase.FULL);
            }
            else {
                return Briefcase.EMPTY;
            }
        }
        else {
            return Briefcase.EMPTY;
        }
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        case_ = exchange.secondBriefcase();
    }
}
