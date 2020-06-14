import java.math.*;

public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     * @throws TeWeinigGeldException Als er onvoldoende saldo is
     */
    public void betaal(BigDecimal tebetalen) throws TeWeinigGeldException {
        
        BigDecimal nul = new BigDecimal(0.00);
        if ((this.saldo.subtract(tebetalen).compareTo(nul) == 1)) {
            this.saldo = this.saldo.subtract(tebetalen);
            } 
            else {
            throw new TeWeinigGeldException("Klant heeft niet genoeg geld om te betalen.");
        } 
    }
}
