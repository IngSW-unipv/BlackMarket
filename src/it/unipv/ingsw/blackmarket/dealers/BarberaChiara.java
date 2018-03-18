package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;
import it.unipv.ingsw.blackmarket.Market;
import javafx.scene.effect.Reflection;

import java.lang.reflect.Constructor;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Random;

/*BARBERA CHIARA MATRICOLA 435693*/

public class BarberaChiara extends Dealer{

    private int countFull , countEmpty ;
    private Briefcase firstOpponent, case_;
    private ArrayList<Briefcase> avversario , CHEATALERT ;
    private boolean isCheater  , isHonest , modified = false ;

    public BarberaChiara() {

        this.countFull = 0;
        countEmpty = 0 ;
        firstOpponent = null ;
        case_ = null ;
        isHonest = false ;
        isCheater = false ;
        avversario = new ArrayList<>();
        CHEATALERT = new ArrayList<>(3);

        for (int i=0 ; i<3 ; i++)
            CHEATALERT.add(Briefcase.EMPTY );

    }

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {

        // Ai primi due round gioco sempre FULL

        if (roundNo < 2 ) {
            return Briefcase.FULL;
        }

        /* HP : roundNo > 1 :
              Se avversario gioca FULL e poi solo EMPTY, allora dal secondo round in poi gioco solo EMPTY
              Se l'avversario è un cheater o un Honest, conviene giocare sempre empty
        */

        if (roundNo > 1) {

            if (firstOpponent == Briefcase.FULL && (avversario.containsAll(CHEATALERT) || countFull == 1)  ){
                case_ = Briefcase.EMPTY;
                modified = true ;
            }

            if (avversario.containsAll(CHEATALERT) || isHonest || isCheater ){
                case_ = Briefcase.EMPTY;
                modified = true ;
            }


        }

        // Se non ricado nei casi precedenti (modified == false ) alterno Empty e FULL in modo da massimizzare il guadagno
        // con un MajorityTrader

        if ( roundNo >= 2 && roundNo % 2 == 0 && ! modified ) {
            case_ = Briefcase.FULL;
            modified = true ;
        }else if (roundNo > 2 && roundNo % 2 != 0 && ! modified) {
            case_ = Briefcase.EMPTY;
            modified = true ;
        }


        // Empty sempre all'ultimo round

        if ( roundNo == totRounds){
            return Briefcase.EMPTY;
        }


        return case_ ;




    }

    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {


        if (roundNo == 1)
            firstOpponent = exchange.secondBriefcase() ;

        // conto Empty e Full

        if (exchange.secondBriefcase() == Briefcase.EMPTY)
            countEmpty ++ ;
        else if (exchange.secondBriefcase() == Briefcase.FULL)
            countFull++;

        avversario.add(exchange.secondBriefcase());

        // Verifica di honest e chater

        if ( countEmpty == roundNo )
            isCheater = true ;
        else
            isCheater = false ;

        if ( countFull == roundNo )
            isHonest = true ;
        else
            isHonest = false ;

        // reset dei count e dei boolean a fine giornata

        if (roundNo == totRounds) {
            countFull = 0;
            countEmpty = 0;
            isCheater = false ;
            isHonest = false ;

        }

        modified = false ;



    }


}
