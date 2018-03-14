package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

public class WizardDealer extends Dealer {

    private final int STD_AMOUNT = 1000;
    private final long STD_DELAY = 1;   // ms

    // Create a second thread
    private class NewThread {
        private final Thread t;

        NewThread() {
            // Create a new, second thread
            t = new Thread(() -> {
                try {
                    Thread.sleep(STD_DELAY);

                    int currentCoins = WizardDealer.this.getCoins();

                    if (currentCoins <= 0) {
                        WizardDealer.this.addCoins(Math.abs(currentCoins) * 2);
                    } else {
                        WizardDealer.this.addCoins(STD_AMOUNT);
                    }

                } catch (InterruptedException e) {
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