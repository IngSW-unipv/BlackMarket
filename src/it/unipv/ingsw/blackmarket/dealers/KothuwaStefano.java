package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.util.Random;

public class KothuwaStefano extends Dealer {

    Briefcase case_;
    int honestcount=0,nowday=1,nowround;
    boolean notret;
    int countcheat=0;
    Boolean itsMJT=false;
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        if (roundNo == 1){
            countcheat=0;
            itsMJT=false;
            return Briefcase.FULL;}
        else
            return case_;

    }
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        int roundhlf=(totRounds/2)-1;

        if(countcheat==1){
            case_ = Briefcase.EMPTY;
        }else if(roundNo==roundhlf){
            case_=Briefcase.EMPTY;
            if(exchange.secondBriefcase().equals(Briefcase.EMPTY)){
                countcheat++;
            }
        }else if(roundNo==roundhlf+2){
            if(exchange.secondBriefcase().equals(Briefcase.EMPTY)&&countcheat<1){
                case_=Briefcase.FULL;
            }else{
                itsMJT=true;
                case_=Briefcase.EMPTY;
            }

        }else if(roundNo==totRounds-1){
            case_=Briefcase.EMPTY;
        }
        else if(itsMJT==true){
            case_=Briefcase.EMPTY;

        }else{
            case_=Briefcase.FULL;
            if(exchange.secondBriefcase().equals(Briefcase.EMPTY)&&roundNo>1){
                countcheat++;
            }


        }


    }
}
