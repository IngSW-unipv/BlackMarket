package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

import java.util.Random;

public class DiCeccaRita extends Dealer {
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        return Briefcase.EMPTY;
    }
}
