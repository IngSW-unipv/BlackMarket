package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

public class GrilloEdda extends Dealer{
    //Grillo Edda 402085



    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {


            if (getCoins() >= 10) {

                return Briefcase.EMPTY;
            } else {
                return Briefcase.FULL;
            }

    }
}
