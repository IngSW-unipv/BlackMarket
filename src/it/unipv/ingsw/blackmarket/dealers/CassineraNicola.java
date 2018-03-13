package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

/**
 * Classe Dealer di
 * Cassinera Nicola (438836)
 * Confalonieri Gianantonio (437707)
 * Morini Ruggero (440228)
 * Scivola Mattia (439699)
 */

public class CassineraNicola extends Dealer {
        private int full = 0;

        @Override
        public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
            if(full == roundNo -1 && roundNo > 2)
                return Briefcase.FULL;
            else if(full == roundNo-1 && roundNo >= totRounds*(2/3))
                return Briefcase.EMPTY;
            else
                return Briefcase.EMPTY;
        }

        @Override
        public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
            if(roundNo ==1)
                full = 0;
            if (exchange.secondBriefcase() == Briefcase.FULL)
                full++;
        }



}

