/**
 * GALLOTTA ROBERTO, 435774
  */


package it.unipv.ingsw.blackmarket.dealers;

import it.unipv.ingsw.blackmarket.Briefcase;
import it.unipv.ingsw.blackmarket.Dealer;
import it.unipv.ingsw.blackmarket.Exchange;

/**
 * Dealer puramente baro. Inizialmente sfruttava l'overflow della fine per massimizzare i guadagni, ma MuffinOverlord ha detto no.
 * Per evitare faide interne è stata stretta un'alleanza vantaggiosa per entrambi (si può vedere come un piccolo oligopolio o come governo elitario).
 * Se a Cusano la cosa fa torcere il naso, si dimentichi questo dealer e si consideri invece il dealer LegitGallo.
 */

public final class GallottaRoberto extends Dealer {

    /* è stato bello finché è durato. Almeno ora il programma è migliore.

    Briefcase case_;


    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        return Briefcase.EMPTY;
    }

    public void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
    	if(roundNo < 5) {
        	this.addCoins(1000000000); //è barare se il metodo permette di approfittarne? circa 2^30 per mandare in overflow la fine
        }
    } */

    private long exchangeId;

    public GallottaRoberto() {
        // Mutually assured destruction is never the answer.
        AntiClaudio.joinTheGuild(this);
    }

    // Metodi semplificati per evitare inutili perdite
    @Override
    public Briefcase exchangeBriefcase(int roundNo, int totRounds) {
        return Briefcase.EMPTY;
    }

    @Override
    public final void exchangeResult(Exchange exchange, int roundNo, int totRounds) {
        if (roundNo == 1) {
            exchangeId = System.currentTimeMillis();
        }
    }

    public long getExchangeId() {
        return exchangeId;
    }
}
