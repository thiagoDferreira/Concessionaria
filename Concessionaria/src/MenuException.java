
public class MenuException extends Exception{
    protected int op;
    public MenuException(int op) {
        super();
        this.op = op;
    }
    
    @Override
    public String toString(){
        return "Opção inválida";
    }
}
