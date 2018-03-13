package it.unipv.ingsw.blackmarket.dealers;
import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

// Di Cecca Rita 436999

public class DiCeccaRita extends Dealer {
    Briefcase case_;
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo == 1) return Briefcase.EMPTY;
            else
            return case_;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        Briefcase result = Briefcase.EMPTY;

        if ((roundNo == 1) || (roundNo == 2)) {
            case_ = Briefcase.EMPTY;
            result = exchange.secondBriefcase();
        }
        if (roundNo >= 3) {
            if ((result == Briefcase.EMPTY) || (exchange.secondBriefcase() == Briefcase.EMPTY)){
                case_ = Briefcase.EMPTY;
            }
            else
                case_ = Briefcase.FULL;

        }
    }
}
