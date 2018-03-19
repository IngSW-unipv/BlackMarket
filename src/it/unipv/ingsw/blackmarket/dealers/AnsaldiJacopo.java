package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.text.BreakIterator;
import java.util.ArrayList;

public class AnsaldiJacopo extends Dealer {
    //ANSALDI 437472
    private Briefcase last;
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
       if(roundNo == 0){
           return Briefcase.FULL;
       }
       if(roundNo==totRounds) return Briefcase.EMPTY;
       else return last;

    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        last=exchange.secondBriefcase();
    }
}
