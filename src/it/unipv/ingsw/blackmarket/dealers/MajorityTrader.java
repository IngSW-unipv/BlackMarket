package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.util.Random;

/**
 * A dealer who cheat if his partner cheated him more often than not.
 * In case of a tie decides randomly.
 */
public class MajorityTrader extends Dealer {
    private int countEmpty = 0;
    private Random randomGenerator = new Random();

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        int full = roundNo - countEmpty - 1;
        if (roundNo == 1 || countEmpty == full)
            return (randomGenerator.nextBoolean() ? Briefcase.EMPTY : Briefcase.FULL);
        else
            return (countEmpty > full ? Briefcase.EMPTY : Briefcase.FULL);
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if (roundNo == 1)
            countEmpty = 0;
        if (exchange.secondBriefcase() == Briefcase.EMPTY)
            countEmpty++;
    }
}
