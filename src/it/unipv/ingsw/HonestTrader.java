package it.unipv.ingsw;

import java.util.List;

public class HonestTrader extends Dealer {
    @Override
    public Suitcase exchangeSuitcase(List<Suitcase> history, int rounds) {
        return Suitcase.FULL;
    }
}
