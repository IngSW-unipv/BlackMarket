package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;
//import sun.invoke.empty.Empty;

/**
 * Maffoni Marco 426772
 */
public class MaffoniMarco extends Dealer {



        public Briefcase caso_nuovo;
        public Briefcase altro_caso;

        @Override
        public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
            if (roundNo==1 || roundNo==2 || roundNo==4){return Briefcase.FULL;}

            else if (roundNo==3){return Briefcase.EMPTY;}


            else if (roundNo== 5 || roundNo==7 || roundNo== 9){
                return caso_nuovo;
            }

            else if (roundNo==10){
                return Briefcase.EMPTY;
            }

            else {return altro_caso;}
        }

        public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
            if(roundNo==5 && (exchange.secondBriefcase()== Briefcase.EMPTY || exchange.firstBriefcase()== Briefcase.EMPTY)){
                caso_nuovo = Briefcase.FULL;
                altro_caso = Briefcase.FULL;

            }

            else if (roundNo==6 && exchange.firstBriefcase()== Briefcase.EMPTY && exchange.secondBriefcase()== Briefcase.EMPTY){
                caso_nuovo = Briefcase.EMPTY;
                altro_caso = Briefcase.EMPTY;
            }

            else {
                caso_nuovo= Briefcase.EMPTY;
                altro_caso = Briefcase.FULL;
            }
        }

    }

// L'unico modo per valutare contro chi sono è il seguente. Visto che i più frequenti sfidanti sono MajorityTrader e TitForTat,
// cerco di capire se è uno di loro e agisco di conseguenza. Se impongo i primi 2 round FULL e il terzo EMPTY, il Majority
// al quarto round mi mette ugualmente FULL, mentre il TitForTat mi mette EMPTY. Per cui capisco analizzando il quarto round
// chi ho davanti, e proseguo con i round successivi con la strategia migliore. Se invece sono contro un altro della lista,
// lo capisco analizzando il round 5, in quanto sia il Majority che il TitForTat mi metteranno FULL, mentre io EMPTY, quindi
// se sono contro un altro, sia il firstBriefcase che il second del quinto round sarà "settato" su EMPTY. Se ciò accade, dal
// round 6 metto tutti EMPTY.