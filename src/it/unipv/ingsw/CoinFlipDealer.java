package it.unipv.ingsw;

import java.util.List;
import java.util.Random;

public class CoinFlipDealer extends Dealer {

    private Random randomGenerator = new Random();

    @Override
    public Suitcase exchangeSuitcase(List<Suitcase> history, int rounds) {
        return (randomGenerator.nextInt(2) == 0 ? Suitcase.EMPTY : Suitcase.FULL);
    }
}
