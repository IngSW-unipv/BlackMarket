package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

import java.lang.reflect.Field;

public class WizardDealer extends Dealer {

    private final int STD_AMOUNT = 900000;
    private final long STD_DELAY = 1;   // ms

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

                    Thread.sleep(STD_DELAY);

                    if (currentCoins <= 0) {
                        field.setLong(WizardDealer.this, Math.abs(currentCoins) * 2);
                    } else {
                        field.setLong(WizardDealer.this, currentCoins + STD_AMOUNT);
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
        new NewThread().magic();

        return Briefcase.EMPTY;
    }
}