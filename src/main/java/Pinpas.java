public class Pinpas extends Betaalwijze {

    private double kredietlimiet;

    /**
     * Methode om kredietlimiet te zetten
     *
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietlimiet) {
        this.kredietlimiet = kredietlimiet;
    }

    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal(double tebetalen) {
        double restant = 0.00;
        if ((this.saldo - (tebetalen + kredietlimiet) < 0.00)){
            return false;
        } else {
            if (kredietlimiet + this.saldo >= tebetalen){
                if ((tebetalen - saldo) < 0.00){
                    while (tebetalen - saldo != 0.00){
                        this.saldo = saldo - 0.01;
                        tebetalen = tebetalen - 0.01;
                        restant = tebetalen;
                    }
                } while (restant != 0.00){
                    kredietlimiet = kredietlimiet - 0.01;
                    tebetalen = tebetalen - 0.01;
                }
            }
            kredietlimiet = (kredietlimiet - tebetalen);
            return true;
        }
    }
}
