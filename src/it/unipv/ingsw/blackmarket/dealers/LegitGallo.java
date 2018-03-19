/**
 * GALLOTTA ROBERTO, 435774
  */

package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

/**
 * Un dealer che non bara nel caso a Cusano non piacciano le alleanze (o quantomeno barare nei termini fissati)
 * Ovviamente questo dealer va considerato solo e soltanto se il dealer GallottaRoberto venga espulso.
 */

public final class LegitGallo extends Dealer {

    private Briefcase case_;
    private int otherDealer = -1;
    private boolean reliableDealer = false;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {

        // Primi due round sono per capire con chi ho a che fare
        if(roundNo == 1) {
            case_ = Briefcase.FULL;
        }
        // Massimizzo il guadagno rifilando sempre una valigetta vuota all'ultimo
        if(roundNo == totRounds) {
            case_ = Briefcase.EMPTY;
        }

        // case-switch per applicare logica di gioco
        /**
         * 0:   Non riconosciuto (altro giocatore), Cheater, CoinFlipDealer
         * 1:   TitForTat
         * 2:   FirstImpressionDealer, HonestTrader
         * 3:   MajorityTrader
         */
        if(roundNo > 1 && roundNo < totRounds) {
            switch (otherDealer) {
                case 0:
                    case_ = Briefcase.EMPTY;
                    break;
                case 1:
                    case_ = Briefcase.FULL;
                    break;
                case 2:
                    case_ = Briefcase.EMPTY;
                    break;
                case 3:
                    if (roundNo > totRounds / 2 + 1) case_ = Briefcase.EMPTY;
                    else case_ = Briefcase.FULL;
                    break;
                default:
                    case_ = Briefcase.FULL;
                    break;
            }
        }

        return case_;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        //  Analizzo l'avversario dal secondo turno fino a generici n
        if (roundNo > 1) {
            switch (roundNo) {
                case 2:
                    if (exchange.secondBriefcase().equals(Briefcase.FULL)) otherDealer = 1;
                    else otherDealer = 0;
                    break;
                case 3:
                    if (exchange.secondBriefcase().equals(Briefcase.EMPTY)) otherDealer = 0;
                    else otherDealer = -1; // Verifico che non sia Honest o Majority
                    break;
                case 4:
                    if (exchange.secondBriefcase().equals(Briefcase.EMPTY)) otherDealer = 0;
                    else otherDealer = 2;
                    break;
                case 5:
                    if (exchange.secondBriefcase().equals(Briefcase.FULL)) otherDealer = -1; // Ulteriore verifica per il Majority
                    else otherDealer = 0;
                    break;
                case 6:
                    if (exchange.secondBriefcase().equals(Briefcase.EMPTY)) otherDealer = 3;
                    else otherDealer = 0;
                    break;
                default:
                    break;
            }
        }
    }

}
