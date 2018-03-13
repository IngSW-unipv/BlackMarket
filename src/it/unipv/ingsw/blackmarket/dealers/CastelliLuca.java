package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

public class CastelliLuca extends Dealer{

    /* Programmatore: Castelli Luca, numero matricola: 458670 */

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        Briefcase valigetta;

        if(roundNo < totRounds/2){
            valigetta = Briefcase.FULL;
        } else {
            valigetta = Briefcase.EMPTY;
        }

        return valigetta;
    }
}
