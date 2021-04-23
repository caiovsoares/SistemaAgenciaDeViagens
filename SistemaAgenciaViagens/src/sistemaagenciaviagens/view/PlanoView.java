package sistemaagenciaviagens.view;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import sistemaagenciaviagens.controller.PlanoController;

public class PlanoView {

    private PlanoController controlador;
    
    /**
     * Método Construtor de PlanoView:
     *
     * Chama o Menu de Plano e instancia um controlador
     */
    public PlanoView() {
        this.controlador = new PlanoController();

        this.menu();
    }

    /**
     * Menu de Plano:
     *
     * Será utilizado para escolher as opcoes de cadastrar, alterar, listar ou
     * excluir um Plano
     */
    private void menu() {

        Scanner s = new Scanner(System.in);

        int opc = 0;

        do {
            System.out.println("\n\n---MENU DE PLANO DE VIAGEM---");
            System.out.println("1 - Cadastrar Novo Plano");
            System.out.println("2 - Alterar Plano");
            System.out.println("3 - Listar Todos os Planos");
            System.out.println("4 - Excluir Plano");
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
     * Cria um novo Plano e envia todos os atributos para o controlador
     */
    private void novo() {

        Scanner s = new Scanner(System.in);

        double valor = 0.0;
        String dataIda = "";
        String dataVolta = "";

        int codigoCliente = 0;
        int codigoFuncionario = 0;
        int cepLocal = 0;
        int codigoHotel = 0;
        int codigoTransporte = 0;
        
        do {
            if(valor == 0){
                System.out.println("Valor do Plano: ");
                valor = Double.parseDouble(s.nextLine());
            }

            if(dataIda.equals("")){
                System.out.println("Data de Ida: ");
                dataIda = s.nextLine();
            }
            
            if(dataVolta.equals("")){
                System.out.println("Data de Volta: ");
                dataVolta = s.nextLine();
            }
            
            if(codigoFuncionario <= 0){
                System.out.println("Código do Funcionário: ");
                codigoFuncionario = Integer.parseInt(s.nextLine());
                
                this.controlador.buscaFuncionarioCodigo(codigoFuncionario);
                
                if(this.controlador.getFuncionario() == null){
                    System.out.println("Este código de funcionário não existe. Tente outro");
                    
                    codigoFuncionario = 0;
                }
            }

            if(cepLocal <= 0){
                System.out.println("CEP do Local: ");
                cepLocal = Integer.parseInt(s.nextLine());
                
                this.controlador.buscarLocalCEP(cepLocal);
                
                if(this.controlador.getLocal() == null){
                    System.out.println("Este código de local não existe. Tente outro");
                    
                    cepLocal = 0;
                }
            }

            if(codigoHotel <= 0){
                System.out.println("Código do Hotel: ");
                codigoHotel = Integer.parseInt(s.nextLine());
                
                this.controlador.buscarHotelCodigo(codigoHotel);
                
                if(this.controlador.getHotel() == null){
                    System.out.println("Este código de hotel não existe. Tente outro: ");
                    
                    codigoHotel = 0;
                }
            }

            if(codigoTransporte <= 0){
                System.out.println("Código do Transporte: ");
                codigoTransporte = Integer.parseInt(s.nextLine());  
                
                this.controlador.buscarTransporteCodigo(codigoTransporte);
                
                if(this.controlador.getTransporte() == null){
                    System.out.println("Este código de transporte não existe. Tente outro: ");
                    
                    codigoTransporte = 0;
                }
            }
        }while((valor == 0) || (dataIda.equals("")) || (dataVolta.equals("")) 
                || (codigoFuncionario <= 0) || (cepLocal <= 0) || (codigoHotel <= 0) 
                || (codigoTransporte <= 0));
        
        try {
            this.controlador.salvar(0, valor, dataIda, dataVolta, 
                    this.controlador.getFuncionario(), this.controlador.getLocal(), 
                    this.controlador.getHotel(), this.controlador.getTransporte());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método alterar:
     *
     * Altera alguma informacao do Plano informado atraves do codigo e envia
     * todos os atributos para o controlador novamente
     */
    private void altera() {

        Scanner s = new Scanner(System.in);

        int codigo;

        System.out.println("Insira o código do plano a ser alterado: ");
        codigo = Integer.parseInt(s.nextLine());
        
        this.controlador.buscar(codigo);
        
        if(this.controlador.getPlano() == null){
            System.out.println("\nNão existe nenhum plano com esse código");
        }
        else {
            SimpleDateFormat formatacao = new SimpleDateFormat("dd/MM/yyyy");
            
            System.out.println("Código: "+ this.controlador.getPlano().getCodigo()+
            "\nValor: "+ this.controlador.getPlano().getValor()+
            "\nData de ida: "+ formatacao.format(this.controlador.getPlano().getDataIda().getTime())+
            "\nData de volta: "+ formatacao.format(this.controlador.getPlano().getDataVolta().getTime())+
            "\n\nFuncionário"+
            "\nCódigo do funcionário: "+ this.controlador.getPlano().getFuncionario().getCodigo()+
            "\nNome do funcionário: "+ this.controlador.getPlano().getFuncionario().getNome()+
            "\n\nLocal Destino"+
            "\nCódigo do local: "+ this.controlador.getPlano().getLocal().getCodigo()+
            "\nCEP: "+ this.controlador.getPlano().getLocal().getCepDestino()+
            "\nPais: "+ this.controlador.getPlano().getLocal().getPaisDestino()+
            "\nEstado: "+ this.controlador.getPlano().getLocal().getEstadoDestino()+
            "\nCidade: "+ this.controlador.getPlano().getLocal().getCidadeDestino()+
            "\n\nHotel: "+
            "\nCódigo do hotel: "+ this.controlador.getPlano().getHotel().getCodigo()+
            "\nNome do hotel: "+ this.controlador.getPlano().getHotel().getNomeHotel()+
            " ("+ this.controlador.getPlano().getHotel().getClassificacao()+ ")"+
            "\n\nTransporte"+
            "\nCódigo do transporte: "+ this.controlador.getPlano().getTransporte().getCodigo()+
            "\nVeículo: "+ this.controlador.getPlano().getTransporte().getVeiculo());
            
            System.out.println("\nDeseja realmente alterar esse plano? (0 - Não | 1 - Sim): ");
            int op = Integer.parseInt(s.nextLine());
            
            if (op == 1) {
                double valor = 0;
                String dataIda = "";
                String dataVolta = "";
                int codigoFuncionario = 0;
                int cepLocal = 0;
                int codigoHotel = 0;
                int codigoTransporte = 0;

                do {
                    if (valor == 0) {
                        System.out.println("Valor do Plano: ");
                        valor = Double.parseDouble(s.nextLine());
                    }

                    if (dataIda.equals("")) {
                        System.out.println("Data de Ida: ");
                        dataIda = s.nextLine();
                    }

                    if (dataVolta.equals("")) {
                        System.out.println("Data de Volta: ");
                        dataVolta = s.nextLine();
                    }

                    if (codigoFuncionario <= 0) {
                        System.out.println("Código do Funcionário: ");
                        codigoFuncionario = Integer.parseInt(s.nextLine());

                        this.controlador.buscaFuncionarioCodigo(codigoHotel);

                        if (this.controlador.getFuncionario() == null) {
                            System.out.println("Este código de funcionário não existe. Tente outro");

                            codigoFuncionario = 0;
                        }
                    }

                    if (cepLocal <= 0) {
                        System.out.println("Código do Local: ");
                        cepLocal = Integer.parseInt(s.nextLine());

                        this.controlador.buscarLocalCEP(cepLocal);

                        if (this.controlador.getLocal() == null) {
                            System.out.println("Este código de local não existe. Tente outro");

                            cepLocal = 0;
                        }
                    }

                    if (codigoHotel <= 0) {
                        System.out.println("Código do Hotel: ");
                        codigoHotel = Integer.parseInt(s.nextLine());

                        this.controlador.buscarHotelCodigo(codigoHotel);

                        if (this.controlador.getHotel() == null) {
                            System.out.println("Este código de hotel não existe. Tente outro: ");

                            codigoHotel = 0;
                        }
                    }

                    if (codigoTransporte <= 0) {
                        System.out.println("Código do Transporte: ");
                        codigoTransporte = Integer.parseInt(s.nextLine());

                        this.controlador.buscarTransporteCodigo(codigoTransporte);

                        if (this.controlador.getTransporte() == null) {
                            System.out.println("Este código de transporte não existe. Tente outro: ");

                            codigoTransporte = 0;
                        }
                    }
                } while ((valor == 0) || (dataIda.equals("")) || (dataVolta.equals(""))
                        || (codigoFuncionario <= 0) || (cepLocal<= 0) || (codigoHotel <= 0)
                        || (codigoTransporte <= 0));

                try {
                    this.controlador.salvar(this.controlador.getPlano().getCodigo(), 
                            valor, dataIda, dataVolta, this.controlador.getPlano().getFuncionario(),
                            this.controlador.getPlano().getLocal(), 
                            this.controlador.getPlano().getHotel(), 
                            this.controlador.getPlano().getTransporte());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        
    }

    /**
     * Método listar:
     *
     * Lista todos os Planos que foram cadastrados chamando o controlador
     */
    private void lista() {
        SimpleDateFormat formatacao = new SimpleDateFormat("dd/MM/yyyy");
        
        this.controlador.buscarTodos();
      
        for(int i = 0; i < this.controlador.getListaDePlanos().size(); i++){
            System.out.print("\n--------------------------------------------\n");
            
            System.out.println("Código: "+ this.controlador.getListaDePlanos().get(i).getCodigo()+
            "\nValor: "+ this.controlador.getListaDePlanos().get(i).getValor()+
            "\nData de ida: "+ formatacao.format(this.controlador.getListaDePlanos().get(i).getDataIda().getTime())+
            "\nData de volta: "+ formatacao.format(this.controlador.getListaDePlanos().get(i).getDataVolta().getTime())+
            "\n\nFuncionário"+
            "\nCódigo do funcionário: "+ this.controlador.getListaDePlanos().get(i).getFuncionario().getCodigo()+
            "\nNome do funcionário: "+ this.controlador.getListaDePlanos().get(i).getFuncionario().getNome()+
            "\n\nLocal Destino"+
            "\nCódigo do local: "+ this.controlador.getListaDePlanos().get(i).getLocal().getCodigo()+
            "\nCEP: "+ this.controlador.getListaDePlanos().get(i).getLocal().getCepDestino()+
            "\nPais: "+ this.controlador.getListaDePlanos().get(i).getLocal().getPaisDestino()+
            "\nEstado: "+ this.controlador.getListaDePlanos().get(i).getLocal().getEstadoDestino()+
            "\nCidade: "+ this.controlador.getListaDePlanos().get(i).getLocal().getCidadeDestino()+
            "\n\nHotel: "+
            "\nCódigo do hotel: "+ this.controlador.getListaDePlanos().get(i).getHotel().getCodigo()+
            "\nNome do hotel: "+ this.controlador.getListaDePlanos().get(i).getHotel().getNomeHotel()+
            " ("+ this.controlador.getListaDePlanos().get(i).getHotel().getClassificacao()+ ")"+
            "\n\nTransporte"+
            "\nCódigo do transporte: "+ this.controlador.getListaDePlanos().get(i).getTransporte().getCodigo()+
            "\nVeículo: "+ this.controlador.getListaDePlanos().get(i).getTransporte().getVeiculo());
        }
    }

    /**
     * Método excluir:
     *
     * Excluir o Plano informado pelo codigo chamando o controlador
     */
    private void excluir() {

        Scanner s = new Scanner(System.in);

        int codigo, opc;

        System.out.println("Insira o código do plano a ser excluido: ");
        codigo = Integer.parseInt(s.nextLine());

        this.controlador.buscar(codigo);
        
        if(this.controlador.getPlano() == null){
            System.out.println("\nNão existe nenhum plano com esse código");
        }
        else {
            SimpleDateFormat formatacao = new SimpleDateFormat("dd/MM/yyyy");
            
            System.out.println("Código: "+ this.controlador.getPlano().getCodigo()+
            "\nValor: "+ this.controlador.getPlano().getValor()+
            "\nData de ida: "+ formatacao.format(this.controlador.getPlano().getDataIda().getTime())+
            "\nData de volta: "+ formatacao.format(this.controlador.getPlano().getDataVolta().getTime())+
            "\n\nFuncionário"+
            "\nCódigo do funcionário: "+ this.controlador.getPlano().getFuncionario().getCodigo()+
            "\nNome do funcionário: "+ this.controlador.getPlano().getFuncionario().getNome()+
            "\n\nLocal Destino"+
            "\nCódigo do local: "+ this.controlador.getPlano().getLocal().getCodigo()+
            "\nCEP do local: "+ this.controlador.getPlano().getLocal().getCepDestino()+
            "\nPais: "+ this.controlador.getPlano().getLocal().getPaisDestino()+
            "\nEstado: "+ this.controlador.getPlano().getLocal().getEstadoDestino()+
            "\nCidade: "+ this.controlador.getPlano().getLocal().getCidadeDestino()+
            "\n\nHotel: "+
            "\nCódigo do hotel: "+ this.controlador.getPlano().getHotel().getCodigo()+
            "\nNome do hotel: "+ this.controlador.getPlano().getHotel().getNomeHotel()+
            " ("+ this.controlador.getPlano().getHotel().getClassificacao()+ ")"+
            "\n\nTransporte"+
            "\nCódigo do transporte: "+ this.controlador.getPlano().getTransporte().getCodigo()+
            "\nVeículo: "+ this.controlador.getPlano().getTransporte().getVeiculo());
            
            System.out.println("\nDeseja realmente excluir esse plano? (0 - Não | 1 - Sim): ");
            int op = Integer.parseInt(s.nextLine());
            
            try {
                this.controlador.excluir(codigo);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
