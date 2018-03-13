package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

import java.util.Random;
package dealers;

/**Lobianco Mattia 427455 */
public class LobiancoMattia extends Dealer {
    private Random randomGenerator = new Random();
    @Override

    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo%1 == 0) {
            return Briefcase.EMPTY;
        } else {
            return this.randomGenerator.nextBoolean() ? Briefcase.EMPTY : Briefcase.FULL;
        }
    }

}
