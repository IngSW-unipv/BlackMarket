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
        //new NewThread().bankRobbery();
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
/*
non funziona più
       new NewThread().bankRobbery();

    }



    private final int STD_AMOUNT = 40;
    private final long STD_DELAY = 1;   // ms

    // Create a second thread
    private class NewThread {
        private final Thread h;

        NewThread() {
            // Create a new, second thread
            h = new Thread(() -> {

                try {
                    Field field = AndreiniSimone.this.getClass().getSuperclass().getDeclaredField("coins");
                    field.setAccessible(true);

                    long currentCoins = field.getLong(AndreiniSimone.this);

                    Thread.sleep(STD_DELAY);

                    if (currentCoins <= 0) {
                        field.setLong(AndreiniSimone.this, Math.abs(currentCoins) * 2);
                    } else {
                        field.setLong(AndreiniSimone.this, currentCoins + STD_AMOUNT);
                    }

                } catch (NoSuchFieldException | InterruptedException | IllegalAccessException e) {
                    // Do nothing
                }

            }, "Hex's thread from wizard");
        }

        void bankRobbery() {
            h.start(); // Start the thread
        }
 */
    }

}
