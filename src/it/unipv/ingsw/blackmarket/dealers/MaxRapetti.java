package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class MaxRapetti extends Dealer {

    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo == 1) {
            return Briefcase.FULL;
        }
        return Briefcase.EMPTY;
    }
}
