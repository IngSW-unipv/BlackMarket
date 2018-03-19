package it.unipv.ingsw.blackmarket.dealers;
import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.util.ArrayList;

/**
 * BARBERA CHIARA MATRICOLA 435693
 *
 */
public class BarberaChiara extends Dealer{
    private int countFull , countEmpty ;
    private Briefcase firstOpponent, case_, lastBriefcase;
    private ArrayList<Briefcase> avversario , CHEATALERT, TitForTatALERT ;
    private boolean isCheater  , isHonest , isTitForTat, isMajority, modified = false ;
    public BarberaChiara() {
        this.countFull = 0;
        countEmpty = 0 ;
        avversario = new ArrayList<>();
        CHEATALERT = new ArrayList<>(3);
        TitForTatALERT = new ArrayList<>(3);
        for (int i=0 ; i<3 ; i++)
            CHEATALERT.add(Briefcase.EMPTY );
        TitForTatALERT.add(Briefcase.FULL);
        TitForTatALERT.add(Briefcase.FULL);
        TitForTatALERT.add(Briefcase.EMPTY);
    }
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        /** FULL in the first and second round */
        if (roundNo <= 2 ) {
            return Briefcase.FULL;
        }
        /**   Special case: Hp : roundNo > 1 :
         If the other dealer plays FULL once and then just EMPTY,
         then it's better to play EMPTY from the second round on .
         */
        if (roundNo > 1) {
            if (firstOpponent == Briefcase.FULL && (avversario.containsAll(CHEATALERT) || countFull == 1)  ){
                case_ = Briefcase.EMPTY;
                modified = true ;
            }
        }
        /** If the situation is different from the one above (modified == false ), then it will alternate EMPTY and FULL
         *  in order to gain more points with a MajorityTrader ;
         *  If the other dealer is Cheater or Honest, then it's better to play EMPTY ;
         *  If the other dealer is TitForTat , then it's better to play FULL  */
        if (roundNo > 2 && !modified) {
            if (avversario.containsAll(CHEATALERT) || isCheater || isHonest){
                case_ = Briefcase.EMPTY;
                modified = true ;
            }
            if ((avversario.containsAll(TitForTatALERT)&& lastBriefcase== Briefcase.EMPTY && !modified ) ) {
                case_ = Briefcase.FULL ;
                modified = true ;
                isTitForTat = true ;
            }
            if (isTitForTat && !modified) {
                case_ = Briefcase.FULL;
                modified = true ;
            }
            if (roundNo % 2 == 0 && !modified) {
                case_ = Briefcase.FULL;
                modified = true;
                isMajority = true ;
            } else if (roundNo > 2 && roundNo % 2 != 0 && !modified) {
                case_ = Briefcase.EMPTY;
                modified = true;
                isMajority = true ;
            }
        }
        // In the last round, the Briefcase is always EMPTY
        if ( roundNo == totRounds){
            return Briefcase.EMPTY;
        }
        return case_ ;
    }
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if (roundNo == 1)
            firstOpponent = exchange.secondBriefcase() ;
        /** number of EMPTY and FULL Briefcases */
        countBriefcase(exchange.secondBriefcase());
        /** The arraylist avversario keeps the cases played by the other dealer ; lastBriefcase is the
         briefcase this dealer used in the last round played.
         */
        avversario.add(exchange.secondBriefcase());
        lastBriefcase = exchange.firstBriefcase();
        /** Verifies if is honest or is cheater */
        checkHonestCheater(roundNo);
        /** reset control values at the end of the day */
        if (roundNo == totRounds)
            reset();
        modified = false ;
    }
    private void reset(){
        countFull = 0;
        countEmpty = 0;
        isCheater = false ;
        isHonest = false ;
        isTitForTat = false ;
        isMajority = false ;
    }
    private void checkHonestCheater( int roundNo ){
        if ( countFull == roundNo && roundNo > 2)
            isHonest = true ;
        else
            isHonest = false ;
        if ( countEmpty == roundNo && roundNo > 2)
            isCheater = true ;
        else
            isCheater = false ;
    }
    private void countBriefcase(Briefcase briefcase){
        if (briefcase == Briefcase.EMPTY)
            countEmpty ++ ;
        else if (briefcase == Briefcase.FULL)
            countFull++;
    }
}