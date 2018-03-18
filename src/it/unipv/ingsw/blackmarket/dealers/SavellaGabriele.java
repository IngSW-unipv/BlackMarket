package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class SavellaGabriele extends Dealer{
    private Briefcase giocata;



    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        /*se è il primo round presuppongo che tu mi dia una valigetta piena,
         se non è così non vado comunque in perdita perchè do la valigetta vuota
          */
        if (roundNo == 1 )
            return Briefcase.EMPTY;
        else
            return giocata;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {



        if (roundNo == 1) {
            giocata = Briefcase.FULL;

        }

        if (roundNo == 2) {
            giocata = Briefcase.EMPTY;

        }


        if (roundNo > 2 && roundNo <= totRounds) {

            giocata = Briefcase.EMPTY;
        }

    }
}



