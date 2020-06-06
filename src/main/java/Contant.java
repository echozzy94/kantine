public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal(double tebetalen) {
        boolean check = false;
        if ((this.saldo - tebetalen) >= 0.00) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }
}
