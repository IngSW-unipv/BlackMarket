package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.util.Random;

public class JavierSanttiz extends Dealer {

    private Random randomGenerator = new Random();
    private Briefcase case_;
    private int nOfExchanges = 0;
    private int nOfGoodDealer = 0;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (nOfExchanges == 0){
            nOfExchanges = nOfExchanges + 1;
            return Briefcase.FULL;
        }
        double prob = nOfGoodDealer/nOfExchanges;
        if (prob > 0.5) {
            nOfExchanges = nOfExchanges + 1;
            return  (Briefcase.FULL);
        }else{
            return (Briefcase.EMPTY);
        }
    }
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
            case_ = exchange.secondBriefcase();
            if (case_ == Briefcase.FULL){
                nOfGoodDealer = nOfGoodDealer + 1;
            }
    }

}
