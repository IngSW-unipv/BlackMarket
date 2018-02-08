package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

import java.util.List;
import java.util.Random;

public class FirstImpressionDealer extends Dealer {
    private Random randomGenerator = new Random();

    @Override
    public Briefcase exchangeBriefcase(List<Briefcase> history, int rounds) {
        if (history.size() == 0) {
            if (randomGenerator.nextBoolean())
                return Briefcase.FULL;
            else
                return Briefcase.EMPTY;
        } else {
            return history.get(0);
        }
    }
}