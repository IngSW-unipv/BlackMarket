package it.unipv.ingsw.blackmarket.dealers;
import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class NegriRoberto extends Dealer {



    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
       if((roundNo<2)&&(roundNo%2==1)){
           return Briefcase.FULL;
       }
       else {
           return Briefcase.EMPTY;
       }
    }

    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {

    }


}
