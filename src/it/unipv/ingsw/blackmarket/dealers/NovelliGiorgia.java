package it.unipv.ingsw.blackmarket.dealers;

//Novelli Giorgia 430088

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

public class NovelliGiorgia extends Dealer {

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if(roundNo==1){
            return Briefcase.FULL;
        }
        return Briefcase.EMPTY;
    }
}
