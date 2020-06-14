public class Student extends Persoon
{
    private String studieRichting;
    private String studentNummer;

    /**
     * Constructor voor een student
     * @param studentNummer
     * @param studieRichting
     * @param voornaam
     * @param achternaam
     * @param geboortedag
     * @param geboortemaand
     * @param geboortejaar
     * @param geslacht
     * @param bsn
     */
      public Student(int bsn, String voornaam, String achternaam, int geboortedag, int geboortemaand, int geboortejaar, char geslacht, String studentNummer, String studieRichting)
    {
        super(bsn, voornaam, achternaam, geslacht, geboortedag, geboortemaand, geboortejaar);
        this.studentNummer = studentNummer;
        this.studieRichting = studieRichting;
    }

    /**
     * Parameterloze constructor om mee te testen
     *
     */
    public Student()
    {
        super();
        studentNummer = "";
        studieRichting = "";
    }


    /**
     * ToString methode voor output
     * @return
     */
    @Override
    public String toString() {
        return "{" + "Student: " +
            " studieRichting='" + getStudieRichting() + "'" +
            ", studentNummer='" + getStudentNummer() + "'" +
            "}";
    }


    /**
     * Setter voor het studentnummer
     * @param studentNummer Het studentnummber van de student
     */
    public void setstudentNummer(String studentNummer)
    {
        this.studentNummer = studentNummer;
    }

    /**
     * Setter voor de studierichting
     * @param studieRichting De studierichting van de student
     */
    public void setStudieRichting(String studieRichting)
    {
        this.studieRichting = studieRichting;
    }

    /**
     *  Getter voor het studentnummer
     *  @return studentnummer
     */
    public String getStudentNummer()
    {
        return studentNummer;
    }

    /**
     * Getter voor de studierichting
     * @return studierichting
     */
    public String getStudieRichting()
    {
        return studieRichting;
    }
}