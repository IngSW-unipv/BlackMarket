package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

/*
*
* Jurkic Mladen, 434815
* Lucenti Andrea, 439925
*
* */

public class JurkicLucenti extends Dealer {

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        return Briefcase.EMPTY;
    }
}