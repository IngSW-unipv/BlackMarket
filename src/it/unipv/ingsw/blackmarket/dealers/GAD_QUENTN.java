package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;




/**
 * DEALEAR CHE COSEGNA LA STESSA COSA CHE È STAT RICEVUTA IL SECONDO ROUND
 * lA PRIMA CONSEGNA È ONESTA.
 * 437983
 */
public class GAD_QUENTN extends Dealer{


    Briefcase case_;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {

        if(roundNo == 1) {

            return Briefcase.EMPTY;
        }

    else {

          return case_;
        }
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if(roundNo==1)
        case_ = exchange.secondBriefcase();
    }

}
