package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.util.Random;

/* Toffetti Dario 449373 */

public class ToffettiDario extends Dealer {

    private boolean notCheated;
    private int timesBeenHonest;
    private int amHonest;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo == 1) {
            timesBeenHonest = 0;
            amHonest = 1;
            return Briefcase.FULL;
        }

        if (roundNo == totRounds) return Briefcase.EMPTY;

        if (notCheated && timesBeenHonest <= 2 && amHonest < 3) {
            amHonest ++;
            return Briefcase.FULL;
        }
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