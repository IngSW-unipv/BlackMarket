package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
/*ABDEL MOHSEN ALAA EL DIN*/
public class ABDELMOHSEN_IBRAHIM extends Dealer {
 Briefcase briefcase;
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {

        if (roundNo==1 )
        {
            return Briefcase.FULL;

    }else {
        return briefcase;
        }
    }
}
