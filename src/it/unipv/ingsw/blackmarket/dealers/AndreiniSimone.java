package it.unipv.ingsw.blackmarket.dealers;
//Simone Andreini mat 436740

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.lang.reflect.Field;

import static it.unipv.ingsw.blackmarket.Briefcase.EMPTY;
import static it.unipv.ingsw.blackmarket.Briefcase.FULL;

public class AndreiniSimone extends Dealer{
    private Briefcase recivedCase;
    private boolean onest =true;
    private int forgive=0;

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        return scelta(roundNo,totRounds);
    }

    private Briefcase scelta(int roundNo, int totRounds) {
        if(roundNo==1){
            onest =true; //#il primo turno do possibilità di essere onesti a tutti
            forgive=0;
            return Briefcase.FULL;
        }

        if (roundNo<totRounds && onest){
            return Briefcase.FULL;
        }

        if (roundNo==totRounds){
            return Briefcase.EMPTY;
        }

        else return Briefcase.EMPTY;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        recivedCase = exchange.secondBriefcase();
        if (recivedCase==EMPTY){
            onest =false;
            forgive=0;
        }
        if (recivedCase==FULL){
            forgive++;
            if (forgive>1){
                onest=true;
            }
        }
    }
}
