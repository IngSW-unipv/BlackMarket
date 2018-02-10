package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

import java.util.Random;

/**
 * A dealer who randomly chooses the kind of briefcase to exchange.
 */
public class CoinFlipDealer extends Dealer {

    private Random randomGenerator = new Random();

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        return (randomGenerator.nextBoolean() ? Briefcase.EMPTY : Briefcase.FULL);
    }
}
