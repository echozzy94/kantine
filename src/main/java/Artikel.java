public class Artikel {

    private String naam;
    private double prijs;

    /**
     * Constructor
     * @param naam = Naam van het artikel
     * @param prijs = Prijs van het artikel
     */

    public Artikel(String naam, double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    public Artikel() {
        naam = "";
        prijs = 0;
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
     * @param prijs
     */
    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    /**
     * Getter voor variabele prijs
     * @return prijs
     */
    public double getPrijs() {
        return prijs;
    }

    public String toString() {
        return naam + " " + prijs;
    }

}