package sistemaagenciaviagens.view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import sistemaagenciaviagens.controller.FuncionarioController;

public class FuncionarioView {

    private FuncionarioController controlador;
    
    /**
    * Método Construtor FuncionarioView: 
    * 
    * Chama o Menu de Funcionario e instancia um controlador
    */
    public FuncionarioView() {
	this.controlador = new FuncionarioController();
        
        this.menu();
    }

    /**
    * Menu de Funcionario: 
    * 
    * Será utilizado para escolher as opcoes de cadastrar, alterar, listar ou 
    * excluir um Funcionario
    */
    private void menu() {
        
        Scanner s = new Scanner(System.in);
        
        int opc = 0;
        
        do {
            System.out.println("\n\n--------MENU DE FUNCIONÁRIO--------");
            System.out.println("1 - Cadastrar Novo Funcionário");
            System.out.println("2 - Alterar Funcionário");
            System.out.println("3 - Listar Todos os Funcionário");
            System.out.println("4 - Excluir Funcionário");
            System.out.println("0 - Voltar");

            System.out.print("\nSelecionar opção: ");
            opc = Integer.parseInt(s.nextLine());

            switch (opc) {
                case 0: {
                    break;
                }
                case 1: {
                    this.novo();
                    break;
                }
                case 2: {
                    this.altera();
                    break;
                }
                case 3: {
                    this.lista();
                    break;
                }
                case 4: {
                    this.excluir();
                    break;
                }

            }

        } while (opc != 0);
        
    }

    /**
    * Método novo: 
    * 
    * Cria um novo Funcionario e envia todos os atributos para o controlador
    */
    private void novo() {
        
        Scanner s = new Scanner(System.in);
        
        // Pessoa
        String nome = "";
        String telefone = "";
        String cep = "";
        String estado = "";
        String cidade = "";
        String bairro = "";
        String rua = "";
        String numero = "";
        // Funcionario
        String dataAdmissao = "";
        String dataDemissao = "";

        do {
            if(nome.equals("")){
                System.out.println("Nome: ");
                nome = s.nextLine();
            }

            if(telefone.equals("")){
                System.out.println("Telefone: ");
                telefone = s.nextLine();    
            }

            if(cep.equals("")){
                System.out.println("CEP: ");
                cep = s.nextLine();
            }

            if(estado.equals("")){
                System.out.println("Estado: ");
                estado = s.nextLine();
            }

            if(cidade.equals("")){
                System.out.println("Cidade: ");
                cidade = s.nextLine();
            }

            if(bairro.equals("")){
                System.out.println("Bairro: ");
                bairro = s.nextLine();    
            }
            
            if(rua.equals("")){
                System.out.println("Rua: ");
                rua = s.nextLine();
            }

            if(numero.equals("")){
                System.out.println("Número: ");
                numero = s.nextLine();
            }

            if(dataAdmissao.equals("")){
                System.out.println("Data de Admissão: ");
                dataAdmissao = s.nextLine();
            }

                
            System.out.println("Data de Demissão: ");
            dataDemissao = s.nextLine();
            
            // Marcador para saber se não há data de demissão
            if(dataDemissao.equals("")){
                dataDemissao = "11/11/9999";
            }

            try {
                this.controlador.salvar(0, nome, telefone, cep, estado, cidade, bairro,
                        rua, numero, dataAdmissao, dataDemissao);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }while((nome.equals("")) || (telefone.equals("")) || (cep.equals("")) ||
                (estado.equals("")) || (cidade.equals("")) || (bairro.equals(""))
                || (rua.equals("")) || (numero.equals("")) || (dataAdmissao.equals("")));
        
    }

    /**
    * Método alterar: 
    * 
    * Altera alguma informacao do Funcionario informado atraves do codigo e 
    * envia todos os atributos para o controlador novamente
    */
    private void altera() {
        
        Scanner s = new Scanner(System.in);
        
        int codigo;

        System.out.println("Insira o código do funcionário a ser alterado: ");
        codigo = Integer.parseInt(s.nextLine());
        
        this.controlador.buscar(codigo);
        
        if(this.controlador.getFuncionario() == null){
            System.out.println("Não existe um funcionario cadastrado com esse código!\n");
        }
        else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            System.out.println("Código: "+ this.controlador.getFuncionario().getCodigo()+ 
            "\nNome: "+ this.controlador.getFuncionario().getNome()+ 
            "\nTelefone: "+ this.controlador.getFuncionario().getTelefone()+ 
            "\nCEP: "+ this.controlador.getFuncionario().getCep()+ 
            "\nEstado: "+ this.controlador.getFuncionario().getEstado()+ 
            "\nCidade: "+ this.controlador.getFuncionario().getCidade()+ 
            "\nBairro: "+ this.controlador.getFuncionario().getBairro()+ 
            "\nRua: "+ this.controlador.getFuncionario().getRua()+ 
            "\nNumero: "+ this.controlador.getFuncionario().getNumero()+ 
            "\nData Admissão: "+ sdf.format(this.controlador.getFuncionario().getDataAdmissao().getTime()));
            
            // Caso não haja data de demissao
            if(sdf.format(this.controlador.getFuncionario().getDataDemissao().getTime()).equals("11/11/9999")){
                System.out.println("Data Demissão: funcionário ativo");
            }
            else{
                System.out.println("Data Demissão: "+ 
                        sdf.format(this.controlador.getFuncionario().getDataDemissao().getTime()));
            }
            
            System.out.println("Deseja realmente alterar esse funcionário? (0 - Não | 1 - Sim): ");
            int op = Integer.parseInt(s.nextLine());
            
            if (op == 1) {
                // Pessoa
                String nome = "";
                String telefone = "";
                String cep = "";
                String estado = "";
                String cidade = "";
                String bairro = "";
                String rua = "";
                String numero = "";
                // Funcionario
                String dataAdmissao = "";
                String dataDemissao = "";

                do {
                    if (nome.equals("")) {
                        System.out.println("Nome: ");
                        nome = s.nextLine();
                    }

                    if (telefone.equals("")) {
                        System.out.println("Telefone: ");
                        telefone = s.nextLine();
                    }

                    if (cep.equals("")) {
                        System.out.println("CEP: ");
                        cep = s.nextLine();
                    }

                    if (estado.equals("")) {
                        System.out.println("Estado: ");
                        estado = s.nextLine();
                    }

                    if (cidade.equals("")) {
                        System.out.println("Cidade: ");
                        cidade = s.nextLine();
                    }

                    if (bairro.equals("")) {
                        System.out.println("Bairro: ");
                        bairro = s.nextLine();
                    }

                    if (rua.equals("")) {
                        System.out.println("Rua: ");
                        rua = s.nextLine();
                    }

                    if (numero.equals("")) {
                        System.out.println("Número: ");
                        numero = s.nextLine();
                    }

                    if (dataAdmissao.equals("")) {
                        System.out.println("Data de Admissão: ");
                        dataAdmissao = s.nextLine();
                    }

                    System.out.println("Data de Demissão: ");
                    dataDemissao = s.nextLine();
                    
                    // Marcador para saber se não há data de demissão
                    if(dataDemissao.equals("")){
                        dataDemissao = "11/11/9999";
                    }
                        
                    try {
                        this.controlador.salvar(this.controlador.getFuncionario().getCodigo(),
                                nome, telefone, cep, estado, cidade, bairro,
                                rua, numero, dataAdmissao, dataDemissao);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                } while ((nome.equals("")) || (telefone.equals("")) || (cep.equals(""))
                        || (estado.equals("")) || (cidade.equals("")) || (bairro.equals(""))
                        || (rua.equals("")) || (numero.equals("")) || (dataAdmissao.equals("")));
            }
        }
                
    }

    /**
    * Método listar: 
    * 
    * Lista todos os Funciarios que foram cadastrados chamando o controlador
    */
    private void lista() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        this.controlador.buscarTodos();
      
        for(int i=0; i<this.controlador.getListaDeFuncionarios().size(); i++){
            System.out.print("\n--------------------------------------------\n");
            
            System.out.println("Codigo: " + this.controlador.getListaDeFuncionarios().get(i).getCodigo()+
            "\nNome: "+ this.controlador.getListaDeFuncionarios().get(i).getNome()+ 
            "\nTelefone: "+ this.controlador.getListaDeFuncionarios().get(i).getTelefone()+
            "\nCEP: "+ this.controlador.getListaDeFuncionarios().get(i).getCep()+ 
            "\nEstado: "+ this.controlador.getListaDeFuncionarios().get(i).getEstado()+
            "\nCidade: "+ this.controlador.getListaDeFuncionarios().get(i).getCidade()+
            "\nBairro: "+ this.controlador.getListaDeFuncionarios().get(i).getBairro()+
            "\nRua: "+ this.controlador.getListaDeFuncionarios().get(i).getRua()+ 
            "\nNúmero: "+ this.controlador.getListaDeFuncionarios().get(i).getNumero()+
            "\nData Admissão: "+ sdf.format(this.controlador.getListaDeFuncionarios().get(i).getDataAdmissao().getTime()));
            
            // Caso não haja data de demissao
            if((sdf.format(this.controlador.getListaDeFuncionarios().get(i).getDataDemissao().getTime())).equals("11/11/9999")){
                System.out.println("Data Demissão: funcionário ativo");
            }
            else{
                System.out.println("Data Demissão: "+ 
                        sdf.format(this.controlador.getListaDeFuncionarios().get(i).getDataDemissao().getTime()));
            }
        }
    }

    /**
    * Método excluir: 
    * 
    * Excluir o Funcionario informado pelo código chamando o controlador
    */
    private void excluir() {
        
        Scanner s = new Scanner(System.in);
        
        int codigo, opc;

        System.out.println("Insira o código do funcionário a ser excluido: ");
        codigo = Integer.parseInt(s.nextLine());
        
        this.controlador.buscar(codigo);
        
        if(this.controlador.getFuncionario() == null){
            System.out.println("Não existe um funcionario cadastrado com esse código!\n");
        }
        else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            System.out.println("Código: "+ this.controlador.getFuncionario().getCodigo()+ 
            "\nNome: "+ this.controlador.getFuncionario().getNome()+ 
            "\nTelefone: "+ this.controlador.getFuncionario().getTelefone()+ 
            "\nCEP: "+ this.controlador.getFuncionario().getCep()+ 
            "\nEstado: "+ this.controlador.getFuncionario().getEstado()+ 
            "\nCidade: "+ this.controlador.getFuncionario().getCidade()+ 
            "\nBairro: "+ this.controlador.getFuncionario().getBairro()+ 
            "\nRua: "+ this.controlador.getFuncionario().getRua()+ 
            "\nNumero: "+ this.controlador.getFuncionario().getNumero()+ 
            "\nData Admissão: "+ sdf.format(this.controlador.getFuncionario().getDataAdmissao().getTime()));
            
            // Caso não haja data de demissao
            if(sdf.format(this.controlador.getFuncionario().getDataDemissao().getTime()).equals("11/11/9999")){
                System.out.println("Data Demissão: funcionário ativo");
            }
            else{
                System.out.println("Data Demissão: "+ 
                        sdf.format(this.controlador.getFuncionario().getDataDemissao().getTime()));
            }
            
            System.out.println("Deseja realmente excluir esse funcionário? (0 - Não | 1 - Sim): ");
            int op = Integer.parseInt(s.nextLine());
        
            if(op == 1){
                try {
                    this.controlador.excluir(this.controlador.getFuncionario().getCodigo());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        
    }

}
