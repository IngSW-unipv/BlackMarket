package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;



public class NichettiMattia extends Dealer {
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if(roundNo == 0)
            return Briefcase.FULL;
        if(this.getCoins()<0)
            return Briefcase.FULL;
        else
            return Briefcase.EMPTY;
    }

}
