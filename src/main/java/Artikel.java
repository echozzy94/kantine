import java.math.BigDecimal;
import java.math.RoundingMode;

public class Artikel {

    private String naam;
    private BigDecimal prijs;
    private BigDecimal artikelkorting;

    public BigDecimal getArtikelkorting() {
        return this.artikelkorting;
    }

    public void setArtikelkorting(String artikelkorting) {
        this.artikelkorting = new BigDecimal(artikelkorting).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Constructor
     * @param naam = Naam van het artikel
     * @param prijs = Prijs van het artikel in String datatype welke word opgeslagen in BigDecimal object
     */

    public Artikel(String naam, String prijs, String artikelkorting) {
        this.naam = naam;
        this.prijs = new BigDecimal(prijs).setScale(2, RoundingMode.HALF_UP);
        if (artikelkorting.isEmpty() == true){
            this.artikelkorting = new BigDecimal("0.00").setScale(2, RoundingMode.HALF_UP);
        } else {
        this.artikelkorting = new BigDecimal(artikelkorting).setScale(2, RoundingMode.HALF_UP);
        }
    }

    public Artikel(String naam, String prijs) {
        this.naam = naam;
        this.prijs = new BigDecimal(prijs).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Constructor voor een leeg artikel object
     */
    public Artikel() {
        naam = "";
        prijs = new BigDecimal("0.00").setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Setter voor variabele naam
     * @param naam = Naam van het artikel
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * Getter voor variabele naam
     * @return naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Setter voor variabele prijs
     * @param prijs in string formaat
     */
    public void setPrijs(String prijs) {
        this.prijs = new BigDecimal(prijs).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Getter voor variabele prijs
     * @return prijs
     */
    public BigDecimal getPrijs() {
        return prijs;
    }

    /**
     * toString methode voor output
     * @return naam van artikel gevolg door spatie en prijs van artikel
     */
    public String toString() {
        return naam + " " + this.getPrijs();
    }

}