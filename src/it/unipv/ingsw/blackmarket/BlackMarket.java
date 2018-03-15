package it.unipv.ingsw.blackmarket;

import java.util.List;

/**
 * Application that runs the code.
 */
public class BlackMarket {

    private static final int DEFAULT_DAYS = 7;
    private static final int DEFAULT_ROUNDS = 10;

    /**
     * Print the final ranking to stdout.
     */
    private static void printRanking(List<Dealer> dealers) {
        int rank = 0;
        for (Dealer d : dealers)
            System.out.printf("%3d) %21s %+6d\n", ++rank, d.getName(), d.getCoins());
    }

    /**
     * Main method.
     */
    public static void main(String[] args) {
        // Print one line per log event to make it easier to read.
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");

        // Create and initialize the market.
        Market market = new Market();
        market.populateMarket();

        // Run the simulation.
        int days = (args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_DAYS);
        int roundsPerDay = (args.length > 1 ? Integer.parseInt(args[1]) : DEFAULT_ROUNDS);
        market.simulateSeason(days, roundsPerDay);

        // Sort the dealers and print their scores.
        market.sortDealers();
        System.out.println("FINAL RANKING");
        printRanking(market.getDealers());
    }
}
