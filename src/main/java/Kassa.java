import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Kassa {

    private KassaRij kassa;
    private BigDecimal kassaTotaal = new BigDecimal("0.00").setScale(2, RoundingMode.HALF_UP);
    private int gepasseerdeArtikelen = 0;
    

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        this.kassa = kassarij;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de
     * controletotalen die voor de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param dienblad Is het dienblad van de klant die moet afrekenen
     */

    public void rekenAf(Dienblad dienblad) {
            try {
                Factuur f = new Factuur(dienblad, LocalDate.now());
                dienblad.getKlant().betaal(f.getTotaal());
                kassaTotaal = kassaTotaal.add(f.getTotaal());
                gepasseerdeArtikelen = f.getGepasseerdeArtikelen();
                
            } catch (TeWeinigGeldException e) {
                System.out.println(dienblad.getKlant().toString() + " " + e.getErrorMelding());
            }

        }
    

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment
     * dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return gepasseerdeArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass zijn gepasseerd, vanaf
     * het moment dat de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public BigDecimal hoeveelheidGeldInKassa() {
        return kassaTotaal;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en de totale
     * hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        kassaTotaal = new BigDecimal("0.00").setScale(2, RoundingMode.HALF_UP);
        gepasseerdeArtikelen = 0;
    }
}
