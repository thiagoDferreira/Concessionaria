
public class RgException extends Exception{
    protected String rg;
    public RgException(String rg) {
        super();
        this.rg = rg;
    }
    
    @Override
    public String toString(){
        return "RG inválido";
    }
}
