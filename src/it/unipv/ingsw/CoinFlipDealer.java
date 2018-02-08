package it.unipv.ingsw;

import java.util.List;
import java.util.Random;

public class CoinFlipDealer extends Dealer {

    private Random randomGenerator = new Random();

    @Override
    public Briefcase exchangeBriefcase(List<Briefcase> history, int rounds) {
        return (randomGenerator.nextBoolean() ? Briefcase.EMPTY : Briefcase.FULL);
    }
}
