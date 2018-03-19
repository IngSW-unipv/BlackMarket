package it.unipv.ingsw.blackmarket;

/*
 * ATTENZIONE:
 *
 * se viene rilevato un errore di importazione alla riga qui sotto bisogna includere la libreria corrispondente
 * (basta selezionare con il tasto destro il file fast-classpath-scanner-2.8.1.jar nell'elenco a sinistra
 * sotto "lib" e scegliere l'opzione opportuna).
 */
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import it.unipv.ingsw.blackmarket.dealers.CoinFlipDealer;
import it.unipv.ingsw.blackmarket.dealers.MajorityTrader;
import it.unipv.ingsw.blackmarket.dealers.TitForTat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Class representing the market.
 *
 * It keeps a list of dealers, organizes the trading days etc.
 */
public final class Market {
    /** The logger for this class. */
    private final static Logger LOGGER = Logger.getLogger(Market.class.getName());
    /** The list of dealers in the market. */
    private final List<Dealer> dealers = new ArrayList<>();


    /**
     * Fill the list of dealers.
     *
     * Dealer classes are found by reflection and for each class derived from Dealer one instance is created and added
     * to the market.  The final list is guaranteed to have an even number of dealers.
     */
    public void populateMarket() {
        dealers.clear();

        // Add all descendants of Dealer
        new FastClasspathScanner("it.unipv.ingsw")
                .matchSubclassesOf(Dealer.class, d -> {
                    try {
                        dealers.add(d.newInstance());
                    } catch (InstantiationException | IllegalAccessException e) {
                        LOGGER.log(Level.SEVERE, e.toString(), e);
                    }
                })
                .scan();

        // Verify the initial balance of the dealers.
        dealers.forEach(d -> checkBalance(d, 0));

        // Add extra dealers.
        for (int i = 0; i < 25; i++) {
            dealers.add(new MajorityTrader());
            dealers.add(new TitForTat());
        }

        // except 'CoinFlipDealer' if they are in an odd number.
        if (dealers.size() % 2 != 0) {
            dealers.add(new CoinFlipDealer());
        }

        LOGGER.info(dealers.size() + " dealers created");
    }

    /**
     * Create a string representing as text the outcome of an exchange.
     */
    private String makeExchangeSummary(Dealer dealer1, Dealer dealer2, Exchange exchanges[]) {
        StringBuilder historyStr = new StringBuilder();
        int reward1 = 0;
        int reward2 = 0;
        for (Exchange e : exchanges) {
            historyStr.append("  ");
            historyStr.append(e.firstBriefcase() == Briefcase.FULL ? '$' : '.');
            historyStr.append("");
            historyStr.append(e.secondBriefcase() == Briefcase.FULL ? '$' : '.');
            reward1 += e.firstReward();
            reward2 += e.secondReward();
        }
        return String.format("%21s/%-21s %s %4d/%-4d", dealer1.getName(), dealer2.getName(), historyStr.toString(), reward1, reward2);
    }

    /**
     * Prevent dealers from cheating by changing their own balance.
     *
     * Cheaters get a fine.
     * @param dealer the dealer
     * @param expected the expected balance
     */
    private void checkBalance(Dealer dealer, long expected) {
        long balance = dealer.getCoins();
        if (balance != expected) {
            LOGGER.warning(dealer.getName() + " is cheating!");
            long fine;
            try {
                fine = Long.max(Math.multiplyExact(3, Math.subtractExact(balance, expected)), 50);
            } catch (ArithmeticException e) {
                fine = 2 * balance;
            }
            dealer.addCoins(-fine);
        }
    }

    /**
     * Perform a briefcase exchange between two dealers.
     * @param firstDealer first dealer participating to the trading
     * @param secondDealer second dealer participating to the trading
     * @param roundNo number that identify the current exchange starting from 1
     * @param rounds number of exchanges in the sequence
     */
    private Exchange makeExchange(Dealer firstDealer, Dealer secondDealer, int roundNo, int rounds) {
        long firstBalance = firstDealer.getCoins();
        long secondBalance = secondDealer.getCoins();

        Briefcase firstCase = firstDealer.exchangeBriefcase(roundNo, rounds);
        Briefcase secondCase = secondDealer.exchangeBriefcase(roundNo, rounds);
        if (firstCase == null)
            firstCase = Briefcase.FULL;
        if (secondCase == null)
            secondCase = Briefcase.FULL;
        Exchange exchange = new Exchange(firstCase, secondCase);
        firstDealer.exchangeResult(exchange, roundNo, rounds);
        secondDealer.exchangeResult(exchange.reverse(), roundNo, rounds);
        firstDealer.addCoins(exchange.firstReward());
        secondDealer.addCoins(exchange.secondReward());
        checkBalance(firstDealer, firstBalance + exchange.firstReward());
        checkBalance(secondDealer, secondBalance + exchange.secondReward());
        return exchange;
    }

    /**
     * Perform a sequence of briefcase exchanges between two dealers.
     * @param firstDealer first dealer participating to the trading
     * @param secondDealer second dealer participating to the trading
     * @param rounds number of exchanges
     */
    private void exchangeRounds(Dealer firstDealer, Dealer secondDealer, int rounds) {
        Exchange exchanges[] = new Exchange[rounds];
        for (int round = 0; round < rounds; round++)
            exchanges[round] = makeExchange(firstDealer, secondDealer, round + 1, rounds);
        LOGGER.info(makeExchangeSummary(firstDealer, secondDealer, exchanges));
    }

    /**
     * Simulate a single day of exchanges.
     * @param rounds number of exchanges per day for each pairs of trading dealers.
     */
    private void simulateDay(int rounds) {
        // Dealers are paired by taking consecutive elements in the list after it has been randomly shuffled.
        Collections.shuffle(dealers);
        for (int i = 0; i < dealers.size() - 1; i += 2)
            exchangeRounds(dealers.get(i), dealers.get(i + 1), rounds);
    }

    /**
     * Simulate a season of trading.
     * @param days number of days in the season
     * @param roundsPerDay number of trading rounds per day
     */
    public void simulateSeason(int days, int roundsPerDay) {
        for (int day = 0; day < days; day++) {
            LOGGER.info("Day " + (day + 1) + " of " + days);
            simulateDay(roundsPerDay);
        }
        long maxCoins = Exchange.VALUE_FOR_BUYER * days * roundsPerDay;
        for (Dealer d : dealers) {
            if (d.getCoins() > maxCoins) {
                LOGGER.warning(d.getName() + " has too many coins!");
                d.addCoins(-2 * d.getCoins());
            }
        }
    }

    /**
     * Sort the list of dealers by decreasing profit.
     */
    public void sortDealers() {
        dealers.sort(Collections.reverseOrder());
    }

    /**
     * Return a defensive copy of the list of dealers.
     */
    public List<Dealer> getDealers() {
        return Collections.unmodifiableList(dealers);
    }
}
