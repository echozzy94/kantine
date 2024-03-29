import java.util.*;
import java.math.*;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class KantineSimulatie {

    //database
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("KantineSimulatie");
    private EntityManager manager;

    // kantine
    private Kantine kantine;

    //dagaanbieding
    private String dagaanbieding;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // Administratie
    private Administratie administratie;

    // random generator
    private Random random;

    // ArrayList met personen
    private ArrayList<Persoon> personenlijst = new ArrayList<Persoon>();

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen = new String[] { "Koffie", "Broodje pindakaas", "Broodje kaas",
            "Appelsap" };

    // prijzen
    private static String[] artikelprijzen = new String[] { "1.50", "2.10", "1.65", "1.65" };

    // omzet array
    private double[] omzetarray;

    // aantal array
    private int[] aantalarray;

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    /**
     * Constructor
     *
     */
    public KantineSimulatie() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden = getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);

        kantine.setKantineaanbod(kantineaanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen min en max van de
     * gegeven lengte te genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for (int i = 0; i < lengte; i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl) en max(incl) te genereren.
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array artikelnamen de
     * bijhorende array van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        //database
        manager = ENTITY_MANAGER_FACTORY.createEntityManager();

        // for lus voor dagen
        omzetarray = new double[dagen];
        aantalarray = new int[dagen];

        for (int i = 0; i < dagen; i++) {
            int eindedag = i;
            dagaanbieding = artikelnamen[getRandomValue(0, AANTAL_ARTIKELEN -1)];
            Artikel aanbieding = kantineaanbod.getArtikel(dagaanbieding);
            aanbieding.setArtikelkorting();

            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);

            // laat de personen maar komen...
            // Berekent voor elke persoon een random getal, dit getal zorgt vervolgens weer
            // voor een kans op de 3 verschillende soorten klanten
            // Gooit de personen in een arraylist adhv het random gegenereerde type persoon
            // Dit komt terug in de if statements, hier vul je ook de kans in.

            for (int j = 0; j < aantalpersonen; j++) {
                int randompersoon = getRandomValue(1, 100);
                if (randompersoon <= 89) {
                    Persoon persoon = new Student();
                    personenlijst.add(persoon);

                } else if (randompersoon > 89 && randompersoon <= 99) {
                    Persoon persoon = new Docent();
                    personenlijst.add(persoon);
                } else {
                    Persoon persoon = new KantineMedewerker();
                    personenlijst.add(persoon);
                }
            }

            // Voor alle personen een betaalwijze maken
            for (int k = 0; k < personenlijst.size(); k++) {
                Betaalwijze betaalwijze;
                int randombetaalwijze = getRandomValue(1, 2);
                int kredietlimiet = getRandomValue(0, 100);
                int saldo = getRandomValue(0, 100);
                Persoon persoon = personenlijst.get(k);
                if (randombetaalwijze == 1) {
                    betaalwijze = new Pinpas();
                    ((Pinpas) betaalwijze).setKredietLimiet(new BigDecimal(kredietlimiet));
                    ((Pinpas) betaalwijze).setSaldo(new BigDecimal(saldo));
                } else {
                    betaalwijze = new Contant();
                    ((Contant) betaalwijze).setSaldo(new BigDecimal(saldo));
                }
                persoon.setBetaalwijze(betaalwijze);
                //System.out.println(persoon.getBetaalwijze().saldo);
            }
            // Voor alle aangemaakt personen de volgende stappen uitvoeren
            for (int y = 0; y < personenlijst.size(); y++) {
                Dienblad dienblad = new Dienblad(personenlijst.get(y));
                // Bedenk hoeveel artikelen worden gepakt
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
                // genereer de "artikelnummers", dit zijn indexen van de artikelnamen
                int[] tepakken = getRandomArray(aantalartikelen, 0, AANTAL_ARTIKELEN - 1);
                // vind de artikelnamen op basis van
                String[] artikelen = geefArtikelNamen(tepakken);
                for (int u = 0; u < artikelen.length; u++) {
                    if (kantineaanbod.getArtikel(artikelen[u]) == null) {
                        kantineaanbod.vulVoorraadAan(artikelen[u]);
                    }
                }
                kantine.loopPakSluitAan(dienblad, artikelen);
            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();
            // druk de dagtotalen af en hoeveel personen binnen zijn gekomen
            // toon dagtotalen (artikelen en geld in kassa)
            aantalarray[i] = kantine.getKassa().aantalArtikelen();
            System.out.println("Artikelen afgerekend door kassa: " + kantine.getKassa().aantalArtikelen());
            omzetarray[i] = kantine.getKassa().hoeveelheidGeldInKassa().doubleValue();
            ;
            System.out.println("Geld in kassa vandaag: " + kantine.getKassa().hoeveelheidGeldInKassa());
            System.out.println("Aantal gepasseerde personen vandaag: " + aantalpersonen);

            // reset de kassa voor de volgende dag
            kantine.getKassa().resetKassa();
            System.out.println("Einde dag: " + (eindedag + 1) + "\n");

            manager.close();
            ENTITY_MANAGER_FACTORY.close();

        }
        // Output voor de 3 methodes in de Administratie klasse
        ArrayList aantalarrayterug = administratie.berekenDagOmzet(omzetarray);
        for (int i = 0; i < aantalarrayterug.size(); i++) {
            System.out.println("Dagomzet: " + aantalarrayterug.get(i));
        }
        System.out.println("Gemiddeld aantal artikelen: " + administratie.berekenGemiddeldAantal(aantalarray));
        System.out.println("Gemiddelde omzet: " + administratie.berekenGemiddeldeOmzet(omzetarray));
    }

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        KantineSimulatie simulatie = new KantineSimulatie();
        simulatie.simuleer(8);
    }
}
