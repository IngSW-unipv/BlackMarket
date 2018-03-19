package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.util.ArrayList;

public class MarcoLecce extends Dealer {
    //LECCE MARCO 426740
    ArrayList<ArrayList<Briefcase>> caseRegistered;
    ArrayList<Briefcase> personCase;
    public MarcoLecce(){
        personCase= new ArrayList<Briefcase>(2);
        caseRegistered= new ArrayList<ArrayList<Briefcase>>(10);
    }

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if(roundNo<3){
                return Briefcase.FULL; }

        return Briefcase.EMPTY;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        personCase.add(exchange.firstBriefcase());
    }
}
