import java.util.ArrayList;

public class KassaRij {

    private ArrayList<Dienblad> arrayKassarij;

    /**
     * Constructor
     */
    public KassaRij() {
        arrayKassarij = new ArrayList<Dienblad>();
    }
    public String getKassaRij(){
        String r = String.valueOf(arrayKassarij.size());
        return r;
    }

    /**
     * Persoon sluit achter in de rij aan
     *
     * @param dienblad
     */
    public void sluitAchteraan(Dienblad dienblad) {
            arrayKassarij.add(dienblad);
        }

    /**
     * Indien er een rij bestaat, de eerste klant uit de rij verwijderen en retourneren. Als er
     * niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null
     */
    public Dienblad eerstePersoonInRij() {
        boolean isErEenRij = erIsEenRij();
        if (isErEenRij == true) {
            Dienblad eersteKlant = arrayKassarij.get(0);
            arrayKassarij.remove(0);
            return eersteKlant;
        }
        return null;
    }

    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        int rij = arrayKassarij.size();
        if(rij == 0) {
            return false;
        }
        else {
            return true;
        }
    }
}
