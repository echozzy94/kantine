import java.math.BigDecimal;
public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    //opgave 5c:
    private KantineAanbod kantineaanbod;


    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt en aan elkaar gekoppeld. Maak twee
     * Artikelen aan en plaats deze op het dienblad. Tenslotte sluit de Persoon zich aan bij de rij
     * voor de kassa.
     */
    /*
    public void loopPakSluitAan(Persoon persoon, Dienblad dienblad, Artikel artikel1, Artikel artikel2) {
        persoon = new Persoon();
        dienblad = new Dienblad(persoon);
        artikel1 = new Artikel();
        artikel2 = new Artikel();
        dienblad.voegToe(artikel1);
        dienblad.voegToe(artikel2);
        kassarij.sluitAchteraan(dienblad);
    } 
    */

    /**
     * In deze methode wordt een dienblad met artikelen in de kassarij geplaatst
     * 
     * @param dienblad
     * @param artikelnamen
     */
    public void loopPakSluitAan(Dienblad dienblad, String[] artikelnamen){
        
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (kassarij.erIsEenRij() == true) {
            kassarij.eerstePersoonInRij();
        }
    }

    // opgave 4b
    public Kassa getKassa(){
        return kassa;
    }

    // opgave 5c
    public void setKantineaanbod(KantineAanbod kantineaanbod){
        this.kantineaanbod = kantineaanbod;
    }

    // opgave 5c
    public KantineAanbod getKantineaanbod(){
        return this.kantineaanbod;
    }

    /**
     * Deze methode telt het geld uit de kassa
     *
     * @return hoeveelheid geld in kassa
     */
//    public BigDecimal hoeveelheidGeldInKassa() {
//       return kassa.hoeveelheidGeldInKassa();
//    }

    /**
     * Deze methode geeft het aantal gepasseerde artikelen.
     *
     * @return het aantal gepasseerde artikelen
     */
//    public int aantalArtikelen() {
//        return kassa.aantalArtikelen();
//    }

    /**
     * Deze methode reset de bijgehouden telling van het aantal artikelen en "leegt" de inhoud van
     * de kassa.
     */
//    public void resetKassa() {
//        kassa.resetKassa();
//    }

    // Week 2 opgave 4 a:
    // de methodes die voorkomen in Kassa.java en Kantine.java zijn:
    // aantalArtikelen en hoeveelheidGeldInKassa.
}
