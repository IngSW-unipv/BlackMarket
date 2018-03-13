/*
    Carolo Nicolas  436266
    Modica Camilla  439006
    Novelli Giorgia 430088
 */
package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class CaroloNicolas extends Dealer {
    Briefcase case_;
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
            if (roundNo % 2 == 0) {
                return Briefcase.EMPTY;
            } else if (roundNo % 3 == 0) {
                return Briefcase.EMPTY;
            } else if (roundNo % 5 == 0) {
                return Briefcase.EMPTY;
            }
            return Briefcase.FULL;
    }

    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if (roundNo > 0){
            case_ = exchange.secondBriefcase();
        }
    }
}
