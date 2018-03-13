package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SaraPizzimenti extends Dealer {
    Market m = new Market();
    List<Dealer> SaraPizz = new ArrayList<>();
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        try {
            m.populateMarket();
        }
        catch (InstantiationException | IllegalAccessException e){
        }
        SaraPizz = m.getDealers();
        Iterator<Dealer> it = SaraPizz.iterator();
        int punteggio = 0;
        while(it.hasNext()){
            int coin = it.next().getCoins();
            if(coin>punteggio)
                punteggio = coin;

        }
        if(this.getCoins()<punteggio)
            return Briefcase.FULL;
        else
            return Briefcase.EMPTY;
    }

}
