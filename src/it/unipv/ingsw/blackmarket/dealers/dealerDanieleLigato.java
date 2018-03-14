package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class dealerDanieleLigato extends Dealer {


    int roundNomm, totRounds;
    int full = 0;

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds){

        if(exchange.secondBriefcase().equals(Briefcase.FULL)) {
            full++;

        }

        // System.out.println(roundNo + "+" + full);

        if(roundNo == totRounds)
            full = 0;
    }

     public Briefcase exchangeBriefcase(int roundNo, int totRounds) {

         if (roundNo == 1)
             return Briefcase.FULL;
         else
             return Briefcase.EMPTY;
     }





}
