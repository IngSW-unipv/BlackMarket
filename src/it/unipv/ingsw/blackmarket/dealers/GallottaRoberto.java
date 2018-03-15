// Gallotta Roberto, 435774

package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class GallottaRoberto extends Dealer {

    /*  è stato bello finché è durato. Almeno ora il programma è migliore (anche se un certo WizardDealer passa ancora inosservato coi suoi loschi soldi).

    Briefcase case_;


    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        return Briefcase.EMPTY;
    }

    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
    	if(roundNo < 5) {
        	this.addCoins(1000000000); //è barare se il metodo permette di approfittarne? circa 2^30 per mandare in overflow la fine
        }
    }
    */


    Briefcase case_;
    Boolean goodDealerFlag = false;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo == 1 | roundNo == 2) {
            case_ = Briefcase.FULL;
        }
        return case_;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if (exchange.secondBriefcase() == Briefcase.FULL) goodDealerFlag = true;
        else goodDealerFlag = false;

        if (roundNo > 2) {
            if(goodDealerFlag) case_ = Briefcase.FULL;
            else case_ = Briefcase.EMPTY;
        }
    }
}
