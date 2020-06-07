import java.math.*;

public class Pinpas extends Betaalwijze {

    private BigDecimal kredietlimiet;

    /**
     * Methode om kredietlimiet te zetten
     *
     * @param kredietlimiet
     */
    public void setKredietLimiet(BigDecimal kredietlimiet) {
        this.kredietlimiet = kredietlimiet;
    }

    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal(BigDecimal tebetalen) {
        boolean check = false;
        if ((this.saldo.add(kredietlimiet).compareTo(tebetalen) == 1)) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }
}
