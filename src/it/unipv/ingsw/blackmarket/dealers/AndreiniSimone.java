package it.unipv.ingsw.blackmarket.dealers;
//Simone Andreini mat 436740

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;
import java.util.Random;

public class AndreiniSimone extends Dealer{
    private Briefcase case_;
    private int nFull=0,nEmpty=0;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if(roundNo==1){
            return Briefcase.EMPTY;
        }
        return scelta(roundNo);
    }

    private Briefcase scelta(int roundNo) {
        Random randomGenerator = new Random();

        if (nFull>=nEmpty){
            if (case_==Briefcase.FULL && getCoins()<150) {
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
        if (case_.equals(Briefcase.FULL)){
            nFull++;
        }
        else {
            nEmpty++;
        }
    }
}
