package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.*;

public class FaustoCapelli extends Dealer {
    private Briefcase last;
    private boolean maj, notCheat;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo <= 2)
            return Briefcase.FULL;
        if (roundNo < totRounds / 2 + 1)
            return last;
        if (roundNo == totRounds / 2 + 1 || roundNo == totRounds / 2 + 2)
            return Briefcase.EMPTY;
        if (roundNo == totRounds / 2 + 3) {
            if (last.equals(Briefcase.FULL)) {
                maj = true;
                return Briefcase.EMPTY;
            } else {
                maj = false;
                if (notCheat)
                    return Briefcase.FULL;
                else
                    return Briefcase.EMPTY;
            }
        }
        if (roundNo < totRounds - 1) {
            if (notCheat && !maj)
                return Briefcase.FULL;
            else
                return Briefcase.EMPTY;
        }
        return Briefcase.EMPTY;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if (roundNo == 1)
            notCheat = false;
        if (exchange.secondBriefcase().equals(Briefcase.FULL)) {
            last = Briefcase.FULL;
            if (roundNo == 2)
                notCheat = true;
        } else
            last = Briefcase.EMPTY;
    }
}