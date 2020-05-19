import java.util.ArrayList;

public class Dienblad {
    private ArrayList<Artikel> artikelen;
    private Persoon klant;
    /**
     * Constructor
     */
    public Dienblad() {
        artikelen = new ArrayList<Artikel>();
    }



    public Dienblad(Persoon persoon){
        klant = persoon;
        artikelen = new ArrayList<Artikel>();
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
     * Methode om de totaalprijs van de artikelen op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        double totaalPrijs = 0.00;
        for (int i = 0; i < artikelen.size(); i++) {
            double prijs = artikelen.get(i).getPrijs();
            totaalPrijs = totaalPrijs + prijs;
        }
        return totaalPrijs;
    }

    public void setPersoon(Persoon persoon) {
        this.klant = persoon;
    }


    public Persoon getKlant() {
        return klant;
    }

    @Override
    public String toString() {
        return "{" +
            " artikelen='" + getAantalArtikelen() + "'" +
            ", klant='" + getKlant() + "'" +
            ", totaalprijs ='" + getTotaalPrijs() + "'" +
            "}";
    }

   
}

