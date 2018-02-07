package it.unipv.ingsw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Market {
    public static final int VALUE_FOR_BUYER = 13;
    public static final int VALUE_FOR_SELLER = 10;

    private List<Dealer> dealers = new ArrayList<>();

    public void populateMarket() {
        dealers = new ArrayList<>();
        dealers.add(new HonestTrader());
        dealers.add(new HonestTrader());
        dealers.add(new Cheater());
        if (dealers.size() % 2 == 1)
            dealers.add(new CoinFlipDealer());
    }

    private void exchange(Dealer firstDealer, Dealer secondDealer, int rounds) {
        List<Suitcase> firstHistory = new ArrayList<>();
        List<Suitcase> secondHistory = new ArrayList<>();
        for (int round = 0; round < rounds; round++) {
            Suitcase firstSuitcase = firstDealer.exchangeSuitcase(secondHistory, rounds);
            Suitcase secondSuitcase = secondDealer.exchangeSuitcase(firstHistory, rounds);

            if (firstSuitcase == Suitcase.FULL && secondSuitcase == Suitcase.FULL) {
                firstDealer.addToBalance(VALUE_FOR_BUYER - VALUE_FOR_SELLER);
                secondDealer.addToBalance(VALUE_FOR_BUYER - VALUE_FOR_SELLER);
            } else if (firstSuitcase == Suitcase.FULL && secondSuitcase == Suitcase.EMPTY) {
                firstDealer.addToBalance(-VALUE_FOR_SELLER);
                secondDealer.addToBalance(VALUE_FOR_BUYER);
            } else if (firstSuitcase == Suitcase.EMPTY && secondSuitcase == Suitcase.FULL) {
                firstDealer.addToBalance(VALUE_FOR_BUYER);
                secondDealer.addToBalance(-VALUE_FOR_SELLER);
            }

            firstHistory.add(secondSuitcase);
            secondHistory.add(firstSuitcase);
        }
    }

    private void simulateDay(int rounds) {
        Collections.shuffle(dealers);
        for (int i = 0; i < dealers.size() - 1; i += 2)
            exchange(dealers.get(i), dealers.get(i + 1), rounds);
    }

    public void simulateSeason(int days, int roundsPerDay) {
        for (int day = 0; day < days; day++)
            simulateDay(roundsPerDay);
    }

    public void sortDealers() {
        dealers.sort((dealer1, dealer2) -> (dealer2.getBalance() - dealer1.getBalance()));
    }

    public List<Dealer> getDealers() {
        return dealers;
    }
}
