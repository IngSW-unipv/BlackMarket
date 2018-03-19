package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

// Nichetti Mattia 441994

public class NichettiMattia extends Dealer {
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if(roundNo == 0)
            return Briefcase.EMPTY;
        if(this.getCoins()<0)
            return Briefcase.EMPTY;
        else
            return Briefcase.EMPTY;
    }

}
