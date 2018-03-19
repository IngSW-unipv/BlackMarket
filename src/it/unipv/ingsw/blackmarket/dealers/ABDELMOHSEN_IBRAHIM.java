package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

/*ABDEL MOHSEN ALAA EL DIN*/
public class ABDELMOHSEN_IBRAHIM extends Dealer {
    private Briefcase bag = Briefcase.FULL;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo == 1){
            bag = Briefcase.FULL;
        }
        if (roundNo > (totRounds / 2) + 1){
            return Briefcase.EMPTY;
        } else
            return bag;

    }

    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if (exchange.secondBriefcase().equals(Briefcase.FULL)){
            bag = Briefcase.EMPTY;
        } else if (exchange.firstBriefcase().equals(Briefcase.FULL)){
            bag = Briefcase.EMPTY;
        }
    }
}
