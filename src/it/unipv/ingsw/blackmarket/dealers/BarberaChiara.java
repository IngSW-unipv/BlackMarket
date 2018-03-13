package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.util.Random;

/*BARBERA CHIARA MATRICOLA 435693*/

public class BarberaChiara extends Dealer{

    Briefcase before = null;
    Random rand = new Random();

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {

            if (roundNo == 1 && before == Briefcase.FULL)
                return Briefcase.EMPTY;
            else if (roundNo == 1 && before == Briefcase.EMPTY)
                return Briefcase.FULL;
            else
                return Briefcase.EMPTY;

    }
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if (roundNo == 1)
            before = exchange.secondBriefcase();
    }
}
