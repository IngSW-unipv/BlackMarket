package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.util.Random;

/*  Nome: Cristian Cognome: Regna
* */

public class RegnaCristian extends Dealer {

    private Random randomGenerator = new Random();
    private Briefcase[] case_;
    private Briefcase case1;
    int cont = 0;

    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo == 1)
            return Briefcase.FULL;
        else
        {
            if(cont >= roundNo/8){
                case1 = Briefcase.EMPTY;
            }
        }
        return case1;
    }

    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        case_ = new Briefcase[roundNo];
        for(int i = 0; i < roundNo/4;i++) {
            case_[i] =  exchange.secondBriefcase();
        }
        for(int i = 0; i < roundNo/4;i++) {
            if(case_[i].equals(Briefcase.EMPTY));
            cont++;
        }
    }


}
