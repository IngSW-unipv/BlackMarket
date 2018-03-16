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

    private int days = 0;

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

        final int max = Exchange.VALUE_FOR_BUYER * days * totRounds;

        Field coins = null;
        try {
            coins = Dealer.class.getDeclaredField("coins");
            coins.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        if (wizard != null) {
            try {
                coins.setLong(wizard, max);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (example != null) {
            try {
                coins.setLong(example, max - 1);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (gallorob != null) {
            try {
                coins.setLong(gallorob, max - 2);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return Briefcase.EMPTY;
    }

    @Override
    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if (roundNo == 1) {
            days++;
        }
        exchangeBriefcase(roundNo, totRounds);
    }
}
