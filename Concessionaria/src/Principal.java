
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class Principal {

    private static ArrayList<Funcionario> funcionarios = new ArrayList();
    private static ArrayList<Veiculo> veiculos = new ArrayList();
    private static ArrayList<Venda> vendas = new ArrayList();
    //Criação dos arquivos
    private static File fileFuncionarios = new File("C:/Users/TdiniF/Documents/NetBeansProjects/Concessionaria/Funcionarios.txt");
    private static File fileVeiculos = new File("C:/Users/TdiniF/Documents/NetBeansProjects/Concessionaria/Veiculos.txt");
    private static File fileVendas = new File("C:/Users/TdiniF/Documents/NetBeansProjects/Concessionaria/Vendas.txt");

    //Metodo que preenche contato 
    private static Contato setContato(String qual) {
        Contato contato = new Contato();
        contato.setEmail(JOptionPane.showInputDialog("Insira o e-mail do " + qual + " para contato:"));
        try {
            contato.setNumero(JOptionPane.showInputDialog("Insira um numero do " + qual + " para contato:"));
        } catch (InputMismatchException ex) {
            JOptionPane.showMessageDialog(null, "O numero inserido é invalido");
            menu();
        }

        return contato;
    }

    //Metodo que preenche endereco
    private static Endereco setEndereco(String qual) {
        Endereco endereco = new Endereco();
        endereco.setEstado(JOptionPane.showInputDialog("Insira a UF da(o) " + qual + ":"));
        endereco.setCidade(JOptionPane.showInputDialog("Insira a cidade da(o) " + qual + ":"));
        endereco.setBairro(JOptionPane.showInputDialog("Insira o bairro da(o) " + qual + ":"));
        endereco.setRua(JOptionPane.showInputDialog("Insira a rua da(o) " + qual + ":"));
        try {
            endereco.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Insira o numero residencial da(o) " + qual + ":")));
        } catch (InputMismatchException ex) {
            JOptionPane.showMessageDialog(null, "O numero inserido é invalido");
            menu();
        }

        return endereco;
    }

    //calcula o salario de acordo com as vendas realizadas por cada funcionario
    public static void setSalario(ArrayList<Venda> vendas, ArrayList<Funcionario> funcionarios) {
        double comissao = 0;
        for (Funcionario f : funcionarios) {
            for (Venda v : vendas) {
                if (v.getFuncionario().getNome().equals(f.getNome())) {
                    comissao = comissao + v.getPagamento().getPrecoTotal()*0.10;
                }
            }
            f.setSalario(914 +comissao);
        }
    }
    
    //metodo que preenche funcionario
    private static Funcionario setFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(JOptionPane.showInputDialog("Insira o nome da(o) funcionaria(o):"));
        try {
            funcionario.setCpf(JOptionPane.showInputDialog("Insira o cpf da(o) funcionaria(o):"));
            if (funcionario.getCpf().length() != 11) {
                throw new CpfException(funcionario.getCpf());
            }
        } catch (CpfException ex) {
            JOptionPane.showMessageDialog(null, "O numero inserido é invalido");
            menu();
        }
        funcionario.setEndereco(setEndereco("funcionario"));
        funcionario.setContato(setContato("funcionario"));
        funcionario.setCargo(JOptionPane.showInputDialog("Insira o cargo da(o) funcionaria(o):"));
        return funcionario;
    }
    

    //Metodo que preenche Pessoa juridica
    public static PessoaJuridica setPessoaJuridica() {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setNome(JOptionPane.showInputDialog("Insira o nome da empresa:"));
        try {
            pessoaJuridica.setCpf(JOptionPane.showInputDialog("Insira o cpf da(o) dona(o) da empresa:"));
            if (pessoaJuridica.getCpf().length() != 11) {
                throw new CpfException(pessoaJuridica.getCpf());
            }
        } catch (CpfException ex) {
            JOptionPane.showMessageDialog(null, "O numero inserido é invalido");
            menu();
        }
        try {
            pessoaJuridica.setCnpj(JOptionPane.showInputDialog("Insira o CNPJ da empresa:"));
            if (pessoaJuridica.getCnpj().length() != 14) {
                throw new CnpjException(pessoaJuridica.getCnpj());
            }
        } catch (CnpjException ex) {
            JOptionPane.showMessageDialog(null, "O CNPJ inserido é invalido");
            menu();
        }
        pessoaJuridica.setEndereco(setEndereco("empresa"));
        pessoaJuridica.setContato(setContato("empresa"));
        return pessoaJuridica;
    }

    //Metodo que preenche Pessoa fisica
    public static PessoaFisica setPessoaFisica() {
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setNome(JOptionPane.showInputDialog("Insira o nome da pessoa:"));
        try {
            pessoaFisica.setCpf(JOptionPane.showInputDialog("Insira o CPF da pessoa:"));
            if (pessoaFisica.getCpf().length() != 11) {
                throw new CpfException(pessoaFisica.getCpf());
            }
        } catch (CpfException ex) {
            JOptionPane.showMessageDialog(null, "O numero inserido é invalido");
            menu();
        }
        try {
            pessoaFisica.setRg(JOptionPane.showInputDialog("Insira o RG da pessoa:"));
            if (pessoaFisica.getRg().length() != 8) {
                throw new RgException(pessoaFisica.getRg());
            }
        } catch (RgException ex) {
            JOptionPane.showMessageDialog(null, "O RG inserido é invalido");
            menu();
        }
        pessoaFisica.setEndereco(setEndereco("pessoa"));
        pessoaFisica.setContato(setContato("pessoa"));
        return pessoaFisica;
    }
    
    //Metodo que pede se é completo ou nao
    public static String setEspecificacao(){
         int op = 0;
        try {
            op = Integer.parseInt(JOptionPane.showInputDialog("Insira 1-Completo/2-Incompleto"));
            if (op < 1 || op > 2) {
                throw new MenuException(op);
            }
        } catch (MenuException ex) {
            JOptionPane.showMessageDialog(null, "Opção inválida");
            menu();
        }
        if (op == 1) {
            return "Completo";
        } else {
            return "Incomplto";
        }
    }

    //Metodo que preenche veiculo
    public static Veiculo setVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca(JOptionPane.showInputDialog("Insira a marca do veiculo:"));
        veiculo.setModelo(JOptionPane.showInputDialog("Insira o modelo do veiculo:"));
        veiculo.setClase(JOptionPane.showInputDialog("Insira a classe do veiculo:").charAt(0));
        try {
            veiculo.setEstoque(Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade em estoque do veiculo:")));
        } catch (InputMismatchException ex) {
            JOptionPane.showMessageDialog(null, "O valor inserido não existe");
            menu();
        }
        
        try {
            veiculo.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Insira o preco do veiculo:")));
        } catch (InputMismatchException ex) {
            JOptionPane.showMessageDialog(null, "O valor inserido não existe");
            menu();
        }
        veiculo.setEspecificacoes(setEspecificacao());
        //Testa se veiculo existe em estoque e pede um novo valor para estoque
        if (getVeiculo(veiculo.getModelo(),veiculo.getEspecificacoes(), veiculos) != null) {
            getVeiculo(veiculo.getModelo(),veiculo.getEspecificacoes(), veiculos).setEstoque(Integer.parseInt(JOptionPane.showInputDialog("O veiculo foi encontrado em estoque, atualize a quantidade armazenada")));
        }
        
        return veiculo;
    }

    //Metodo de pagamento
    public static Pagamento setPagamento(double preco, double taxa, int parcelas) {
        Pagamento pagamento = new Pagamento();
        pagamento.setValorParcela(preco / parcelas);
        pagamento.setTaxa(taxa);
        pagamento.setPrecoTotal(preco + (pagamento.getValorParcela() * taxa) * parcelas);
        return pagamento;
    }

    /*Preenche uma data valida
    public static String setData() {
        String dia = "";
        String mes = "";
        String ano = "";
        try {
            dia = JOptionPane.showInputDialog("Insira o dia:");
            mes = JOptionPane.showInputDialog("Insira o mes:");
            ano = JOptionPane.showInputDialog("Insira o ano:");
        } catch (InputMismatchException ex) {
            JOptionPane.showMessageDialog(null, "Data inserida é invalida");
            menu();
        }
        return dia + "/" + mes + "/" + ano;
    }
    */
    //Metodo que preenche venda
    public static Venda setVenda() {
        Venda venda = new Venda();
        Date data = new Date();
        venda.setData(data);
        //Teste para funcionario
        String nome = JOptionPane.showInputDialog("Insira o funcionario que realizara a venda:");
        venda.setFuncionario(getFuncionario(nome, funcionarios));
        //Escolha de tipo de cliente
        int opVenda = 0;
        try {
            opVenda = Integer.parseInt(JOptionPane.showInputDialog("Insira opcao valida\n1-Pessoa fisica.\n2-Pessoa juridica.\n3-Cancelar venda"));
            if (opVenda < 1 || opVenda > 3) {
                throw new MenuException(opVenda);
            }
        } catch (MenuException ex) {
            JOptionPane.showMessageDialog(null, "Opção inválida");
        }
        switch (opVenda) {
            case 1:
                venda.setPessoaFisica(setPessoaFisica());
                break;
            case 2:
                venda.setPessoaJuridica(setPessoaJuridica());
                break;
            case 3:
                menu();
        }
        String modelo = JOptionPane.showInputDialog("Insira o modelo do veiculo:");
        String especificacao = setEspecificacao();
        
        if (getVeiculo(modelo,especificacao ,veiculos) == null) {
            menu();
        }else{
            venda.setVeiculo(getVeiculo(modelo,especificacao ,veiculos));
        }
        //Formas de pagamento
        int parcelas;
        do {
            parcelas = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero de parcelas que deseja pagar entre 12,32 e64 parcelas e 1 para pagamento A vista:"));
        } while (parcelas != 12 && parcelas != 32 && parcelas != 64 && parcelas != 1);
        switch (parcelas) {
            case 1:
                Pagamento pagamento = new Pagamento();
                pagamento.setValorParcela(venda.getVeiculo().getPreco());
                pagamento.setTaxa(0);
                pagamento.setPrecoTotal(venda.getVeiculo().getPreco());
                venda.setPagamento(pagamento);
            case 12:
                venda.setPagamento(setPagamento(venda.getVeiculo().getPreco(), 0.1, parcelas));
            case 32:
                venda.setPagamento(setPagamento(venda.getVeiculo().getPreco(), 0.2, parcelas));
            case 64:
                venda.setPagamento(setPagamento(venda.getVeiculo().getPreco(), 0.3, parcelas));
        }
        //Diminui estoque do veiculo
        if(venda.getVeiculo().getEstoque()==1){
            veiculos.remove(getVeiculo(venda.getVeiculo().getModelo(), venda.getVeiculo().getEspecificacoes(), veiculos));
        }else{
            int e = getVeiculo(venda.getVeiculo().getModelo(), venda.getVeiculo().getEspecificacoes(), veiculos).getEstoque();
            getVeiculo(venda.getVeiculo().getModelo(), venda.getVeiculo().getEspecificacoes(), veiculos).setEstoque(e-1);
        }
        
        return venda;
    }

    //Metodo que busca veiculo
    public static Veiculo getVeiculo(String modelo,String especificacao, ArrayList<Veiculo> veiculos) {
        for (Veiculo v : veiculos) {
            if (v.getModelo().equals(modelo) && v.getEspecificacoes().equals(especificacao)) {
                return v;
            }
        }
        JOptionPane.showMessageDialog(null, "Este veiculo nao consta no sistema");
        return null;
    }
    //Metodo que busca funcionario

    public static Funcionario getFuncionario(String nome, ArrayList<Funcionario> funcionarios) {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equals(nome)) {
                return f;
            }
        }
        JOptionPane.showMessageDialog(null, "Este funcionario nao consta no sistema");
        menu();
        return null;
    }

    //Metodo que mostra dados de um funcionario
    public static void mostraFuncionarios(ArrayList<Funcionario> funcionarios) {
        for (Funcionario mostrar : funcionarios) {
            JOptionPane.showMessageDialog(null, "Nome:" + mostrar.getNome() + "\nCargo:" + mostrar.getCargo() + "\nCpf:" + mostrar.getCpf());
        }
        
    }

    //Metodo do menu de funcionarios
    public static void menuFuncionarios() {
        //adicionar, remover, listar e sair
        int op = 0;
        try {
            op = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das opcoes:\n1-Adicionar funcionario\n2-Remover funcionario\n3-Mostrar funcionario\n4-Voltar"));
            if (op < 1 || op > 4) {
                throw new MenuException(op);
            }
        } catch (MenuException ex) {
            JOptionPane.showMessageDialog(null, "Opção inválida");
            menu();
        }
        switch (op) {
            case 1:
                funcionarios.add(setFuncionario());
                menuFuncionarios();
            case 2:
                funcionarios.remove(getFuncionario(JOptionPane.showInputDialog("Insira o nome do funcionario que deseja remover"), funcionarios));
                menuFuncionarios();
            case 3:
                mostraFuncionarios(funcionarios);
                menuFuncionarios();
            case 4:
                menu();
        }
    }

    public static void mostraEstoque(ArrayList<Veiculo> veiculos) {
        for (Veiculo mostrar : veiculos) {
            JOptionPane.showMessageDialog(null, "Marca:" + mostrar.getMarca() + "\nMOdelo:" + mostrar.getModelo() + "\nClasse:" + mostrar.getClasse() + "\nPreco:" + mostrar.getPreco() + "\nEspecificacao:" + mostrar.getEspecificacoes() + "\nEstoque:" + mostrar.getEstoque());
        }
    }

    //Metodo do menu de estoque
    public static void menuEstoque() {
        //adicionar, remover,listar e sair
        int op = 0;
        try {
            op = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das opcoes:\n1-Adicionar veiculo\n2-Remover veiculo\n3-Mostrar veiculos\n4-Voltar"));
            while (op < 1 || op > 4) {
                throw new MenuException(op);
            }
        } catch (MenuException ex) {
            JOptionPane.showMessageDialog(null, "Opção inválida");
            menu();
        }
        switch (op) {
            case 1:
                veiculos.add(setVeiculo());
                menuEstoque();
            case 2:
                veiculos.remove(getVeiculo(JOptionPane.showInputDialog("Insira o modelo do veiculo que deseja remover"),setEspecificacao(), veiculos));
                menuEstoque();
            case 3:
                mostraEstoque(veiculos);
                menuEstoque();
            case 4:
                menu();
        }
    }

    //Metodo do menu principal
    public static void menu() {
        int op = 0;
        try {
            op = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das opcoes:\n1-Manejar funcionarios\n2-Manejar estoque\n3-Iniciar venda\n4-Sair"));
            if (op < 1 || op > 4) {
                throw new MenuException(op);
            }
        } catch (MenuException ex) {
            JOptionPane.showMessageDialog(null, "Opção inválida");
            menu();
        }
        switch (op) {
            case 1:
                menuFuncionarios();
            case 2:
                menuEstoque();
            case 3:
                vendas.add(setVenda());
                JOptionPane.showMessageDialog(null, "Venda realizada com sucesso");
                menu();
            case 4:
                try {
                    ManipuladorArquivo.escritor(funcionarios, veiculos, vendas);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo");
                    exit(0);
                }
                setSalario(vendas,funcionarios);
                exit(0);
        }
    }

    //Metodo que testa os arquivos
    public static void fOpen() {
        //Testa funcionarios
        if (!fileFuncionarios.exists()) {
            try {
                fileFuncionarios.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao criar arquivo");
                exit(0);
            }
        }
        //Testa Veiculos
        if (!fileVeiculos.exists()) {
            try {
                fileVeiculos.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao criar arquivo");
                exit(0);
            }
        }
        //Testa vendas
        if (!fileVendas.exists()) {
            try {
                fileVendas.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao criar arquivo");
                exit(0);
            }
        }
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Sistema de gerenciamento cocessionario");
        fOpen();
        //Lê os funcionarios
        try {
            funcionarios = ManipuladorArquivo.leitorFuncionarios();
        } catch (IOException | CnpjException | CpfException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo f");
            exit(1);
        }
        //Lê os veiculos
        try {
            veiculos = ManipuladorArquivo.leitorVeiculos();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo v");
            exit(1);
        }
        //Lê as vendas
        /*try {
            vendas = ManipuladorArquivo.leitorVendas();
        } catch (IOException | CnpjException | CpfException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo V");
            exit(1);
        }
        */
        menu();
    }
}
