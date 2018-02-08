package it.unipv.ingsw;

import java.util.List;

public class Cheater extends Dealer {
    @Override
    public Briefcase exchangeBriefcase(List<Briefcase> history, int rounds) {
        return Briefcase.EMPTY;
    }
}
