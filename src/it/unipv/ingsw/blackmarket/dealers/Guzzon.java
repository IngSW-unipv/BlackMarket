package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class Guzzon extends Dealer{

    // private Briefcase[] results =new Briefcase[2];
    private boolean seemsHonest;
    private int countHonest;
    private int givenHonest;
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo == 1) {
            countHonest = 0;
            givenHonest = 1;
            return Briefcase.FULL; // first full to win against first impression
        }
        if (roundNo == totRounds) {return Briefcase.EMPTY;} // last is empty 'cause there's no control over that

        if (seemsHonest && givenHonest < 3) {
            return Briefcase.FULL;
        } else {
            return Briefcase.EMPTY;
        }

    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if (exchange.secondBriefcase() == Briefcase.EMPTY) {
            seemsHonest = false;
            countHonest = 0;
        }

        if (exchange.secondBriefcase() == Briefcase.FULL){
            countHonest++;
            if (countHonest <= 2) {
                seemsHonest = true;
            }
        }
    }
}
