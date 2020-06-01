import java.math.BigDecimal;
import java.math.RoundingMode;

public class Administratie {
private static final int DAYS_IN_WEEK = 7;

    public Administratie() {
    }

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */
    public static BigDecimal berekenGemiddeldAantal(int[] aantal) {
        BigDecimal totaal = new BigDecimal("0.00").setScale(2, RoundingMode.HALF_UP);
        BigDecimal aantalLength = new BigDecimal(aantal.length).setScale(2, RoundingMode.HALF_UP);

        if (aantal.length == 0){
            return totaal;
        } else {
            for (int i = 0; i < aantal.length; i++){
                BigDecimal waarde = new BigDecimal(aantal[i]).setScale(2, RoundingMode.HALF_UP);
                totaal = totaal.add(waarde);
            }
        }
        return (totaal.divide(aantalLength, RoundingMode.HALF_UP));
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public static BigDecimal berekenGemiddeldeOmzet(double[] omzet) {
        BigDecimal omzetTotaal = new BigDecimal("0.00").setScale(2, RoundingMode.HALF_UP);
        BigDecimal omzetLength = new BigDecimal(omzet.length).setScale(2, RoundingMode.HALF_UP);

        if (omzet.length == 0){
            return omzetTotaal;
        } else {
            for (int i = 0; i < omzet.length; i++){
                BigDecimal waarde = new BigDecimal(omzet[i]).setScale(2, RoundingMode.HALF_UP);
                omzetTotaal = omzetTotaal.add(waarde);
            }
        }
        return (omzetTotaal.divide(omzetLength, RoundingMode.HALF_UP));
    }
    
    /*
    c. Er is geen constructor gedefinieerd voor Administratie terwijl je gewoon new Administratie() 
    kan aanroepen. Leg uit waarom dat kan.
    /// Het is een object zonder private variabelen, Java weet dit en maakt gewoon een leeg object met de klasse naam. ///

    */

    /*
    e. We hebben door het static maken van de twee methodes geen instantie meer nodig van
    Administratie. Het is echter wel mogelijk om een instantie van Administratie aan te
    maken en daar de static methoden op aan te roepen. Als je dat wil voorkomen kun je een
    private constructor voor Administratie maken. Doe dat en leg uit waarom je je doel nu
    bereikt.
    /// Omdat je nu gefocreerd een object moet maken voor je methodes ervan kunt aanroepen. ///

    */

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[DAYS_IN_WEEK];
        for (int i=0; i < DAYS_IN_WEEK; i++){
          int j = 0;
          while ((i+DAYS_IN_WEEK*j) < omzet.length) {
              temp[i] += omzet[i+DAYS_IN_WEEK*j];
              j++;

            }
        }
        return temp;
    }



}
