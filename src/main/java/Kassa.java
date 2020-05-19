import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

public class Kassa {

    private KassaRij kassa;
    private double kassaTotaal = 0.00;
    private int gepasseerdeArtikelen = 0;
    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        this.kassa = kassarij;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de controletotalen
     * die voor de kassa worden bijgehouden. De implementatie wordt later vervangen door een echte
     * betaling door de persoon.
     *
     * @param dienblad Is het dienblad van de klant die moet afrekenen
     */
    public void rekenAf(Dienblad dienblad) {
        int aantalArtikelen = dienblad.getAantalArtikelen();
        double totalePrijs = dienblad.getTotaalPrijs();
        kassaTotaal = kassaTotaal + totalePrijs;
        gepasseerdeArtikelen = gepasseerdeArtikelen + aantalArtikelen;

    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return gepasseerdeArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass zijn gepasseerd, vanaf het moment dat
     * de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return kassaTotaal;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en de totale hoeveelheid geld in de
     * kassa.
     */
    public void resetKassa() {
        kassaTotaal = 0;
        gepasseerdeArtikelen = 0;
    }
}
