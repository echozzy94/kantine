
public class test {
private Artikel artikel1;
private Artikel artikel2;
private Artikel artikel3;
private Artikel artikel4;
private Artikel artikel5;
private Datum datumleeg;  
private Datum datumvol;
private Datum datumverkeerd;
private Persoon leegpersoon;
private Persoon persoon1;
private Persoon persoon2;
private Persoon persoon3;
private Dienblad dienblad1;
private Dienblad dienblad2;
private Dienblad dienblad3;
private KassaRij kassarij;
private Kassa kassa1;
private Administratie admin;


public static void main(String[] args) {
    ////Artikel klasse test //////////
    Artikel artikel1 = new Artikel("Koekje", "0.50");
    Artikel artikel2 = new Artikel("Banaan", "1.50");
    Artikel artikel3 = new Artikel("Appel", "0.30");
    Artikel artikel4 = new Artikel("Broodje", "3.50");
    Artikel artikel5 = new Artikel("Sinaasappelsap", "1.75");
    System.out.println(artikel1.toString());
    artikel1.setNaam("Ijsje");
    System.out.println(artikel1.getNaam());
    artikel1.setPrijs("0.70");
    System.out.println(artikel2.getPrijs().subtract(artikel1.getPrijs()));
    System.out.println(artikel1.toString());
    /////////////// Datum klasse test //////
    Datum datumleeg = new Datum();
    System.out.println(datumleeg.toString());
    Datum datumvol = new Datum(29,02,2020);
    System.out.println(datumvol.toString());
    Datum datumverkeerd = new Datum(200,05,2600);
    System.out.println("Zojuist een verkeerde datum ingevoerd die niet door de validator komt van de constructor.");
    System.out.println(datumverkeerd.toString());
    System.out.println("We gaan hem nu aanpassen naar een correcte datum.");
    datumverkeerd.setDag(4);
    datumverkeerd.setMaand(3);
    datumverkeerd.setJaar(1999);
    System.out.println(datumverkeerd.toString());
    /////// Persoon klasse test ///
    Persoon leegpersoon = new Persoon();
    System.out.println(leegpersoon.toString());
    Persoon persoon1 = new Persoon(123456789, "Jan", "Kort", 'M', 1, 1, 2001);
    Persoon persoon2 = new Persoon(123456789, "Jannie", "Kortie", 'V', 2, 6, 1994);
    Persoon persoon3 = new Persoon(123456789, "Wim", "Knol", 'M', 13, 7, 2002);
    System.out.println(persoon1.toString());
    ////// Dienblad klasse test ////
    Dienblad dienblad1 = new Dienblad(persoon1);
    Dienblad dienblad2 = new Dienblad(persoon1);
    Dienblad dienblad3 = new Dienblad(persoon1);
    System.out.println(dienblad1.toString());
    dienblad1.voegToe(artikel1);
    dienblad1.voegToe(artikel2);
    dienblad1.voegToe(artikel3);
    dienblad1.voegToe(artikel4);
    dienblad1.voegToe(artikel5);
    dienblad2.voegToe(artikel4);
    dienblad2.voegToe(artikel5);
    dienblad3.voegToe(artikel2);
    dienblad3.voegToe(artikel3);
    System.out.println(dienblad1.toString());
    ///// Kassarij test klasse //////
    KassaRij kassarij = new KassaRij();
    kassarij.sluitAchteraan(dienblad1);
    kassarij.sluitAchteraan(dienblad2);
    kassarij.sluitAchteraan(dienblad3);
    System.out.println("Het aantal personen in de rij is: " + kassarij.getKassaRij());
    kassarij.eerstePersoonInRij();
    System.out.println("Voordat de methode werd aangeroepen waren er 3 man in de array, nu zijn dat er " + kassarij.getKassaRij());
    System.out.println("We voeren de methode nu nog eens uit");
    kassarij.eerstePersoonInRij();
    System.out.println("Het aantal personen in de rij is: " + kassarij.getKassaRij());
    /////// Kassa Test klasse ///////
    Kassa kassa1 = new Kassa(kassarij);
    kassa1.rekenAf(kassarij.eerstePersoonInRij());
    System.out.println("Klant 1 rekent af");
    String s = String.valueOf(kassa1.aantalArtikelen());
    String c = String.valueOf(kassa1.hoeveelheidGeldInKassa());
    System.out.println("Artikelen " + s);
    System.out.println("Geld in kassa: " +c);
    kassarij.sluitAchteraan(dienblad1);
    kassarij.sluitAchteraan(dienblad2);
    System.out.println("Klant 2 rekent af");
    kassa1.rekenAf(kassarij.eerstePersoonInRij());
    String s1 = String.valueOf(kassa1.aantalArtikelen());
    String c1 = String.valueOf(kassa1.hoeveelheidGeldInKassa());
    System.out.println("Artikelen " +s1);
    System.out.println("Geld in kassa: " +c1);
    System.out.println("We gaan nu de kassa resetten");
    kassa1.resetKassa();
    String s2 = String.valueOf(kassa1.aantalArtikelen());
    String c2 = String.valueOf(kassa1.hoeveelheidGeldInKassa());
    System.out.println("Artikelen " +s2);
    System.out.println("Geld in kassa: " + c2);
    // Testen van administratie
    Administratie admin = new Administratie();
    int[] aantal = new int[] {45, 56, 34, 39, 40, 31};
    double[] omzet = new double[] {567.70, 498.25, 458.90};
    System.out.println(admin.berekenGemiddeldAantal(aantal));
    System.out.println(admin.berekenGemiddeldeOmzet(omzet));



}
}