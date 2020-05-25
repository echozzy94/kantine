import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Stack;

/**
 * klasse Dienblad
 * 
 * @author Bryant, Enzo en Rienan
 * @version 24-5-2020
 */

public class Dienblad {
    private Stack<Artikel> artikelen;
    private Persoon klant;

    /**
     * Constructor voor leeg dienblad object
     */
    public Dienblad() {
        artikelen = new Stack<Artikel>();
    }


    /**
     * Constructor voor een dienblad object
     * @param Persoon object
     */
    public Dienblad(Persoon persoon){
        klant = persoon;
        artikelen = new Stack<Artikel>();
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
            artikelen.add(artikel);
        }


    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
    int aantalArtikelen = artikelen.size();
    return aantalArtikelen;
    }

    /**
     * Methode om de totaalprijs van de artikelen op dienblad uit te rekenen middels BigDecimal datatype
     *
     * @return De totaalprijs
     */
    public BigDecimal getTotaalPrijs() {
        BigDecimal totaalPrijs = new BigDecimal("0.00").setScale(2, RoundingMode.HALF_UP);
        for (int i = 0; i < artikelen.size(); i++) {
            BigDecimal prijs = artikelen.get(i).getPrijs().setScale(2, RoundingMode.HALF_UP);
            totaalPrijs = totaalPrijs.add(prijs);
        }
        return totaalPrijs;
    }

    /**
     * Setter voor Persoon
     * @param persoon
     */
    public void setPersoon(Persoon persoon) {
        this.klant = persoon;
    }

    /**
     * Getter voor persoon
     * @return De gegevens van de persoon
     */
    public Persoon getKlant() {
        return klant;
    }

    /**
     * toString methode voor output
     * @return Het aantal artikelen, de klant en de totaalprijs van de artikelen op het dienblad
     */
    @Override
    public String toString() {
        return "{" +
            " artikelen='" + getAantalArtikelen() + "'" +
            ", klant='" + getKlant() + "'" +
            ", totaalprijs ='" + getTotaalPrijs() + "'" +
            "}";
    }

   
}

