package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

public class AlbiniStefano extends Dealer {

    /**
     *
     * Stefano Albini 435643
     * Alessio Bianchi 436392
     * 
     */

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {

        if(roundNo%2 == 0){
            return Briefcase.FULL;
        }
        else{
            return Briefcase.EMPTY;
        }

    }
}
