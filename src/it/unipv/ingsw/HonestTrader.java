package it.unipv.ingsw;

import java.util.List;

public class HonestTrader extends Dealer {
    @Override
    public Briefcase exchangeBriefcase(List<Briefcase> history, int rounds) {
        return Briefcase.FULL;
    }
}
