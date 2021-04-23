package sistemaagenciaviagens.view;

import java.util.Calendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;

import sistemaagenciaviagens.controller.ClienteController;

public class ClienteView {

    private ClienteController controlador;
    
    /**
    * Método Construtor de ClienteView: 
    * 
    * Chama o Menu de Cliente e instancia um controlador
    */
    public ClienteView() {
	this.controlador = new ClienteController();
        
        this.menu();
    }

    /**
    * Menu de Cliente: 
    * 
    * Será utilizado para escolher as opcoes de cadastrar, alterar, listar ou 
    * excluir um Cliente
    */
    private void menu() {
        
        Scanner s = new Scanner(System.in);
        
        int opc = 0;
        
        do {
            System.out.println("\n\n-------MENU DE CLIENTE-------");
            System.out.println("1 - Cadastrar Novo Cliente");
            System.out.println("2 - Alterar Cliente");
            System.out.println("3 - Listar Todos os Clientes");
            System.out.println("4 - Excluir Cliente");
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
    * Cria um novo Cliente e envia todos os atributos para o controlador
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
        // Cliente
        String rg = "";
        String cpf = "";
        String dataNascimento = "";
        // Associação com plano
        int codigoPlano = 0;

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

            if((rg.equals(""))){
                System.out.println("RG: ");
                rg = s.nextLine();
            }

            if(cpf.equals("")){
                System.out.println("CPF: ");
                cpf = s.nextLine();
            }

            if(dataNascimento.equals("")){
                System.out.println("Data de Nascimento: ");
                dataNascimento = s.nextLine();
            }
            
            if(codigoPlano <= 0){
                System.out.println("Código do plano: ");
                codigoPlano = Integer.parseInt(s.nextLine());
                
                this.controlador.buscaPlanoCodigo(codigoPlano);
                
                if(this.controlador.getPlano() == null){
                    System.out.println("\nEste código de plano não existe. Tente outro\n");
                    
                    codigoPlano = 0;
                }
            }
        }while((nome.equals("")) || (telefone.equals("")) || 
                (cep.equals("")) || (estado.equals("")) || (cidade.equals("")) 
                || (bairro.equals("")) || (rua.equals("")) || (numero.equals(""))
                || (rg.equals("")) || (cpf.equals("")) || (dataNascimento.equals(""))
                || (codigoPlano <= 0));

        try{
            this.controlador.salvar(0, nome, telefone, cep, estado, cidade, bairro,
        rua, numero, rg, cpf, dataNascimento, this.controlador.getPlano());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
    * Método alterar: 
    * 
    * Altera alguma informacao do Cliente informado atraves do codigo e envia 
    * todos os atributos para o controlador novamente
    */
    private void altera() {
        
        Scanner s = new Scanner(System.in);
        
        int codigo;
        
        System.out.println("Insira o código do cliente a ser alterado: ");
        codigo = Integer.parseInt(s.nextLine());
        
        this.controlador.buscar(codigo);
        
        if(this.controlador.getCliente() == null){
            System.out.println("Não existe nenhum cliente com esse código!\n");
        }
        else {
            SimpleDateFormat formatacao = new SimpleDateFormat("dd/MM/yyyy");
            
            System.out.println("Código: "+ this.controlador.getCliente().getCodigo()+
            "\nNome: "+ this.controlador.getCliente().getNome()+
            "\nTelefone: "+ this.controlador.getCliente().getTelefone()+
            "\nCEP: "+ this.controlador.getCliente().getCep()+
            "\nEstado: "+ this.controlador.getCliente().getEstado()+
            "\nCidade: "+ this.controlador.getCliente().getCidade()+
            "\nBairro: "+ this.controlador.getCliente().getBairro()+
            "\nRua: "+ this.controlador.getCliente().getRua()+
            "\nNumero: "+ this.controlador.getCliente().getNumero()+
            "\nRG: "+ this.controlador.getCliente().getRg()+
            "\nCPF: "+ this.controlador.getCliente().getCpf()+
            "\nData Nascimento: "+ formatacao.format(this.controlador.getCliente().getDataNascimento().getTime())+
            "\n\nPlano de "+ this.controlador.getCliente().getNome()+
            "\nCódigo do plano: "+ this.controlador.getCliente().getPlano().getCodigo()+
            "\nValor do plano: "+ this.controlador.getCliente().getPlano().getValor()+
            "\nCEP destino: "+ this.controlador.getCliente().getPlano().getLocal().getCepDestino()+
            "\nPais Destino: "+ this.controlador.getCliente().getPlano().getLocal().getPaisDestino()+
            "\nEstado Destino: "+ this.controlador.getCliente().getPlano().getLocal().getEstadoDestino()+
            "\nCidade Destino: "+ this.controlador.getCliente().getPlano().getLocal().getCidadeDestino()+
            "\nData de ida: "+ formatacao.format(this.controlador.getCliente().getPlano().getDataIda().getTime())+
            "\nData de volta: "+ formatacao.format(this.controlador.getCliente().getPlano().getDataVolta().getTime()));
            
            System.out.println("Deseja realmente alterar esse cliente? (0 - Não | 1 - Sim): ");
            int op = Integer.parseInt(s.nextLine());
            
            if (op == 1) {
                String nome = "";
                String telefone = "";
                String cep = "";
                String estado = "";
                String cidade = "";
                String bairro = "";
                String rua = "";
                String numero = "";
                String rg = "";
                String cpf = "";
                String dataNascimento = "";

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

                    if (rg.equals("")) {
                        System.out.println("RG: ");
                        rg = s.nextLine();
                    }

                    if (cpf.equals("")) {
                        System.out.println("CPF: ");
                        cpf = s.nextLine();
                    }

                    if (dataNascimento.equals("")) {
                        System.out.println("Data de Nascimento: ");
                        dataNascimento = s.nextLine();
                    }
                } while ((nome.equals("")) || (telefone.equals(""))
                        || (cep.equals("")) || (estado.equals("")) || (cidade.equals(""))
                        || (bairro.equals("")) || (rua.equals("")) || (numero.equals(""))
                        || (rg.equals("")) || (cpf.equals("")) || (dataNascimento.equals("")));
                
                try {
                    this.controlador.salvar(this.controlador.getCliente().getCodigo(),
                            nome, telefone, cep, estado, cidade, bairro, rua,
                            numero, rg, cpf, dataNascimento, 
                            this.controlador.getCliente().getPlano());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        
    }

    /**
    * Método listar: 
    * 
    * Lista todos os Clientes que foram cadastrados chamando o controlador
    */
    private void lista() {
        SimpleDateFormat formatacao = new SimpleDateFormat();
        
        this.controlador.buscarTodos();

        for (int i = 0; i < this.controlador.getListaDeClientes().size(); i++) {
            System.out.print("\n--------------------------------------------\n");
            
            System.out.println("Código: "+ this.controlador.getListaDeClientes().get(i).getCodigo()+
            "\nNome: "+ this.controlador.getListaDeClientes().get(i).getNome()+
            "\nTelefone: "+ this.controlador.getListaDeClientes().get(i).getTelefone()+
            "\nCEP: "+ this.controlador.getListaDeClientes().get(i).getCep()+
            "\nEstado: "+ this.controlador.getListaDeClientes().get(i).getEstado()+
            "\nCidade: "+ this.controlador.getListaDeClientes().get(i).getCidade()+
            "\nBairro: "+ this.controlador.getListaDeClientes().get(i).getBairro()+
            "\nRua: "+ this.controlador.getListaDeClientes().get(i).getRua()+
            "\nNumero: "+ this.controlador.getListaDeClientes().get(i).getNumero()+
            "\nRG: "+ this.controlador.getListaDeClientes().get(i).getRg()+
            "\nCPF: "+ this.controlador.getListaDeClientes().get(i).getCpf()+
            "\nData Nascimento: "+ formatacao.format(this.controlador.getListaDeClientes().get(i).getDataNascimento().getTime())+
            "\n\nPlano de "+ this.controlador.getListaDeClientes().get(i).getNome()+
            "\nCódigo do plano: "+ this.controlador.getListaDeClientes().get(i).getPlano().getCodigo()+
            "\nValor do plano: "+ this.controlador.getListaDeClientes().get(i).getPlano().getValor()+
            "\nCEP Destino: "+ this.controlador.getListaDeClientes().get(i).getPlano().getLocal().getCepDestino()+
            "\nPais Destino: "+ this.controlador.getListaDeClientes().get(i).getPlano().getLocal().getPaisDestino()+
            "\nEstado Destino: "+ this.controlador.getListaDeClientes().get(i).getPlano().getLocal().getEstadoDestino()+
            "\nCidade Destino: "+ this.controlador.getListaDeClientes().get(i).getPlano().getLocal().getCidadeDestino()+
            "\nData de ida: "+ formatacao.format(this.controlador.getListaDeClientes().get(i).getPlano().getDataIda().getTime())+
            "\nData de volta: "+ formatacao.format(this.controlador.getListaDeClientes().get(i).getPlano().getDataVolta().getTime()));
        }
    }

    /**
    * Método excluir: 
    * 
    * Excluir o Cliente informado pelo código chamando o controlador
    */
    private void excluir() {
        
        Scanner s = new Scanner(System.in);
        
        int codigo, opc;

        System.out.println("Insira o código do cliente a ser excluido: ");
        codigo = Integer.parseInt(s.nextLine());
        
        this.controlador.buscar(codigo);
        
        if(this.controlador.getCliente() == null){
            System.out.println("Não existe nenhum cliente com esse código!\n");
        }
        else {
            SimpleDateFormat formatacao = new SimpleDateFormat("dd/MM/yyyy");
            
            System.out.println("Código: "+ this.controlador.getCliente().getCodigo()+
            "\nNome: "+ this.controlador.getCliente().getNome()+
            "\nTelefone: "+ this.controlador.getCliente().getTelefone()+
            "\nCEP: "+ this.controlador.getCliente().getCep()+
            "\nEstado: "+ this.controlador.getCliente().getEstado()+
            "\nCidade: "+ this.controlador.getCliente().getCidade()+
            "\nBairro: "+ this.controlador.getCliente().getBairro()+
            "\nRua: "+ this.controlador.getCliente().getRua()+
            "\nNumero: "+ this.controlador.getCliente().getNumero()+
            "\nRG: "+ this.controlador.getCliente().getRg()+
            "\nCPF: "+ this.controlador.getCliente().getCpf()+
            "\nData Nascimento: "+ formatacao.format(this.controlador.getCliente().getDataNascimento().getTime())+
            "\n\nPlano de "+ this.controlador.getCliente().getNome()+
            "\nCódigo do plano: "+ this.controlador.getCliente().getPlano().getCodigo()+
            "\nValor do plano: "+ this.controlador.getCliente().getPlano().getValor()+
            "\nCEP destino: "+ this.controlador.getCliente().getPlano().getLocal().getCepDestino()+
            "\nPais Destino: "+ this.controlador.getCliente().getPlano().getLocal().getPaisDestino()+
            "\nEstado Destino: "+ this.controlador.getCliente().getPlano().getLocal().getEstadoDestino()+
            "\nCidade Destino: "+ this.controlador.getCliente().getPlano().getLocal().getCidadeDestino()+
            "\nData de ida: "+ formatacao.format(this.controlador.getCliente().getPlano().getDataIda().getTime())+
            "\nData de volta: "+ formatacao.format(this.controlador.getCliente().getPlano().getDataVolta().getTime()));
            
            System.out.println("Deseja realmente excluir esse funcionário? (0 - Não | 1 - Sim): ");
            int op = Integer.parseInt(s.nextLine());
        
            if(op == 1){
                try {
                    this.controlador.excluir(codigo);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }
}
