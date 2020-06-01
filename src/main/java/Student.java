public class Student extends Persoon
{
    private String studieRichting;
    private String studentNummer;

    /*
     * Constructor voor de subklasse student
     */
      public Student(String studentNummer, String studieRichting, String voornaam, String achternaam, int geboortedag, int geboortemaand, int geboortejaar, char geslacht, int bsn)
    {
        super(bsn, voornaam, achternaam, geslacht, geboortedag, geboortemaand, geboortejaar);
        this.studentNummer = studentNummer;
        this.studieRichting = studieRichting;
    }
    public Student()
    {
        super();
        studentNummer = "";
        studieRichting = "";
    }


    @Override
    public String toString() {
        return "{" + "Student: " +
            " studieRichting='" + getStudieRichting() + "'" +
            ", studentNummer='" + getStudentNummer() + "'" +
            "}";
    }


    /*
     * Methode voor het aanpassen van StudentNummer
     */
    public void setstudentNummer(String studentNummer)
    {
        this.studentNummer = studentNummer;
    }

    /*
     * Methode voor het aanpassen van StudieRichting
     */
    public void setStudieRichting(String studieRichting)
    {
        this.studieRichting = studieRichting;
    }

    /*
     *  Methode voor het verkrijgen van het studentNummer van de student
     *  @return studentnummer
     */
    public String getStudentNummer()
    {
        return studentNummer;
    }

    /**
     * Methode voor het verkrijgen van de studie richting van de student
     * @return studierichting
     */
    public String getStudieRichting()
    {
        return studieRichting;
    }
}