package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class MariMarco extends Dealer {
    private Briefcase briefcase;
    private int gain=0;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        return briefcase;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {

        if (roundNo==1) {
            briefcase=Briefcase.FULL;
        }
        else {
            briefcase = Briefcase.EMPTY;
            if (roundNo < totRounds / 4 - 1) {
                gain = exchange.firstReward() - exchange.secondReward();
            }
            else {
                if (gain < 0) {
                    briefcase = exchange.secondBriefcase();
                }
                else if (gain==0) {
                    briefcase = Briefcase.EMPTY;
                }
                else {
                    briefcase = exchange.firstBriefcase();
                }

            }
        }
    }

}

