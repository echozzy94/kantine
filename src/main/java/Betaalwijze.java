import java.math.*;

public abstract class Betaalwijze {

    protected BigDecimal saldo;

    /**
     * Methode om krediet te initialiseren
     *
     * @param saldo
     */
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }  

     /**
    * Methode om betaling af te handelen
    * @param tebetalen
    * @return Boolean om te kijken of er voldoende saldo is
    * @throws TeWeinigGeldException Als er te weinig geld is om te betalen.
    */
    public abstract void betaal(BigDecimal tebetalen) throws TeWeinigGeldException;
}
