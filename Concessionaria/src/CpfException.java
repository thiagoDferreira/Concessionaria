public class CpfException extends Exception{
    protected String cpf;

    public CpfException(String cpf) {
        super();
        this.cpf = cpf;
    }
    
    @Override
    public String toString(){
        return "CPF inválido";
    }
}
