import java.math.*;

public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal(BigDecimal tebetalen) {
        boolean check = false;
        BigDecimal nul = new BigDecimal(0.00);
        if ((this.saldo.subtract(tebetalen).compareTo(nul) == 1)) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }
}
