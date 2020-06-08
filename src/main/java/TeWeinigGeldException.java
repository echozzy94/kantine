public class TeWeinigGeldException extends Exception
{
    
    String errorMelding;
    
    public TeWeinigGeldException() 
    {
        super("Onvoldoende saldo" );
           
    }
    
    public TeWeinigGeldException(Exception e)
    {
        super(e);
    }
    
    public TeWeinigGeldException(String errorMelding)
    {
        super(errorMelding);
        this.errorMelding = errorMelding;
    }
    
    public String getErrorMelding()
    {
        return errorMelding;
    }
}