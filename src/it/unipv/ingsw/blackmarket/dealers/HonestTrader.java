package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

import java.util.List;

public class HonestTrader extends Dealer {
    @Override
    public Briefcase exchangeBriefcase(List<Briefcase> history, int rounds) {
        return Briefcase.FULL;
    }
}
