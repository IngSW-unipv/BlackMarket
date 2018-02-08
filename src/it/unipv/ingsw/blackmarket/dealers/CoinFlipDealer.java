package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

import java.util.List;
import java.util.Random;

public class CoinFlipDealer extends Dealer {

    private Random randomGenerator = new Random();

    @Override
    public Briefcase exchangeBriefcase(List<Briefcase> history, int rounds) {
        return (randomGenerator.nextBoolean() ? Briefcase.EMPTY : Briefcase.FULL);
    }
}
