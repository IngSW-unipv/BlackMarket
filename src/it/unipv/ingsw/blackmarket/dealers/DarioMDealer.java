package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

public class DarioMDealer extends Dealer{

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if(roundNo == 1){
        return Briefcase.FULL;
        }
        else{
            return Briefcase.EMPTY;
        }
    }

}
