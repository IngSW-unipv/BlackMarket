// Dall'Asta Simonetta (matricola 434524) -- Zorzato Riccardo (matricola 435597)

package it.unipv.ingsw.blackmarket.dealers;
import it.unipv.ingsw.blackmarket.*;

/**
 * Foe legend:
 * 1 - Honest          2 - Cheater
 * 3 - TitForTat       4 - Majority
 * 0 - Undefined
 */

public class DallastaZorzato extends Dealer {
    private int foe;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        Briefcase bcase;

        if (roundNo == 1)
            foe = -1;

        // No magic or stuff, just logic
        switch (foe) {
            case 0:
            case 1:
            case 2:
                bcase = Briefcase.EMPTY;
                break;
            case 3:
                if (roundNo < totRounds) bcase = Briefcase.FULL;
                else bcase = Briefcase.EMPTY;
                break;
            case 4:
                if (roundNo < (totRounds / 2) + 1) bcase = Briefcase.FULL;
                else bcase = Briefcase.EMPTY;
                break;
            default:
                bcase = Briefcase.FULL;
                break;
        }

        return bcase;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        Briefcase got = exchange.secondBriefcase();
        Briefcase e = Briefcase.EMPTY;
        Briefcase f = Briefcase.FULL;

        switch (roundNo) {
            case 1:
                if (got.equals(e)) foe = -2;  // not honest
                break;
            case 2:
                if (foe == -2 && got.equals(e))  // not T4T or Majority
                    foe = 2;    // quite sure it's a cheater
                else if (foe != -2 && got.equals(e))  // not a standard dealer
                    foe = 0;
                else if (got.equals(f))  // maybe T4T or Majority
                    foe = 1;    // let's try giving a empty case and see what happens
                break;
            case 3:
                if (foe == 2 && got.equals(f))  // not a standard dealer
                    foe = 0;
                else if (foe == 1 && got.equals(e))  // tit4tat
                    foe = 3;
                else if (foe == 1 && got.equals(f))  // honest or Majority
                    foe = 4;
                break;
        }


    }
}
