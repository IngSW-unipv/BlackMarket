
package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

import java.lang.reflect.Field;

/**
 * @implNote
 * Ignore this dealer in the final rank, it's just a framework for cheaters
 */
public final class AntiWizard extends Dealer {
    private static CaroloNicolas nico;
    private final Field coins;

    private int days = 0;
    private long exchangeId;

    public AntiWizard() throws NoSuchFieldException {
        coins = Dealer.class.getDeclaredField("coins");
        coins.setAccessible(true);
    }

    public static void fightTheWizard(Dealer dealer) {
        if (dealer instanceof CaroloNicolas && dealer.getClass().getName().equals(CaroloNicolas.class.getName()) && nico == null) {
            AntiWizard.nico = (CaroloNicolas) dealer;
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

            if (nico != null) {
                try {
                    coins.setLong(nico, max - 100);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}