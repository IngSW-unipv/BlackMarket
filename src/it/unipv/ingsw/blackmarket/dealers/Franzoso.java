package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class Franzoso extends Dealer {

    private Briefcase last;
    private int triFlag = 0; //0: unknown 1:T4T 2:Majority 3:Honest
    private boolean isCheating = false;


    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {


        if(roundNo == 1){
            last=null;
            triFlag=0;
            isCheating=false;
        }
        if(roundNo > 2 && roundNo < 5){
            if(last == Briefcase.EMPTY){
                isCheating = true;
            }
        }

        if(isCheating)return Briefcase.EMPTY;

        if(roundNo == 1 || roundNo == 2){       //Put two full at start
            return Briefcase.FULL;
        }else if(roundNo==3){                   //Put an empty to start suggesting opponent
            return Briefcase.EMPTY;
        }else if(roundNo==5){                   //Testing if opponent answer like T4T
            if(last == Briefcase.EMPTY){
                triFlag=1;
                return Briefcase.FULL;
            }
            return Briefcase.EMPTY;
        }else if(roundNo==7){
            if(last == Briefcase.EMPTY && triFlag!=1){
                triFlag=2;
                return Briefcase.FULL;
            }
            return Briefcase.EMPTY;
        }else if( roundNo == totRounds){        //Last round playing empty is always the best solution
            return Briefcase.EMPTY;
        }else{
            if(roundNo >=11 ){
                if(last == Briefcase.EMPTY){
                    isCheating = true;
                }
            }
            if(triFlag == 0 || triFlag == 3){   //If the opponent is unknown or is honest, play empty
                return Briefcase.EMPTY;
            }else if(triFlag==2){
                if(totRounds > 20){
                    if(roundNo<=10){
                        return Briefcase.FULL;
                    }else{
                        if(roundNo%2==1){
                            return Briefcase.EMPTY;
                        }else{
                            return Briefcase.FULL;
                        }
                    }
                }else{
                    return Briefcase.EMPTY;
                }
            }else{
                return Briefcase.FULL;
            }

        }



    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {

        last = exchange.secondBriefcase();
    }


}
