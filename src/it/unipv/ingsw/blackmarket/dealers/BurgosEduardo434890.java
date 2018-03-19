package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;
import java.util.Random;

/**
 * A dealer who starts behaving honestly and then retaliates when gets cheated by his partner.
 */
public class BurgosEduardo434890 extends Dealer {
    private Briefcase last;
    private Random randomGenerator = new Random();

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo == 1)
            return Briefcase.FULL;
        else
            return last;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if(randomGenerator.nextFloat() < 0.1) {
            last= Briefcase.EMPTY;
        }
        else{
            last= exchange.secondBriefcase();
        }
        // last = (randomGenerator.nextBoolean() ? exchange.secondBriefcase() : Briefcase.FULL) ;
    }
}
