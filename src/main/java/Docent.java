public class Docent extends Persoon{

    private String vierlettercode;
    private String afdeling;

   //b. Waarom moet een super aanroep in de constructor altijd bovenaan staan?
   // Omdat er eerst een persoon object moet worden gemaakt voor een subklasse kan worden geinitialiseert
   
    public Docent(int bsn, String voornaam, String achternaam, char geslacht, int dag, int maand, int jaar, String vierlettercode, String afdeling){
        super(bsn, voornaam, achternaam, geslacht, dag, maand, jaar);
        setVierLetterCode(vierlettercode);
        this.afdeling = afdeling;
    }

    public Docent(){
        super();
        this.vierlettercode = "";
        this.afdeling = "";
    }
   

    public String getVierlettercode() {
        return this.vierlettercode;
    }

    @Override
    public String toString() {
        return "{" + "Docent: " +
            " vierlettercode='" + getVierlettercode() + "'" +
            ", afdeling='" + getAfdeling() + "'" +
            "}";
    }

    public String getAfdeling() {
        return this.afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }


    public void setVierLetterCode(String vierlettercode){
        if (vierlettercode.length() > 4){
            this.vierlettercode = vierlettercode.substring(0, 4);
        } else 
        this.vierlettercode = vierlettercode;
    }
}