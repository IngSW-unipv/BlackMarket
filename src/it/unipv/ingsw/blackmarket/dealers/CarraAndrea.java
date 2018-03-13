package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

import java.util.Random;

/**Andrea Carrà 435969*/
public class CarraAndrea extends Dealer {
    private Random randomGenerator = new Random();
    public CarraAndrea() {
    }

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo==1) {
            return Briefcase.FULL;
        }
        if (roundNo%2==0) {
            return Briefcase.EMPTY;
        }
        else {
            return this.randomGenerator.nextBoolean() ? Briefcase.EMPTY : Briefcase.FULL;
        }
    }
}
