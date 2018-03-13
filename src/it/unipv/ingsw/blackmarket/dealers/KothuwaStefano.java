package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

//KOTHUWA GAMAGE THENUKA STEFANO 439149
public class KothuwaStefano extends Dealer {
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        return Briefcase.FULL;
    }
}
