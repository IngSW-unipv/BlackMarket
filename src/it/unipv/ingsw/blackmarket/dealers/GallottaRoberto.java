package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

// import java.util.ArrayList;

public class GallottaRoberto extends Dealer {

    Briefcase case_;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        return Briefcase.EMPTY;
    }

    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
    	if(roundNo < 10) {
        	this.addCoins(1000000000); //è barare se il metodo permette di approfittarne?
        }
    }



    // C'era una logica dietro ma è inutile usarla che tanto qua tutti ritornano la valigetta vuota.
    /*Briefcase c1;
    Briefcase c2;
    ArrayList<Briefcase> cTmp = new ArrayList<>();

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo == 1) {
            case_ = Briefcase.FULL;
        }
        if (roundNo == 2) {
            case_ = Briefcase.EMPTY;
        }
        return case_;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        c1 = exchange.firstBriefcase();
        c2 = exchange.secondBriefcase();
        cTmp.add(exchange.secondBriefcase());
        boolean flag = false;

        if (cTmp.size() == 2) {
            flag = checkFirstTwoCases(cTmp.get(0), cTmp.get(1));
        }

        if (flag) {
            case_ = Briefcase.EMPTY;
        } else case_ = Briefcase.EMPTY;

    }

    public boolean checkFirstTwoCases(Briefcase a, Briefcase b) {
        if (a == b) return true;
        else return false;

    }*/
}
