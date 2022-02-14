
import java.util.InputMismatchException;


public class Contato {
   private String numero,email;

    public Contato() {
    }

    public Contato(String numero, String email) {
        this.numero = numero;
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws InputMismatchException{
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
   
}
