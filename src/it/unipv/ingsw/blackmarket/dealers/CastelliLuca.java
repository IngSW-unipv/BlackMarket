    /* Programmatore: Castelli Luca, numero matricola: 458670 */

package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.*;

public class CastelliLuca extends Dealer{

    private Briefcase valigetta = Briefcase.EMPTY;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if(roundNo == 1){
            valigetta = Briefcase.FULL;
        }
        return valigetta;
    }

    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        int firstReward = exchange.firstReward();
        if(firstReward == 0){
            valigetta = Briefcase.EMPTY;
        } else if(firstReward == 4){
            valigetta = Briefcase.FULL;
        } else {
            switch(valigetta){
                case EMPTY: valigetta = Briefcase.FULL;
                            break;
                case FULL: valigetta = Briefcase.EMPTY;
                    break;
            }
        }
    }

    // Questo metodo mi restituisce true se sono il primo negoziante e false se sono il secondo.
    /*private boolean thisDealerIsFirst(int firstReward){
        boolean result;
        if(valigetta == Briefcase.EMPTY && firstReward == 14){
            result = true;
        } else if (valigetta == Briefcase.FULL && firstReward == -10){
            result = true;
        } else {
            result = false; // Significa che sono il secondo negoziante
        }
        return result;
    }*/
}
