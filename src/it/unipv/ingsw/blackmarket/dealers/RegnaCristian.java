package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

import java.util.Random;

/*  Nome: Cristian Cognome: Regna
*   Numero di matricola: 439009
*   Strategia basata sul perdere al primo turno per dare un'ottima impressione, poi disonesto in modo tale da
*   vincere contro il firstimpressionDealer
* */

public class RegnaCristian extends Dealer {

    private Random randomGenerator = new Random();

    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo == 1)
            return Briefcase.FULL;
        else
            return Briefcase.EMPTY;
    }
}
