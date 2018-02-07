package it.unipv.ingsw;

import java.util.List;

// TODO: command line options
// TODO: introspection in populateMarket
// TODO: logging the individual rounds
// TODO: javadoc

public class BlackMarket {

    static private void printRanking(List<Dealer> dealers) {
        for (int i = 0; i < dealers.size(); i++) {
            System.out.printf("%2d) %15s %+6d\n", i + 1, dealers.get(i).getName(), dealers.get(i).getBalance());
            // System.out.println((i + 1) + ")" + dealers.get(i).getName() + ":\t" + dealers.get(i).getBalance());
        }
    }

    public static void main(String[] args) {
        Market market = new Market();
        market.populateMarket();

        int days = 8;
        int roundsPerDay = 10;

        market.simulateSeason(days, roundsPerDay);
        market.sortDealers();
        printRanking(market.getDealers());
    }
}
