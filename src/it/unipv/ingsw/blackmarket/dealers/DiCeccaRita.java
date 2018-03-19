package it.unipv.ingsw.blackmarket.dealers;
import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

// Di Cecca Rita 436999

public class DiCeccaRita extends Dealer {
    Briefcase case_;
    Briefcase result = null;
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo == 1) case_ = Briefcase.FULL;
        else {
            if (roundNo > (totRounds/2))
                case_ = Briefcase.EMPTY;
        }
        return case_;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if (roundNo == 1) {
            if (exchange.secondBriefcase() == Briefcase.FULL) {
                case_ = Briefcase.FULL;
                result = exchange.secondBriefcase();
            }
            if (exchange.secondBriefcase() == Briefcase.EMPTY) {
                case_ = Briefcase.EMPTY;
                result = exchange.secondBriefcase();
            }
        }

        if (totRounds == roundNo) {
            case_ = Briefcase.EMPTY;
        }

        if ((roundNo >=2) && (roundNo < totRounds)){
            if ((result == Briefcase.EMPTY) && (exchange.secondBriefcase() == Briefcase.EMPTY)) {
                case_ = Briefcase.EMPTY;
            }
            if ((result == Briefcase.FULL) &&(exchange.secondBriefcase() == Briefcase.FULL)) {
                case_ = Briefcase.FULL;
            }
            if ((result == Briefcase.EMPTY) && (exchange.secondBriefcase() == Briefcase.FULL)) {
                case_ = Briefcase.FULL;
            }
            if ((result== Briefcase.FULL) && (exchange.secondBriefcase() == Briefcase.EMPTY)) {
                case_ = Briefcase.EMPTY;
            }
        }
    }
}
