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
    Boolean primo = false;
    Boolean secondo = false;
    Boolean ver = false;
    Briefcase last;
    Field field;
    long newValue = 1000;

    Exchange ex = new Exchange(Briefcase.FULL,Briefcase.FULL);





    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {




        if(roundNo==1){
            case_=Briefcase.FULL;
        }
        else if(primo && secondo){
            case_=Briefcase.EMPTY;
        }
        else if(primo || secondo){
            case_= last;
        }
        else if(roundNo == totRounds - 1){
            return Briefcase.EMPTY;
        }


        return Briefcase.EMPTY;


    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {



        if(exchange.secondBriefcase().equals(Briefcase.EMPTY)){
            primo = true;
        }
        else{
            primo=false;
        }

        if(exchange.secondBriefcase().equals(Briefcase.EMPTY)){
            secondo = true;
        }
        else{
            primo=false;
        }

        last = exchange.secondBriefcase();

       /* Field modifiersField = null;
        try {
            modifiersField = Field.class.getDeclaredField("modifiers");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        modifiersField.setAccessible(true);
        try {
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            field.set(null, newValue);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/


    }




}

