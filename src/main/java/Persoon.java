


public class Persoon {
    private int BSN;
    private String voorNaam;
    private String achterNaam;
    private Datum geboorteDatum;
    private char geslacht;


    public Persoon(int BSN, String voorNaam, String achterNaam, char geslacht, int dag, int maand, int jaar) {
        this.BSN = BSN;
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.geboorteDatum = new Datum(dag, maand, jaar);
        if (geslacht != 'M' || geslacht != 'V') {
            this.geslacht = 'O';
        } else {
            this.geslacht = geslacht;
        }
    }

    public Persoon() {
        BSN = 0;
        voorNaam = "";
        achterNaam = "";
        geboorteDatum = new Datum();
        geslacht = 'O';
    }

    public void setBSN(int BSN) {
        this.BSN = BSN;
    }

    public void setVoorNaam(String voorNaam) {
        this.voorNaam = voorNaam;
    }

    public void setAchterNaam(String achterNaam) {
        this.achterNaam = achterNaam;
    }

    public void setGeboorteDatum(Datum geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public void setGeslacht(char geslacht) {
        if (geslacht == 'M' || geslacht == 'V') {
            this.geslacht = geslacht;
        } else {
            System.out.println("Dit is onjuist, gebruik 'M' of 'V' Er is nu 'O' voor onbekend ingevuld");
            this.geslacht = 'O';
        }
    }

    public int getBSN() {
        return BSN;
    }

    public String getVoorNaam() {
        return voorNaam;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public String getGeboorteDatum() {
        if (geboorteDatum.getDag() == 0) {
            return "Onbekend";
        } else {
            return geboorteDatum.getDatumAsString();
        }
    }

    public String getGeslacht() {
        if (this.geslacht == 'M') {
            return "Man";
        } else if (this.geslacht == 'V') {
            return "Vrouw";
        } else {
            return "Onbekend";
        }
    }

    public String toString(){
        return BSN + " " + voorNaam + " " + " " + " " + achterNaam + " " + getGeboorteDatum() + " " + getGeslacht();
    }
}


