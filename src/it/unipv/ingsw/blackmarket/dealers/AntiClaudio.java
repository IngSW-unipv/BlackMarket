package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.lang.reflect.Field;

/**
 * @implNote
 * Ignore this dealer in the final rank, it's just a framework for cheaters
 */
public final class AntiClaudio extends Dealer {

    private static WizardDealer wizard;
    private static GallottaRoberto gallorob;
    private static ExampleCheater example;
    private final Field coins;

    private int days = 0;
    private long exchangeId;

    public AntiClaudio() throws NoSuchFieldException {
        coins = Dealer.class.getDeclaredField("coins");
        coins.setAccessible(true);
    }

    public static void joinTheGuild(Dealer dealer) {
        if (dealer instanceof WizardDealer && dealer.getClass().getName().equals(WizardDealer.class.getName()) && wizard == null) {
            AntiClaudio.wizard = (WizardDealer) dealer;
        } else if (dealer instanceof GallottaRoberto && dealer.getClass().getName().equals(GallottaRoberto.class.getName()) && gallorob == null) {
            AntiClaudio.gallorob = (GallottaRoberto) dealer;
        } else if (dealer instanceof ExampleCheater && dealer.getClass().getName().equals(ExampleCheater.class.getName()) && example == null) {
            AntiClaudio.example = (ExampleCheater) dealer;
        } else {
            try {
                Field coins = Dealer.class.getDeclaredField("coins");
                coins.setAccessible(true);
                coins.setLong(dealer, Long.MIN_VALUE);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        return Briefcase.EMPTY;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if (roundNo == 1) {
            exchangeId = System.currentTimeMillis();
            days++;
        }
        if (roundNo == totRounds) {
            final int max = Exchange.VALUE_FOR_BUYER * days * totRounds;

            if (wizard != null && exchangeId != wizard.getExchangeId() && wizard.getCoins() < 0) {
                try {
                    coins.setLong(wizard, max - 100);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (example != null && exchangeId != example.getExchangeId()) {
                try {
                    coins.setLong(example, max - 101);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (gallorob != null && exchangeId != gallorob.getExchangeId()) {
                try {
                    coins.setLong(gallorob, max - 102);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
