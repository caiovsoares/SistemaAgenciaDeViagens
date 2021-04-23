package sistemaagenciaviagens.view;

import java.util.Scanner;

import sistemaagenciaviagens.controller.TransporteController;

public class TransporteView {

    private TransporteController controlador;

    /**
    * Método Construtor de TransporteView: 
    * 
    * Chama o Menu de Transporte e instancia um controlador
    */
    public TransporteView() {
        this.controlador = new TransporteController();
        
        this.menu();
    }
    
    /**
    * Menu de Transporte: 
    * 
    * Será utilizado para escolher as opcoes de cadastrar, alterar, listar ou 
    * excluir um Transporte
    */
    private void menu() {

        Scanner s = new Scanner(System.in);
        
        int opc = 0;
        
        do {
            System.out.println("\n\n--------MENU DE TRANSPORTE--------");
            System.out.println("1 - Cadastrar Novo Transporte");
            System.out.println("2 - Alterar Transporte");
            System.out.println("3 - Listar Todos os Transportes");
            System.out.println("4 - Excluir Transporte");
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
    * Cria um novo Transporte e envia todos os atributos para o controlador
    */
    private void novo() {
        Scanner s = new Scanner(System.in);

        String nomeEmpresa = "";
        String veiculo = "";
        
        int op = 3;

        do {
            if(nomeEmpresa.equals("")){
                System.out.println("Nome da Empresa: ");
                nomeEmpresa = s.nextLine();
            }

            if (op == 3) {
                System.out.println("Tipo de Veículo:");
                System.out.println("1 - Avião");
                System.out.println("2 - Ônibus");
                op = Integer.parseInt(s.nextLine());

                switch (op) {
                    case 1:
                        veiculo = "Avião";
                        break;
                    case 2:
                        veiculo = "Ônibus";
                        break;
                    default:
                        System.out.println("Opção inexistente\n");
                        op = 3;
                        break;
                }
            }
        }while((nomeEmpresa.equals("")) || (op == 3));

        try{
            this.controlador.salvar(0, nomeEmpresa, veiculo);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
    /**
    * Método alterar: 
    * 
    * Altera alguma informacao do Transporte informado atraves do codigo e envia 
    * todos os atributos para o controlador novamente
    */
    private void altera() {
        
        Scanner s = new Scanner(System.in);
        
        int codigo;

        System.out.println("Insira o código do transporte a ser alterado: ");
        codigo = Integer.parseInt(s.nextLine());
        
        this.controlador.buscar(codigo);
        
        if(this.controlador.getTransporte() == null){
            System.out.println("Não existe nenhum transporte com esse código!\n");
        }
        else {
            System.out.println("Código: "+ this.controlador.getTransporte().getCodigo()+
            "\nNome da empresa: "+ this.controlador.getTransporte().getNomeEmpresa()+
            "\nVeículo: "+ this.controlador.getTransporte().getVeiculo());
            
            System.out.println("Deseja realmente alterar esse transporte? (0 - Não | 1 - Sim): ");
            int op = Integer.parseInt(s.nextLine());
            
            if (op == 1) {
                op = 3;
                
                String nomeEmpresa = "";
                String veiculo = "";

                do {
                    if (nomeEmpresa.equals("")) {
                        System.out.println("Nome da Empresa: ");
                        nomeEmpresa = s.nextLine();
                    }

                    if (op == 3) {
                        System.out.println("Tipo de Veículo:");
                        System.out.println("1 - Avião");
                        System.out.println("2 - Ônibus");
                        op = Integer.parseInt(s.nextLine());

                        switch (op) {
                            case 1:
                                veiculo = "Avião";
                                break;
                            case 2:
                                veiculo = "Ônibus";
                                break;
                            default:
                                System.out.println("Opção inexistente\n");
                                op = 3;
                                break;
                        }
                    }

                } while ((nomeEmpresa.equals("")) || (op == 3));
                
                try {
                    this.controlador.salvar(this.controlador.getTransporte().getCodigo(),
                            nomeEmpresa, veiculo);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
       
    }

    /**
    * Método listar: 
    * 
    * Lista todos os Transportes que foram cadastrados chamando o controlador
    */
    private void lista() {
        this.controlador.buscarTodos();
      
        for(int i = 0; i < this.controlador.getListaTransporte().size(); i++){          
            System.out.print("\n--------------------------------------------\n");
            
            System.out.println("Código: "+ this.controlador.getListaTransporte().get(i).getCodigo()+
            "\nNome da empresa: "+ this.controlador.getListaTransporte().get(i).getNomeEmpresa()+
            "\nVeículo: "+ this.controlador.getListaTransporte().get(i).getVeiculo());
        }
    }

    /**
    * Método excluir: 
    * 
    * Excluir o Transporte informado pelo codigo chamando o controlador
    */
    private void excluir() {
        
        Scanner s = new Scanner(System.in);
        
        int codigo, opc;

        System.out.println("Insira o código do transporte a ser excluido: ");
        codigo = Integer.parseInt(s.nextLine());
        
        this.controlador.buscar(codigo);
        
        if(this.controlador.getTransporte() == null){
            System.out.println("Não existe nenhum transporte com esse código!\n");
        }
        else {
            System.out.println("Código: "+ this.controlador.getTransporte().getCodigo()+
            "\nNome da empresa: "+ this.controlador.getTransporte().getNomeEmpresa()+
            "\nVeículo: "+ this.controlador.getTransporte().getVeiculo());
            
            System.out.println("Deseja realmente alterar esse transporte? (0 - Não | 1 - Sim): ");
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
