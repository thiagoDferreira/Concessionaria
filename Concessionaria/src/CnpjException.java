
public class CnpjException extends Exception{
    protected String cnpj;
    public CnpjException(String cnpj) {
        super();
        this.cnpj = cnpj;
    }
    
    @Override
    public String toString(){
        return "CNPJ inválido";
    }
}
