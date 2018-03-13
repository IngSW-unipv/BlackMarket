package it.unipv.ingsw.blackmarket.dealers;
//Simone Andreini mat 436740

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.util.Random;

public class AndreiniSimone extends Dealer{
    private int round=0;
    private Briefcase case_;
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        Briefcase borsa;
        setRound();
        Random randomGenerator = new Random();
        if (round%2==0 && round%3==0){
            if (case_==Briefcase.FULL) {
                return (randomGenerator.nextBoolean() ? Briefcase.EMPTY : Briefcase.FULL);
            }
            else {
                return Briefcase.EMPTY;
            }
        }
        else {
            borsa=Briefcase.EMPTY;
        }
        return borsa;
    }

    private void setRound() {
        round++;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if (roundNo == 1)
            case_ = exchange.secondBriefcase();
    }
}
