package it.unipv.ingsw.blackmarket;

import java.util.List;

public abstract class Dealer {
    private int balance = 0;

    public final String getName() {
        return this.getClass().getSimpleName();
    }

    public final int getBalance() {
        return balance;
    }

    public final void addToBalance(int amount) {
        balance += amount;
    }

    abstract public Briefcase exchangeBriefcase(List<Briefcase> history, int rounds);
}
