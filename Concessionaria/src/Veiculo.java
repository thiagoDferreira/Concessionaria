
import java.util.InputMismatchException;


public class Veiculo {
    private String marca,modelo,especificacoes;
    private int estoque;
    private char classe;
    private double preco;

    public Veiculo() {
    }

    public Veiculo(String marca, String modelo, String especificacoes,int estoque, char classe, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.especificacoes = especificacoes;
        this.classe = classe;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEspecificacoes() {
        return especificacoes;
    }

    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

    public char getClasse() {
        return classe;
    }

    public void setClase(char classe) {
        this.classe = classe;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) throws InputMismatchException{
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) throws InputMismatchException{
        this.estoque = estoque;
    }
}
