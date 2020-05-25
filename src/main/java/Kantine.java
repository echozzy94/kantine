import java.math.*;

/**
 * De klasse Kantine
 * 
 * @author Bryant, Enzo en Rienan
 * @version 25-5-2020
 */
public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    //opgave 5c:
    private KantineAanbod kantineAanbod;


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
     * In deze methode wordt een Dienblad gekoppeld.
     * Maakt Artikelen aan en plaats deze op het dienblad. Tenslotte sluit de Persoon zich aan bij de rij
     * voor de kassa.
     * @param dienblad object en een array met artikelnamen
     */

    public void loopPakSluitAan(Dienblad dienblad, String[] artikelnamen){
        for(int i = 0; i < artikelnamen.length; i++) {
            Artikel artikel = kantineAanbod.getArtikel(artikelnamen[i]);
            dienblad.voegToe(artikel);
        }
        kassarij.sluitAchteraan(dienblad);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (kassarij.erIsEenRij() == true) {
            kassa.rekenAf(kassarij.eerstePersoonInRij());
        }
    }

    // opgave 4b
    /**
     * De getter van de kassa
     * @return kassa 
     */
    public Kassa getKassa(){
        return kassa;
    }

    // opgave 5c
    /**
     * Dit is de setter van kantineAanbod
     * @param kantineaanbod
     */
    public void setKantineaanbod(KantineAanbod kantineAanbod){
        this.kantineAanbod = kantineAanbod;
    }

    // opgave 5c
    /**
     * Dit is de getter van kantineaanbod
     * @return kantineaanbod
     */
    public KantineAanbod getKantineAanbod(){
        return kantineAanbod;
    }


    // Week 2 opgave 4 a:
    // de methodes die voorkomen in Kassa.java en Kantine.java zijn:
    // aantalArtikelen, hoeveelheidGeldInKassa en resetKassa.
}
