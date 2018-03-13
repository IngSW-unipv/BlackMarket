package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.util.Random;

public class DiGiustoFederico extends Dealer { //Federico Di Giusto 435462
    private Random randomGenerator=new Random();
    Briefcase case_;
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo == 1)
            return (randomGenerator.nextBoolean() ? Briefcase.FULL : Briefcase.EMPTY);
        else
            return case_;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if(Briefcase.EMPTY.equals(exchange.secondBriefcase())){
            case_=Briefcase.EMPTY;
        }
        else case_=(randomGenerator.nextBoolean() ? Briefcase.FULL : Briefcase.EMPTY);
    }
}
