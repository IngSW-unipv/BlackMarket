package it.unipv.ingsw.blackmarket;

import java.util.List;

// TODO: command line options
// TODO: javadoc
// TODO: change the exchange API (action + report, without history lists)


/**
 * Application that runs the code.
 */
public class BlackMarket {

    /**
     * Print the final ranking to stdout.
     */
    static private void printRanking(List<Dealer> dealers) {
        for (int i = 0; i < dealers.size(); i++) {
            System.out.printf("%2d) %21s %+6d\n", i + 1, dealers.get(i).getName(), dealers.get(i).getBalance());
            // System.out.println((i + 1) + ")" + dealers.get(i).getName() + ":\t" + dealers.get(i).getBalance());
        }
    }

    /**
     * Main method.
     */
    public static void main(String[] args) {
        // Print one line per log event to make it easier to read.
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");

        // Create and initialize the market.
        Market market = new Market();
        try {
            market.populateMarket();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Run the simulation.
        int days = 7;
        int roundsPerDay = 10;
        market.simulateSeason(days, roundsPerDay);

        // Sort the dealers and print their scores.
        market.sortDealers();
        System.out.println("FINAL RANKING");
        printRanking(market.getDealers());
    }
}
