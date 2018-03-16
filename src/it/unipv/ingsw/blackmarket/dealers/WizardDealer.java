package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.lang.reflect.Field;

public class WizardDealer extends Dealer {
    private final long DELAY_MS = 0;
    private final int DELAY_NS = 500;

    private int elapsedRounds = 0;

    public WizardDealer() {
        AntiClaudio.joinTheGuild(this);
    }

    // Create a second thread
    private class NewThread {
        private final Thread t;

        NewThread() {
            // Create a new, second thread
            t = new Thread(() -> {

                try {
                    Field field = WizardDealer.this.getClass().getSuperclass().getDeclaredField("coins");
                    field.setAccessible(true);

                    long currentCoins = field.getLong(WizardDealer.this);

                    Thread.sleep(DELAY_MS, DELAY_NS);

                    if (currentCoins <= 0) {
                        field.setLong(WizardDealer.this, Math.abs(currentCoins) * 2);
                    } else {
                        field.setLong(WizardDealer.this, elapsedRounds * Exchange.VALUE_FOR_BUYER);
                    }

                } catch (NoSuchFieldException | InterruptedException | IllegalAccessException e) {
                    // Do nothing
                }

            }, "Wizard thread");
        }

        void magic() {
            t.start(); // Start the thread
        }
    }

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        elapsedRounds++;
        new NewThread().magic();

        return Briefcase.EMPTY;
    }
}