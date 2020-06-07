import java.math.*;

public class Persoon {
    private int BSN;
    private String voorNaam;
    private String achterNaam;
    private Datum geboorteDatum;
    private char geslacht;
    private Dienblad dienblad;
    private Betaalwijze betaalwijze;

    /**
     * Constructor
     * @param BSN Het burgerservicenummer van de persoon
     * @param voorNaam De voornaam van de persoon
     * @param achterNaam de achternaam van de persoon
     * @param geslacht Het geslacht van de persoon als karakter 'M' of 'V'
     * @param dag Geboortedag van de persoon
     * @param maand Geboortemaand van de persoon
     * @param jaar Geboortejaar van de persoon
     */

    public Persoon(int BSN, String voorNaam, String achterNaam, char geslacht, int dag, int maand, int jaar) {
        this.BSN = BSN;
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.geboorteDatum = new Datum(dag, maand, jaar);
        if (geslacht == 'M' || geslacht == 'V') {
            this.geslacht = geslacht;
        } else {
            this.geslacht = 'O';
        }
    }

    public Persoon() {
        BSN = 0;
        voorNaam = "";
        achterNaam = "";
        geboorteDatum = new Datum();
        geslacht = 'O';
    }

    //Betalen
    //@param bedrag wat betaald moet worden
    public boolean betaal(BigDecimal tebetalen){
         return betaalwijze.betaal(tebetalen.setScale(2, RoundingMode.HALF_UP));    
    }

    //Get betaalwijze
    public Betaalwijze getBetaalwijze() {
        return this.betaalwijze;
    }

    //Set betaalwijze
    //@ param Pinpas of Contant
    public void setBetaalwijze(Betaalwijze betaalwijze) {
        this.betaalwijze = betaalwijze;
    }

    /**
     * Setter voor het burgerservicenummer
     * @param BSN Het burgerservicenummer van de persoon
     */
    public void setBSN(int BSN) {
        this.BSN = BSN;
    }

    /**
     * Setter voor de voornaam
     * @param voorNaam De voornaam van de persoon
     */
    public void setVoorNaam(String voorNaam) {
        this.voorNaam = voorNaam;
    }

    /**
     * Setter voor de achternaam
     * @param achterNaam De achternaam van de persoon
     */
    public void setAchterNaam(String achterNaam) {
        this.achterNaam = achterNaam;
    }

    /**
     * Setter voor de geboortedatum
     * @param geboorteDatum De geboortedatum van de persoon
     */
    public void setGeboorteDatum(Datum geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    /**
     * Setter voor het geslacht, deze controleert of het juist ingevuld is, zo niet, dan wordt er een 'O' voor onbekend ingevuld
     * @param geslacht Het geslacht van de persoon
     */
    public void setGeslacht(char geslacht) {
        if (geslacht == 'M' || geslacht == 'V') {
            this.geslacht = geslacht;
        } else {
            System.out.println("Dit is onjuist, gebruik 'M' of 'V' Er is nu 'O' voor onbekend ingevuld");
            this.geslacht = 'O';
        }
    }

    /**
     * Getter voor het burgerservicenummer
     * @return Het burgerservicenummer van de persoon
     */
    public int getBSN() {
        return BSN;
    }

    /**
     * Getter voor de voornaam
     * @return De voornaam van de persoon
     */
    public String getVoorNaam() {
        return voorNaam;
    }

    /**
     * Getter voor de achternaam
     * @return De achternaam van de persoon
     */
    public String getAchterNaam() {
        return achterNaam;
    }

    /**
     * Getter voor de geboortedatum
     * @return De geboortedatum van de persoon
     */
    public String getGeboorteDatum() {
        if (geboorteDatum.getDag() == 0) {
            return "Onbekend";
        } else {
            return geboorteDatum.getDatumAsString();
        }
    }

    /**
     * Getter voor het geslacht
     * @return Het geslacht van de persoon
     */
    public String getGeslacht() {
        if (geslacht == 'M') {
            return "Man";
        } else if (geslacht == 'V') {
            return "Vrouw";
        } else {
            return "Onbekend";
        }
    }

    public void setDienblad(Dienblad dienblad){
        this.dienblad = dienblad;
    }

    /**
     * toString methode voor output
     * @return BSN, voornaam, achternaam, geboortedatum, geslacht
     */
    public String toString(){
        return BSN + " " + voorNaam + " " + achterNaam + " " + getGeboorteDatum() + " " + getGeslacht();
    }
}


