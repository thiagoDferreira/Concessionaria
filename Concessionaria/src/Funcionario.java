
import java.util.ArrayList;

public class Funcionario extends Pessoa {

    private String cargo;
    private double salario;

    public Funcionario() {
    }

    public Funcionario(String cargo, double salario) {
        super();
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }
    
    public void setSalario(double salario){
        this.salario = salario;
    }
    

}//Classe
