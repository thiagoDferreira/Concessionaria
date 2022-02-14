
public class PessoaFisica extends Pessoa{
    private String rg;

    public PessoaFisica() {
    }

    
    public PessoaFisica(String rg) {
        super();
        this.rg = rg;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    
}
