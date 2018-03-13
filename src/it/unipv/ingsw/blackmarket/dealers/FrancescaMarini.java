package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

import java.util.Random;

public class FrancescaMarini extends Dealer {

    private Random randomGenerator= new Random();
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if(roundNo==1){
            return (randomGenerator.nextBoolean() ? Briefcase.FULL : Briefcase.EMPTY);
        } else return Briefcase.EMPTY;
    }
}
