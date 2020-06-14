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
    public void betaal(BigDecimal tebetalen) throws TeWeinigGeldException {
        if ((this.saldo.add(kredietlimiet).compareTo(tebetalen) == 1)) {
            this.saldo = this.saldo.subtract(tebetalen);
            if(this.saldo.compareTo(new BigDecimal(0.00)) == -1){
                this.kredietlimiet = this.kredietlimiet.subtract(saldo);
                this.saldo = new BigDecimal(0.00);
            }
            
        } else {
            throw new TeWeinigGeldException("heeft niet genoeg salso op de pinpas om te betalen.");
        }
    }
}

