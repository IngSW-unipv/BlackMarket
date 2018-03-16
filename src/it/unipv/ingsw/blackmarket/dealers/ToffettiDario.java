package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.util.Random;

public class ToffettiDario extends Dealer {
    //private Random randomGenerator = new Random();
    private boolean notCheated;
    private int timesBeenHonest = 0;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo == 1) return Briefcase.FULL;
        if (notCheated && timesBeenHonest <= 2 ) 
            return Briefcase.FULL;

        else
            return Briefcase.EMPTY;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if(exchange.secondBriefcase() == Briefcase.EMPTY) {
            notCheated = false;
            timesBeenHonest = 0;
        }
        else {
            notCheated = true;
            timesBeenHonest++;
        }

    }
}
