public class KantineSimulatie{

    private Kantine kantine;
    private Kassa kassa;
    private KassaRij kassarij;

    public static final int DAGEN = 7;

    /**
     * Constructor
     */
    public KantineSimulatie() {
        kantine = new Kantine();
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * Deze methode simuleert een aantal dagen in het
     * verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {

        // herhaal voor elke dag
        for (int i = 0; i <= dagen; i++) {

            // per dag nu even vast 10 + i personen naar binnen
            // laten gaan, wordt volgende week veranderd...

            // for lus voor personen
            for (int j = 0; j <= 10 + i; j++) {
                Persoon persoon = new Persoon();
                Dienblad dienblad = new Dienblad(persoon);
                Artikel artikel1 = new Artikel("appel", "1.10");
                Artikel artikel2 = new Artikel("banaan", "1.40");
                dienblad.voegToe(artikel1);
                dienblad.voegToe(artikel2);
                kassarij.sluitAchteraan(dienblad);
            }

            // verwerk rij voor de kassa
            while (kassarij.erIsEenRij() == true){
            kassa.rekenAf(kassarij.eerstePersoonInRij());
            }
            // toon dagtotalen (artikelen en geld in kassa)
            System.out.println("Artikelen in kassa: " + kassa.aantalArtikelen());
            System.out.println("Geld in kassa: " + kassa.hoeveelheidGeldInKassa());
            // reset de kassa voor de volgende dag
            kassa.resetKassa();
        }
    }

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        int dagen;
       KantineSimulatie simulatie = new KantineSimulatie();

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }

        simulatie.simuleer(dagen);
    }
}
