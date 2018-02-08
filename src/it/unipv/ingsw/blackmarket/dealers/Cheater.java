package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

import java.util.List;

public class Cheater extends Dealer {
    @Override
    public Briefcase exchangeBriefcase(List<Briefcase> history, int rounds) {
        return Briefcase.EMPTY;
    }
}
