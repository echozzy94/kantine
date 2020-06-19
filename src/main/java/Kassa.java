import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

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
        Iterator<Artikel> artikelen = dienblad.getIterator();
        BigDecimal klanttebetalen = new BigDecimal(0.00).setScale(2, RoundingMode.HALF_UP);
        BigDecimal klanttebetalendagaanbieding = new BigDecimal("0.00");

        while (artikelen.hasNext()) {
            Artikel artikel = artikelen.next();
            BigDecimal dagaanbiedingkorting = new BigDecimal("0.20");
            BigDecimal prijsVanArtikel = artikel.getPrijs();
            //BigDecimal klanttebetalendagaanbieding = new BigDecimal("0.00");
            if(dagaanbiedingkorting.compareTo(artikel.getArtikelkorting()) == 0) {
                BigDecimal artikelKortingsbedrag = artikel.getPrijs().multiply(dagaanbiedingkorting);
                prijsVanArtikel = artikel.getPrijs().subtract(artikelKortingsbedrag);
                klanttebetalendagaanbieding = klanttebetalendagaanbieding.add(prijsVanArtikel);
                System.out.println("Dagaanbiedingkorting");
            }
            else {
                klanttebetalen = klanttebetalen.add(artikel.getPrijs());
            }
        }
            if (dienblad.getKlant() instanceof KortingskaartHouder) {
                BigDecimal kortingsbedrag = klanttebetalen.multiply(((KortingskaartHouder)dienblad.getKlant()).geefKortingsPercentage().setScale(2, RoundingMode.HALF_UP));
                if(((KortingskaartHouder)dienblad.getKlant()).heeftMaximum() == true && kortingsbedrag.compareTo(((KortingskaartHouder)dienblad.getKlant()).geefMaximum()) == 1) {
                    kortingsbedrag = ((KortingskaartHouder)dienblad.getKlant()).geefMaximum();
               }
               klanttebetalen = klanttebetalen.subtract(kortingsbedrag).setScale(2, RoundingMode.HALF_UP);
               klanttebetalen = klanttebetalen.add(klanttebetalendagaanbieding).setScale(2, RoundingMode.HALF_UP);
            }
        
    
            try {
                dienblad.getKlant().betaal(klanttebetalen);
                kassaTotaal = kassaTotaal.add(klanttebetalen);
                gepasseerdeArtikelen++;
                
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
