package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;


public class Cabrini extends Dealer {

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if(roundNo > 0 && roundNo < 6)
            return Briefcase.EMPTY;
        else
            return Briefcase.FULL;
    }

}
