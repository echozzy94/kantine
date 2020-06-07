import java.math.*;

public class Docent extends Persoon implements KortingskaartHouder{

    private String vierlettercode;
    private String afdeling;
    private final BigDecimal kortingspercentage = new BigDecimal(0.25);

   //b. Waarom moet een super aanroep in de constructor altijd bovenaan staan?
   // Omdat er eerst een persoon object moet worden gemaakt voor een subklasse kan worden geinitialiseert


    /**
     * Constructor voor docent
     * @param bsn
     * @param voornaam
     * @param achternaam
     * @param geslacht
     * @param dag
     * @param maand
     * @param jaar
     * @param vierlettercode
     * @param afdeling
     */
    public Docent(int bsn, String voornaam, String achternaam, char geslacht, int dag, int maand, int jaar, String vierlettercode, String afdeling){
        super(bsn, voornaam, achternaam, geslacht, dag, maand, jaar);
        setVierLetterCode(vierlettercode);
        this.afdeling = afdeling;
    }

    /**
     * Parameterloze constructor om mee te testen
     */
    public Docent(){
        super();
        this.vierlettercode = "";
        this.afdeling = "";
    }


    /**
     * Getter voor de vierlettercode
     * @return
     */
    public String getVierlettercode() {
        return this.vierlettercode;
    }

    /**
     * ToString methode voor output
     * @return
     */
    @Override
    public String toString() {
        return "{" + "Docent: " +
            " vierlettercode='" + getVierlettercode() + "'" +
            ", afdeling='" + getAfdeling() + "'" +
            "}";
    }

    /**
     * Getter voor de afdeling
     * @return
     */
    public String getAfdeling() {
        return this.afdeling;
    }

    /**
     * Setter voor de afdeling
     * @param afdeling
     */
    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    /**
     * Setter voor de vierlettercode, deze zorgt er voor dat het ook altijd echt een vierlettercode is
     * @param vierlettercode
     */
    public void setVierLetterCode(String vierlettercode){
        if (vierlettercode.length() > 4){
            this.vierlettercode = vierlettercode.substring(0, 4);
        } else 
        this.vierlettercode = vierlettercode;
    }

    public BigDecimal geefKortingsPercentage(){
        return kortingspercentage;
   }

   public boolean heeftMaximum(){
       return true;
   }

   public BigDecimal geefMaximum(){
       return new BigDecimal(1.00);
   }



}