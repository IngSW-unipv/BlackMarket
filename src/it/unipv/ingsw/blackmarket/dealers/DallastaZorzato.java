// Dall'Asta Simonetta      (matricola 434524)
// Zorzato Riccardo         (matricola 435597)

package it.unipv.ingsw.blackmarket.dealers;
import it.unipv.ingsw.blackmarket.*;

/**
 * Foe legend:
 * 1 - Honest          2 - Cheater
 * 3 - TitForTat       4 - Majority
 * 0 - Undefined
 */

public final class DallastaZorzato extends Dealer {
    private int foe;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        Briefcase bcase;

        if (roundNo == 1)
            foe = -1;

        // No alle mafie, sì alla logica!
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
                if (roundNo > (totRounds/2) + 1) bcase = Briefcase.EMPTY;
                else bcase = Briefcase.FULL;
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
                if (got.equals(e))
                    foe = -2;   // not honest
                break;
            case 2:
                if (foe == -2 && got.equals(e))  // not t4t or majority
                    foe = 2;    // cheater
                else if (foe != -2 && got.equals(e))  // not a standard dealer
                    foe = 0;
                else if (got.equals(f))
                    foe = -3;   // let's trust him for another turn
                break;
            case 3:
                if (foe == -3 && got.equals(f))  // t4t, majority or honest
                    foe = 1;    // let's give him an empty one and see what happens
                else if (foe == -3 && got.equals(e))  // didn't expect an empty one there
                    foe = 0;   // not to be trusted
                break;
            case 4:
                if (foe == 1 && got.equals(e))  // tit4tat
                    foe = 3;
                else if (foe == 1 && got.equals(f))  // honest or majority
                    foe = 4;
            default:
                break;
        }
    }
}
