package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class Zoncada extends Dealer{

    private Briefcase last;
    private boolean flagMajority;
    private boolean flagCheater;

    public Zoncada(){
        super();
        flagMajority=false;
        flagCheater=false;
    }

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if(roundNo == 1 || roundNo == 2){
            return Briefcase.FULL;
        }else if (roundNo<totRounds/2){
            return last;
        }else {
            if(roundNo==(totRounds/2)+1){
                if(last == Briefcase.EMPTY){
                    flagCheater=true;
                }
                return Briefcase.EMPTY;
            }else if(roundNo==(totRounds/2)+3){
                if(last==Briefcase.FULL) flagMajority=true;
                return Briefcase.FULL;
            }
            else{
                if(flagMajority || flagCheater) return Briefcase.EMPTY;
                else return Briefcase.FULL;
            }
        }
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        last = exchange.secondBriefcase();
    }
}
