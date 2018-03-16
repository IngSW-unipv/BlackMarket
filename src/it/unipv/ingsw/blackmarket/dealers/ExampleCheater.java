package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

/**
 * Example class for an "extreme cheater" cit.
 */
public final class ExampleCheater extends Dealer {

    public ExampleCheater() {
        AntiClaudio.joinTheGuild(this);
    }

    @Override
    public final Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        return Briefcase.EMPTY;
    }
}
