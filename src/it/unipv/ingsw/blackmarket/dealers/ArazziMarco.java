package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;
import it.unipv.ingsw.blackmarket.Market;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public final class ArazziMarco extends Dealer {

    Briefcase case_;
    Boolean Mt = false;
    int TfT = 0;
    boolean cheater = false;

    Exchange ex = new Exchange(Briefcase.FULL,Briefcase.FULL);





    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {

        if(roundNo ==1 ){
            Mt=false;
            TfT=0;
            cheater=false;
            return case_=Briefcase.FULL;
        }
        if(cheater){
            return Briefcase.EMPTY;
        }
        if(roundNo == 2){
            return case_=Briefcase.FULL;
        }
        if(roundNo ==3 ){
            return case_=Briefcase.EMPTY;
        }
        if(TfT >= 2){
            if(roundNo==totRounds){
                TfT = 0;
                return Briefcase.EMPTY;

            }
            else {
                return Briefcase.FULL;
            }
        }




        if(Mt){
            if(roundNo>(totRounds/2)+1){
                if(roundNo==totRounds){
                    Mt = false;
                    TfT = 0;
                }

                return Briefcase.EMPTY;
            }
            else{
                return Briefcase.FULL;
            }
        }



        return Briefcase.EMPTY;


    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {


        if(roundNo == 2 ){

            if(exchange.secondBriefcase() == Briefcase.FULL){
                Mt=true;
                cheater = false;
            }
            else if(exchange.secondBriefcase()== Briefcase.EMPTY){
                cheater = true;
                TfT = 0;
            }


        }

        if(roundNo == 3 ){

            if(exchange.secondBriefcase()== Briefcase.FULL){
                TfT++;
            }
            else{
                cheater=true;
            }


        }

        if(roundNo == 4 ){

            if(exchange.secondBriefcase()== Briefcase.EMPTY){
                TfT++;
            }


        }

        if(roundNo == 5){
            if(exchange.secondBriefcase()== Briefcase.EMPTY){
                cheater = true;
            }
        }




    }




}

