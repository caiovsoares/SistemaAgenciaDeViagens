package sistemaagenciaviagens.view;

import java.util.Scanner;

import sistemaagenciaviagens.controller.HotelController;

public class HotelView {

    private HotelController controlador;

    /**
    * Método Construtor de HotelView: 
    * 
    * Chama o Menu de Hotel e instancia um controlador
    */
    public HotelView() {
	this.controlador = new HotelController();
        
        this.menu();
    }

    /**
    * Menu de Hotel: 
    * 
    * Será utilizado para escolher as opcoes de cadastrar, alterar, listar ou 
    * excluir um Hotel
    */
    private void menu() {
        
        Scanner s = new Scanner(System.in);
        
        int opc = 0;
        
        do {

            System.out.println("\n\n-------MENU DE HOTEL-------");
            System.out.println("1 - Cadastrar Novo Hotel");
            System.out.println("2 - Alterar Hotel");
            System.out.println("3 - Listar Todos os Hotéis");
            System.out.println("4 - Excluir Hotel");
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
    * Cria um novo Hotel e envia todos os atributos para o controlador
    */
    private void novo() {
        
        Scanner s = new Scanner(System.in);
        
        String nomeHotel = "";
        String classificacao = "";
        String bairro = "";
        String rua = "";
        String numero = "";

        do {
            if(nomeHotel.equals("")){
                System.out.println("Nome do hotel: ");
                nomeHotel = s.nextLine();
            }
            
            if(classificacao.equals("")){
                System.out.println("Classificação: ");
                classificacao = s.nextLine();
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
        } while((numero.equals("")) || (classificacao.equals("")) || (bairro.equals("")) || 
                (rua.equals("")) || (numero.equals("")));

        try{
            this.controlador.salvar(0, nomeHotel, classificacao, bairro, rua, numero);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }

    /**
    * Método alterar: 
    * 
    * Altera alguma informacao do Hotel informado atraves do codigo e envia 
    * todos os atributos para o controlador novamente
    */
    private void altera() {
        
        Scanner s = new Scanner(System.in);
        
        int codigo;

        System.out.println("Insira o código do hotel a ser alterado: ");
        codigo = Integer.parseInt(s.nextLine());

        this.controlador.buscar(codigo);
        
        if(this.controlador.getHotel() == null){
            System.out.println("Não existe nenhum hotel com esse código!\n");
        }
        else {
            System.out.println("Código: "+ this.controlador.getHotel().getCodigo()+
            "\nNome do hotel: "+ this.controlador.getHotel().getNomeHotel()+
            "\nClassificação: "+ this.controlador.getHotel().getClassificacao()+
            "\nBairro: "+ this.controlador.getHotel().getBairro()+
            "\nRua: "+ this.controlador.getHotel().getRua()+
            "\nNúmero: "+ this.controlador.getHotel().getNumero());
            
            System.out.println("Deseja realmente alterar esse hotel? (0 - Não | 1 - Sim): ");
            int op = Integer.parseInt(s.nextLine());
            
            if (op == 1) {
                String nomeHotel = "";
                String classificacao = "";
                String bairro = "";
                String rua = "";
                String numero = "";

                do {
                    if (nomeHotel.equals("")) {
                        System.out.println("Nome do hotel: ");
                        nomeHotel = s.nextLine();
                    }

                    if (classificacao.equals("")) {
                        System.out.println("Classificação: ");
                        classificacao = s.nextLine();
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
                } while ((numero.equals("")) || (classificacao.equals("")) || (bairro.equals(""))
                        || (rua.equals("")) || (numero.equals("")));
                
                try {
                    this.controlador.salvar(this.controlador.getHotel().getCodigo(),
                            nomeHotel, classificacao, bairro, rua, numero);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        
    }

    /**
    * Método listar: 
    * 
    * Lista todos os Hoteis que foram cadastrados chamando o controlador
    */
    private void lista() {
        this.controlador.buscaTodos();
      
        for(int i = 0; i < this.controlador.getListaHotel().size(); i++){          
            System.out.print("\n--------------------------------------------\n");
            
            System.out.println("Código: "+ this.controlador.getListaHotel().get(i).getCodigo()+
            "\nNome do hotel: "+ this.controlador.getListaHotel().get(i).getNomeHotel()+
            "\nClassificação: "+ this.controlador.getListaHotel().get(i).getClassificacao()+
            "\nBairro: "+ this.controlador.getListaHotel().get(i).getBairro()+
            "\nRua: "+ this.controlador.getListaHotel().get(i).getRua()+
            "\nNúmero: "+ this.controlador.getListaHotel().get(i).getNumero());
        }
    }
    
    /**
    * Método excluir: 
    * 
    * Excluir o Hotel informado pelo codigo chamando o controlador
    */
    private void excluir() {

        Scanner s = new Scanner(System.in);

        int codigo, opc;

        System.out.println("Insira o código do local a ser excluido: ");
        codigo = Integer.parseInt(s.nextLine());

        this.controlador.buscar(codigo);

        if (this.controlador.getHotel() == null) {
            System.out.println("Não existe nenhum hotel com esse código!\n");
        }
        else {
            System.out.println("Código: " + this.controlador.getHotel().getCodigo()
                    + "\nNome do hotel: " + this.controlador.getHotel().getNomeHotel()
                    + "\nClassificação: " + this.controlador.getHotel().getClassificacao()
                    + "\nBairro: " + this.controlador.getHotel().getBairro()
                    + "\nRua: " + this.controlador.getHotel().getRua()
                    + "\nNúmero: " + this.controlador.getHotel().getNumero());

            System.out.println("Deseja realmente alterar esse hotel? (0 - Não | 1 - Sim): ");
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
