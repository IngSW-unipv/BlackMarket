/*
    Carolo Nicolas  436266
    Modica Camilla  439006
    Novelli Giorgia 430088
 */
package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

public class CaroloNicolas extends Dealer {
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo % 2 == 0) {
            return Briefcase.EMPTY;
        } else {
            return Briefcase.EMPTY;
        }

    }
}
