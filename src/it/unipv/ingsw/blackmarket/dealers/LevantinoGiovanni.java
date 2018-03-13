package it.unipv.ingsw.blackmarket.dealers;

//Levantino Giovanni 439783

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

public class LevantinoGiovanni extends Dealer {
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        return Briefcase.EMPTY;
    }
}

