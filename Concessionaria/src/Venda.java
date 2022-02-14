
import java.util.Date;

public class Venda {
    private Date data;
    private Funcionario funcionario;
    private PessoaFisica pessoaFisica;
    private PessoaJuridica pessoaJuridica;
    private Veiculo veiculo;
    private Pagamento pagamento;

    public Venda() {
    }

    public Venda(Date data, Funcionario funcionario, PessoaFisica pessoaFisica, PessoaJuridica pessoaJuridica, Veiculo veiculo, Pagamento pagamento) {
        this.data = data;
        this.funcionario = funcionario;
        this.pessoaFisica = pessoaFisica;
        this.pessoaJuridica = pessoaJuridica;
        this.veiculo = veiculo;
        this.pagamento = pagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}