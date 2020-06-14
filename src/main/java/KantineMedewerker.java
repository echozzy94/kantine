import java.math.*;

public class KantineMedewerker extends Persoon implements KortingskaartHouder{
    
   // instance variables - replace the example below with your own
   private int medewerkersNummer;
   private boolean magAchterKassa;
   private final BigDecimal kortingspercentage = new BigDecimal(0.35);

    /**
     * Constructor voor een kantinemedewerker
     * @param bsn
     * @param voornaam
     * @param achternaam
     * @param dag
     * @param maand
     * @param jaar
     * @param geslacht
     * @param medewerkersNummer
     * @param magAchterKassa
     */
   public KantineMedewerker(int bsn, String voornaam, String achternaam, int dag, int maand, int jaar, char geslacht, int medewerkersNummer, boolean magAchterKassa)
   {
       super(bsn, voornaam,  achternaam,  geslacht, dag, maand, jaar);
       setMedewerkersNummer(medewerkersNummer);
       setMagAchterKassa(magAchterKassa);
   }

    @Override
    public String toString() {
        return "{" + "Kantinemedewerker: " + 
            " medewerkersNummer='" + getMedewerkersNummer() + "'" +
            "}";
    }


    public KantineMedewerker() {
        super();
        this.medewerkersNummer = 0;
        this.magAchterKassa = false;
    }


   /**
    * Methode - Geeft het medewerkersNummer terug
    * 
    * @return medewerkersNummer        Het nummer van een KantineMedewerker 
    */
   public int getMedewerkersNummer()
   {
       return medewerkersNummer;
   }
   
   /**
    * Methode - Geeft true/false terug van magAchterKassa
    * 
    * @return magAchterKassa        De waarde van een magAchterKassa 
    */
   public boolean getMagAchterKassa()
   {
       return magAchterKassa;
   }
   
   /**
    * Methode - Zet het medewerkersNummer 
    * 
    * @param medewerkersNummer
    */
   public void setMedewerkersNummer(int medewerkersNummer)
   {
       this.medewerkersNummer = medewerkersNummer;
   }
   
   /**
    * Methode - Zet de waarde voor magAchterKassa
    * 
    * @param magAchterKassa
    */
   public void setMagAchterKassa(boolean magAchterKassa)
   {
       this.magAchterKassa = magAchterKassa;
   } 

   public BigDecimal geefKortingsPercentage(){
        return kortingspercentage;
   }

   public boolean heeftMaximum(){
       return false;
   }

   public BigDecimal geefMaximum(){
       return new BigDecimal(0.00);
   }


}