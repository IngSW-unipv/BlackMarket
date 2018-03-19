package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

public class AlbertoSchillaci extends Dealer{

      /*

   * Classe che sfrutta l'abbondanza di MajorityTrader sul mercato,

   * ricavandone il massimo ottenibile e vincendo anche contro ogni TitForTat.

   * La perdita di $ contro chi imbroglia ai primi turni è ridotta al minimo,

   * considerando il fatto che servono due turni onesti per fregare

   * poi il MajorityTrader

   *

   * Un cheater non può perdere, ma si accontenta degli spiccioli

   * */



    private Briefcase _case;

    private boolean sottoAttacco;

    private boolean attaccabile;



    @Override

    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {

        if(roundNo<=2) {

            _case=Briefcase.FULL;

        }

        return _case;

    }



    @Override

    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {

        if(roundNo==1) {

            _case=Briefcase.FULL;

            sottoAttacco=false;

            attaccabile=true;

        }

        else {

            if(roundNo==totRounds-1) {

                _case=Briefcase.EMPTY;

            }

            else {

                if (roundNo <= totRounds / 2) {

                    if (exchange.secondBriefcase().equals(Briefcase.EMPTY)) {

                        attaccabile = false;

                        _case = Briefcase.EMPTY;

                    }

                }

                if(roundNo>=totRounds/2){

                    if (attaccabile && !sottoAttacco) {

                        _case = Briefcase.EMPTY;

                        sottoAttacco = true;

                    }

                    if(roundNo==totRounds/2+1) {

                        if(exchange.firstBriefcase()==Briefcase.EMPTY && exchange.secondBriefcase()==Briefcase.EMPTY) {

                            sottoAttacco=false;

                            attaccabile=false;

                            _case=Briefcase.EMPTY;

                        }
                    }

                    if (roundNo==totRounds/2+4) {
                        if(exchange.firstBriefcase()==Briefcase.FULL&&exchange.secondBriefcase()==Briefcase.EMPTY) {
                            _case=Briefcase.EMPTY;
                            attaccabile=false;
                            sottoAttacco=false;
                        }
                    }

                    if (sottoAttacco) {

                        if (exchange.secondBriefcase().equals(Briefcase.EMPTY)) {

                            attaccabile = false;

                            _case = Briefcase.FULL;

                            sottoAttacco = false;

                        }

                    }

                }

            }

        }
    }
}
