package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.util.Random;

public class CatenaAndrea extends Dealer{

    private Briefcase last;
    private Random randomGenerator = new Random();

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if(roundNo == 1) {
            return Briefcase.FULL;
        }else if (last == Briefcase.EMPTY){
            return (randomGenerator.nextBoolean() ? Briefcase.EMPTY : Briefcase.FULL);
        }else if(last == Briefcase.FULL && roundNo != totRounds-1){
            return last;
        }else return Briefcase.EMPTY;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        last = exchange.secondBriefcase();
    }

}
