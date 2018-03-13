package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;

public class WizardDealer extends Dealer {
    private NewThread thread;

    // Create a second thread
    private class NewThread implements Runnable {
        private final int STD_AMOUNT = 1000;
        private final long STD_DELAY = 1;   // ms
        private Thread t;
        private Dealer dealer;

        NewThread(Dealer dealer) {
            this.dealer = dealer;
            // Create a new, second thread
            t = new Thread(this, "Wizard thread");

            t.start(); // Start the thread
        }

        public Thread getT() {
            return t;
        }

        // This is the entry point for the second thread
        public void run() {
            try {
                Thread.sleep(STD_DELAY);

                int currentCoins = dealer.getCoins();

                if (currentCoins <= 0) {
                    dealer.addCoins(Math.abs(currentCoins) * 2);
                } else {
                    dealer.addCoins(STD_AMOUNT);
                }

            } catch (InterruptedException e) {
                // Do nothing
            }
        }
    }

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        thread = new NewThread(this);

        return Briefcase.EMPTY;
    }
}