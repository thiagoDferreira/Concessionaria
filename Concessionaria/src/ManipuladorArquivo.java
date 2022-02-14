import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;

public class ManipuladorArquivo {
    public static ArrayList<Funcionario> leitorFuncionarios() throws IOException, CpfException, CnpjException{
        //leitor de funcionarios
        BufferedReader buffRead = new BufferedReader(new FileReader("C:/Users/thiag/Documents/GitHub/Concessionaria/Concessionaria/Funcionarios.txt"));
        ArrayList<Funcionario> funcionarios = new ArrayList();
        String linha;
        while ((linha = buffRead.readLine()) != null) {
            String[] token = linha.split(";");
            Endereco e = new Endereco(token[5],token[6],token[7],token[8],Integer.parseInt(token[9]));
            Contato c = new Contato(token[3],token[4]);
            Funcionario f = new Funcionario(token[2],Double.parseDouble(token[10]));
            f.setNome(token[0]);
            f.setCpf(token[1]);
            f.setEndereco(e);
            f.setContato(c);
            funcionarios.add(f);
        }
        return funcionarios;
    }
    
    public static ArrayList<Veiculo> leitorVeiculos() throws IOException{
        //leitor de funcionarios
        BufferedReader buffRead = new BufferedReader(new FileReader("C:/Users/thiag/Documents/GitHub/Concessionaria/Concessionaria/Veiculos.txt"));
        ArrayList<Veiculo> veiculos = new ArrayList();
        String linha;
        while ((linha = buffRead.readLine()) != null) {
            String[] token = linha.split(";");
            Veiculo v = new Veiculo(token[0],token[1],token[2],Integer.parseInt(token[3]),token[4].charAt(0),Double.parseDouble(token[5]));
            veiculos.add(v);
        }
        return veiculos;
    }
    /*
     public static ArrayList<Venda> leitorVendas() throws IOException, CpfException, CnpjException{
        //leitor de funcionarios
        BufferedReader buffRead = new BufferedReader(new FileReader("C:/Users/TdiniF/Documents/NetBeansProjects/Concessionaria/Vendas.txt"));
        ArrayList<Venda> vendas = new ArrayList();
        String linha;
        while ((linha = buffRead.readLine()) != null) {
            String[] token = linha.split(";");
            Endereco e = new Endereco(token[5],token[6],token[7],token[8],Integer.parseInt(token[9]));
            Contato c = new Contato(token[3],token[4]);
            Funcionario f = new Funcionario(token[2],Double.parseDouble(token[10]));
            f.setNome(token[0]);f.setCpf(token[1]);
            Veiculo v = new Veiculo(token[11],token[12],token[13],Integer.parseInt(token[14]),token[15].charAt(0),Double.parseDouble(token[16]));
            Venda venda= new Venda();
            venda.setData(token[27]);
            if(token[19].length()==9){
                PessoaFisica pf = new PessoaFisica(token[19]);
                pf.setNome(token[17]);pf.setCpf(token[18]);
                Contato contato = new Contato(token[21],token[20]);
                Endereco endereco = new Endereco(token[22],token[23],token[24],token[25],Integer.parseInt(token[26]));
                pf.setContato(contato);pf.setEndereco(endereco);
            }else{
                PessoaJuridica pj = new PessoaJuridica(token[19]);
                pj.setNome(token[17]);pj.setCpf(token[18]);
                Contato contato = new Contato(token[21],token[20]);
                Endereco endereco = new Endereco(token[22],token[23],token[24],token[25],Integer.parseInt(token[26]));
                pj.setContato(contato);pj.setEndereco(endereco);
            }
            Pagamento p =new Pagamento(Double.parseDouble(token[28]),Double.parseDouble(token[29]),Double.parseDouble(token[30]));
            vendas.add(venda);
        }
        return vendas;
    }
    */
    public static void escritorFuncionarios(ArrayList <Funcionario> funcionarios) throws IOException,NullPointerException {
        //Escreve os funcionarios
        BufferedWriter funcionario = new BufferedWriter(new FileWriter("C:/Users/thiag/Documents/GitHub/Concessionaria/Concessionaria/Funcionarios.txt"));
        String escreve = "";
        for (Funcionario a : funcionarios) {
            try{
            escreve = a.getNome()+ ";" + a.getCpf() +";" + a.getCargo() + ";" + a.getContato().getNumero() +";" + a.getContato().getEmail() + ";" + a.getEndereco().getEstado() + ";" + a.getEndereco().getCidade() + ";" + a.getEndereco().getBairro() + ";" + a.getEndereco().getRua() + ";" + a.getEndereco().getNumero() +";"+ a.getSalario()+ "\n";
            }catch(NullPointerException ex){
                System.out.println(ex.getCause());
            }
            System.out.println(escreve);
            funcionario.append(escreve);
        }
        funcionario.close();
    }    
    public static void escritorVeiculos(ArrayList <Veiculo> veiculos) throws IOException{
        //Escreve os Veiculos
        BufferedWriter veiculo = new BufferedWriter(new FileWriter("C:/Users/thiag/Documents/GitHub/Concessionaria/Concessionaria/Veiculos.txt"));
        for (Veiculo a : veiculos) {
            String escreve = a.getMarca()+";"+a.getModelo()+";"+a.getEspecificacoes()+";"+a.getEstoque()+";"+a.getClasse()+";"+a.getPreco()+"\n";
            veiculo.append(escreve);
        }
        veiculo.close();
    }
    
    public static void escritorVendas(ArrayList <Venda> vendas) throws IOException{
        //Escreve as vendas
        BufferedWriter venda = new BufferedWriter(new FileWriter("C:/Users/thiag/Documents/GitHub/Concessionaria/Concessionaria/Vendas.txt"));
        for (Venda a : vendas) {
            String escreve = a.getFuncionario().getNome()+ ";" + a.getFuncionario().getCpf() +";" + a.getFuncionario().getCargo() + ";" + a.getFuncionario().getContato().getNumero() +";" + a.getFuncionario().getContato().getEmail() + ";" + a.getFuncionario().getEndereco().getEstado() + ";" + a.getFuncionario().getEndereco().getCidade() + ";" + a.getFuncionario().getEndereco().getBairro() + ";" + a.getFuncionario().getEndereco().getRua() + ";" + a.getFuncionario().getEndereco().getNumero() +";"+ a.getFuncionario().getSalario()+";"+a.getVeiculo().getMarca()+";"+a.getVeiculo().getModelo()+";"+a.getVeiculo().getEspecificacoes()+";"+a.getVeiculo().getEstoque()+";"+a.getVeiculo().getClasse()+";"+a.getVeiculo().getPreco()+";";
            if(a.getPessoaFisica().getNome()!=null){
                escreve = escreve+a.getPessoaFisica().getNome()+";"+a.getPessoaFisica().getCpf()+";"+a.getPessoaFisica().getRg()+":"+a.getPessoaFisica().getContato().getEmail()+";"+a.getPessoaFisica().getContato().getNumero()+";"+a.getPessoaFisica().getEndereco().getEstado()+";"+a.getPessoaFisica().getEndereco().getCidade()+";"+a.getPessoaFisica().getEndereco().getBairro()+";"+a.getPessoaFisica().getEndereco().getRua()+";"+a.getPessoaFisica().getEndereco().getNumero()+";";
            }else{
                escreve = escreve+a.getPessoaJuridica().getNome()+";"+a.getPessoaJuridica().getCpf()+";"+a.getPessoaJuridica().getCnpj()+";"+a.getPessoaJuridica().getContato().getEmail()+";"+a.getPessoaJuridica().getContato().getNumero()+";"+a.getPessoaJuridica().getEndereco().getEstado()+";"+a.getPessoaJuridica().getEndereco().getCidade()+";"+a.getPessoaJuridica().getEndereco().getBairro()+";"+a.getPessoaJuridica().getEndereco().getRua()+";"+a.getPessoaJuridica().getEndereco().getNumero()+";";
            }
                escreve = escreve+a.getData()+";"+a.getPagamento().getValorParcela()+";"+a.getPagamento().getTaxa()+";"+a.getPagamento().getPrecoTotal()+"\n";
            venda.append(escreve);
        }
        venda.close();
        exit(0);
    }
    
    public static void escritor(ArrayList <Funcionario> funcionarios,ArrayList <Veiculo> veiculos,ArrayList <Venda> vendas) throws IOException{
        escritorFuncionarios(funcionarios);
        escritorVeiculos(veiculos);
        escritorVendas(vendas);
    }
}
