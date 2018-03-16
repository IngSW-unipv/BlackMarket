//Goretti Matteo
// matricola: 438952

package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.util.ArrayList;
import java.util.Random;

public class GorettiMatteo extends Dealer{

  //  private boolean honest, cheater;              METTERE RICERCA PER GIOCATORI HONEST CHEATER ECC
    private ArrayList<Briefcase> bags;
    private Briefcase briefcase;
    private double trust;
    private Random randomGenerator = new Random();

    public GorettiMatteo() {
        this.bags = new ArrayList<Briefcase>();
        this.briefcase = Briefcase.EMPTY;
        this.trust = 0.5;
    }

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {

        if (roundNo == 1) {
            bags.clear();           //a ogni nuovo dealer inizializzo strategia
            trust = 0.5;
            //return (randomGenerator.nextBoolean() ? Briefcase.FULL : Briefcase.EMPTY);
            return Briefcase.FULL;
        }else if((roundNo==3) || roundNo == totRounds){
            return Briefcase.EMPTY;
        }
        else {
            return briefcase;
        }
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        Briefcase bag = exchange.secondBriefcase();
        bags.add(bag);

        if(bag == Briefcase.EMPTY){
            trust -= 0.17;
        }else{
            trust += 0.1;
        }
        if(trust>=0.5) briefcase = Briefcase.FULL;
        else briefcase = Briefcase.EMPTY;

    }
}