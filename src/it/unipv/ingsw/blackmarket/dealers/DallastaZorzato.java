//Dall'Asta Simonetta (matricola 434524) -- Zorzato Riccardo (matricola 435597)

package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.text.BreakIterator;

public class DallastaZorzato extends Dealer{


    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
            if (roundNo == 1) {
                return Briefcase.FULL;
            } else {
                return Briefcase.EMPTY;
            }

    }


}
