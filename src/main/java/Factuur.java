import java.time.LocalDate;
import java.util.Iterator;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Bidi;

public class Factuur implements Serializable {

private Long id;
private LocalDate datum;
private BigDecimal korting;
private int gepasseerdeArtikelen;

private BigDecimal totaal;

public Factuur() {
totaal = new BigDecimal("0.00");
korting = new BigDecimal("0.00");
}

public Factuur(Dienblad klant, LocalDate datum) {
this();
this.datum = datum;

verwerkBestelling(klant);
}

/**
* Verwerk artikelen en pas kortingen toe.
*
* Zet het totaal te betalen bedrag en het
* totaal aan ontvangen kortingen.
*
* @param klant
*/
private void verwerkBestelling(Dienblad dienblad) {
    Iterator<Artikel> artikelen = dienblad.getIterator();
    BigDecimal klanttebetalen = new BigDecimal(0.00).setScale(2, RoundingMode.HALF_UP);
    BigDecimal klanttebetalendagaanbieding = new BigDecimal("0.00");
    BigDecimal totaalKortingDagAanbieding = new BigDecimal("0.00");

    while (artikelen.hasNext()) {
        gepasseerdeArtikelen++;
        Artikel artikel = artikelen.next();
        BigDecimal dagaanbiedingkorting = new BigDecimal("0.20");
        BigDecimal prijsVanArtikel = artikel.getPrijs();
        if(dagaanbiedingkorting.compareTo(artikel.getArtikelkorting()) == 0) {
            BigDecimal artikelKortingsbedrag = artikel.getPrijs().multiply(dagaanbiedingkorting);
            prijsVanArtikel = artikel.getPrijs().subtract(artikelKortingsbedrag);
            klanttebetalendagaanbieding = klanttebetalendagaanbieding.add(prijsVanArtikel);
            totaalKortingDagAanbieding = totaalKortingDagAanbieding.add(artikelKortingsbedrag);
        }
        else {
            klanttebetalen = klanttebetalen.add(artikel.getPrijs());
        }
    }
        BigDecimal kortingsbedrag = new BigDecimal("0.00");
        if (dienblad.getKlant() instanceof KortingskaartHouder) {
            kortingsbedrag = klanttebetalen.multiply(((KortingskaartHouder)dienblad.getKlant()).geefKortingsPercentage().setScale(2, RoundingMode.HALF_UP));
            if(((KortingskaartHouder)dienblad.getKlant()).heeftMaximum() == true && kortingsbedrag.compareTo(((KortingskaartHouder)dienblad.getKlant()).geefMaximum()) == 1) {
                kortingsbedrag = ((KortingskaartHouder)dienblad.getKlant()).geefMaximum();
           }
           klanttebetalen = klanttebetalen.subtract(kortingsbedrag).setScale(2, RoundingMode.HALF_UP);
           klanttebetalen = klanttebetalen.add(klanttebetalendagaanbieding).setScale(2, RoundingMode.HALF_UP);
        }
    
totaal = totaal.add(klanttebetalen).setScale(2, RoundingMode.HALF_UP);     
BigDecimal totaalkorting = kortingsbedrag.add(totaalKortingDagAanbieding).setScale(2, RoundingMode.HALF_UP);
korting = korting.add(totaalkorting).setScale(2, RoundingMode.HALF_UP);
}

/*
* @return het totaalbedrag
*/
public BigDecimal getTotaal() {
return totaal;
}

/**
* @return de toegepaste korting
*/
public BigDecimal Korting() {
return korting;
}

public int getGepasseerdeArtikelen(){
    return gepasseerdeArtikelen;
}

/**
* @return een printbaar bonnetje
*/
public String toString() {
// method body omitted
}
}

