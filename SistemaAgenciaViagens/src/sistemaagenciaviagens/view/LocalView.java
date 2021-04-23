package sistemaagenciaviagens.view;

import java.util.Scanner;

import sistemaagenciaviagens.controller.LocalController;

public class LocalView {

    private LocalController controlador;
    
    /**
    * Método Construtor de LocalView: 
    * 
    * Chama o Menu de Local e instancia um controlador
    */
    public LocalView() {
        this.controlador = new LocalController();
        
        this.menu();
    }

    /**
    * Menu de Local: 
    * 
    * Sera utilizado para escolher as opcoes de cadastrar, alterar, listar ou 
    * excluir um Local
    */
    private void menu() {
        
        Scanner s = new Scanner(System.in);
        
        int opc = 0;
        
        do {
            System.out.println("\n\n-------MENU DE LOCAL-------");
            System.out.println("1 - Cadastrar Novo Local");
            System.out.println("2 - Alterar Local");
            System.out.println("3 - Listar Todos os Locais");
            System.out.println("4 - Excluir Local");
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
    * Metodo novo: 
    * 
    * Cria um novo Local e envia todos os atributos para o controlador
    */
    private void novo() {
        
        Scanner s = new Scanner(System.in);
        
        String cepDestino = "";
        String paisDestino = "";
        String estadoDestino = "";
        String cidadeDestino = "";

        do {
            if(cepDestino.equals("")){
                System.out.println("CEP do Destino: ");
                cepDestino = s.nextLine();
            }

            if(paisDestino.equals("")){
                System.out.println("País de Destino: ");
                paisDestino = s.nextLine();
            }
            
            if(estadoDestino.equals("")){
                System.out.println("Estado do Destino: ");
                estadoDestino = s.nextLine();
            }
            
            if(cidadeDestino.equals("")){
                System.out.println("Cidade de Destino: ");
                cidadeDestino = s.nextLine();
            }

            try {
                this.controlador.salvar(0, cepDestino, paisDestino, estadoDestino,
                        cidadeDestino);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }while((cepDestino.equals("")) || (paisDestino.equals("")) || 
                (estadoDestino.equals("")) || (cidadeDestino.equals("")));
        
    }

    /**
    * Metodo alterar: 
    * 
    * Altera alguma informacao do Local informado atraves do codigo e envia 
    * todos os atributos para o controlador novamente
    */
    private void altera() {
        
        Scanner s = new Scanner(System.in);
        
        String cep;

        System.out.println("Insira o CEP do local a ser alterado: ");
        cep = s.nextLine();

        this.controlador.buscar(cep);
        
        if(this.controlador.getLocal() == null){
            System.out.println("Não existe um local cadastrado nesse CEP\n");
        }
        else{
            System.out.println("Código: "+ this.controlador.getLocal().getCodigo()+ 
                    "\nCEP: "+ this.controlador.getLocal().getCepDestino()+
                    "\nPais: "+ this.controlador.getLocal().getPaisDestino()+ 
                    "\nEstado: "+ this.controlador.getLocal().getEstadoDestino()+ 
                    "\nCidade: "+ this.controlador.getLocal().getCidadeDestino());
            
            System.out.println("Deseja realmente alterar esse local? "
                    + "(0 - Não | 1 - Sim): ");
            int op = Integer.parseInt(s.nextLine());
            
            if (op == 1) {
                String cepDestino = "";
                String paisDestino = "";
                String estadoDestino = "";
                String cidadeDestino = "";

                do {
                    if (cepDestino.equals("")) {
                        System.out.println("CEP do Destino: ");
                        cepDestino = s.nextLine();
                    }

                    if (paisDestino.equals("")) {
                        System.out.println("País de Destino: ");
                        paisDestino = s.nextLine();
                    }

                    if (estadoDestino.equals("")) {
                        System.out.println("Estado do Destino: ");
                        estadoDestino = s.nextLine();
                    }

                    if (cidadeDestino.equals("")) {
                        System.out.println("Cidade de Destino: ");
                        cidadeDestino = s.nextLine();
                    }

                    try {
                        this.controlador.salvar(this.controlador.getLocal().getCodigo(),
                                cepDestino, paisDestino, estadoDestino, cidadeDestino);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                } while ((cepDestino.equals("")) || (paisDestino.equals(""))
                        || (estadoDestino.equals("")) || (cidadeDestino.equals("")));
            }
        }
        
    }

    /**
    * Metodo listar: 
    * 
    * Lista todos os Locais que foram cadastrados chamando o controlador
    */
    private void lista() {
        this.controlador.buscarTodos();

        for (int i=0; i<this.controlador.getListaDeLocais().size(); i++) {
            System.out.print("\n--------------------------------------------\n");
            
            System.out.println("Codigo: " + this.controlador.getListaDeLocais().get(i).getCodigo() 
            + "\nCEP: " + this.controlador.getListaDeLocais().get(i).getCepDestino()
            + "\nPaís: "+ this.controlador.getListaDeLocais().get(i).getPaisDestino()
            + "\nEstado: "+ this.controlador.getListaDeLocais().get(i).getEstadoDestino()
            + "\nCidade:" + this.controlador.getListaDeLocais().get(i).getCidadeDestino());
        }
    }

    /**
    * Metodo excluir: 
    * 
    * Excluir o Local informado pelo código chamando o controlador
    */
    private void excluir(){
        
        Scanner s = new Scanner(System.in);
        
        int op;

        String cep;

        System.out.println("Insira o CEP do local a ser excluído: ");
        cep = s.nextLine();

        this.controlador.buscar(cep);
        
        if(this.controlador.getLocal() == null){
            System.out.println("Não existe um local cadastrado nesse CEP\n");
        }
        else {
            System.out.println("Código: " + this.controlador.getLocal().getCodigo()
                    + "\nCEP: " + this.controlador.getLocal().getCepDestino()
                    + "\nPaís: "+ this.controlador.getLocal().getPaisDestino()
                    + "\nEstado: "+ this.controlador.getLocal().getEstadoDestino()
                    + "\nCidade:" + this.controlador.getLocal().getCidadeDestino());

            System.out.println("Deseja realmente excluir esse local? "
                    + "(0 - Não | 1 - Sim): ");
            op = Integer.parseInt(s.nextLine());

            if(op == 1){
                try {
                    this.controlador.excluir(this.controlador.getLocal().getCodigo());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
                
        }
    }
    
}
