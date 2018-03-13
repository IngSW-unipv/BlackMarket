package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.*;

public class CastelliLuca extends Dealer{

    /* Programmatore: Castelli Luca, numero matricola: 458670 */

    Briefcase valigetta = Briefcase.FULL;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if(roundNo > totRounds/2){
            valigetta = Briefcase.EMPTY;
        }
        return valigetta;
    }

    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {

    }
}
