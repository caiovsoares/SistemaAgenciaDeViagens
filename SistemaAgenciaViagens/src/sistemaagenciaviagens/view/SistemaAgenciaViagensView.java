/*

Engenharia de Software - POO II
Trabalho MVC - Sistema de Agencia de Viagens

Ariel Sartorio - RA: 25629-4
Bruno Fonseca - RA: 25631-3
Evandro Caslini - RA: 25637-4
Thiago Gadiani - RA: 25947-5

*/


package sistemaagenciaviagens.view;

import java.util.Scanner;
import java.util.ArrayList;

import sistemaagenciaviagens.dao.BancoDeDados;
import sistemaagenciaviagens.uteis.ManipulaDB;
import sistemaagenciaviagens.model.ClienteModel;
import sistemaagenciaviagens.model.FuncionarioModel;
import sistemaagenciaviagens.model.HotelModel;
import sistemaagenciaviagens.model.LocalModel;
import sistemaagenciaviagens.model.PlanoModel;
import sistemaagenciaviagens.model.TransporteModel;

public class SistemaAgenciaViagensView {

    public static void main(String[] args) {
        
        recuperarTabelas();
        
        Scanner s = new Scanner(System.in);
        
        int opc;
        
        do{
            System.out.println("\n\n-----MENU PRINCIPAL-----");
            System.out.println("1 - Funcionário");
            System.out.println("2 - Local");
            System.out.println("3 - Hotel");
            System.out.println("4 - Transporte");
            System.out.println("5 - Plano de Viagem");
            System.out.println("6 - Cliente");
            System.out.println("0 - Sair");
            
            System.out.print("\nSelecione a opção: ");
            opc = Integer.parseInt(s.nextLine());
            
            switch(opc){
                case 0:{
                    salvarTabelas();
                    break;
                }
                case 1:{
                    FuncionarioView fun = new FuncionarioView();
                    break;
                }
                case 2:{
                    LocalView lcl = new LocalView();
                    break;
                }
                case 3:{
                    HotelView htl = new HotelView();
                    break;
                }
                case 4:{
                    TransporteView trp = new TransporteView();
                    break;
                }
                case 5:{
                    PlanoView pln = new PlanoView();
                    break;
                }
                case 6:{
                    ClienteView cli = new ClienteView();
                    break;
                }
            }
        }while(opc != 0);
        
    }
    
    public static void salvarTabelas(){
        ArrayList<Object> tabelaLcl = new ArrayList<>();
        ArrayList<Object> tabelaF = new ArrayList<>();
        ArrayList<Object> tabelaCli = new ArrayList<>();
        ArrayList<Object> tabelaHtl = new ArrayList<>();
        ArrayList<Object> tabelaTpt = new ArrayList<>();
        ArrayList<Object> tabelaPln = new ArrayList<>();
        
        for(Object local : BancoDeDados.getTabelaLocal()){
            tabelaLcl.add(local);
        }
        
        for (Object funcionario : BancoDeDados.getTabelaFuncionario()) {
            tabelaF.add(funcionario);
        }
        
        for (Object cliente : BancoDeDados.getTabelaCliente()) {
            tabelaCli.add(cliente);
        }
        
        for (Object hotel : BancoDeDados.getHotelTable()) {
            tabelaHtl.add(hotel);
        }
        
        for (Object transporte : BancoDeDados.getTransporteTable()) {
            tabelaTpt.add(transporte);
        }
        
        for (Object plano : BancoDeDados.getPlanoTable()) {
            tabelaPln.add(plano);
        }
        
        try {
            ManipulaDB.salvarArquivo(tabelaLcl, "banco/local.dat");
            
            ManipulaDB.salvarArquivo(tabelaF, "banco/funcionario.dat");
            
            ManipulaDB.salvarArquivo(tabelaCli, "banco/cliente.dat");
            
            ManipulaDB.salvarArquivo(tabelaHtl, "banco/hotel.dat");
            
            ManipulaDB.salvarArquivo(tabelaTpt, "banco/transporte.dat");
            
            ManipulaDB.salvarArquivo(tabelaPln, "banco/plano.dat");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
    public static void recuperarTabelas(){
        System.out.println("Conectando ao Banco de Dados");
        
        try {
            ArrayList tabelaL = ManipulaDB.recuperarArquivo("banco/local.dat");
            ArrayList tabelaF = ManipulaDB.recuperarArquivo("banco/funcionario.dat");
            ArrayList tabelaC = ManipulaDB.recuperarArquivo("banco/cliente.dat");
            ArrayList tabelaH = ManipulaDB.recuperarArquivo("banco/hotel.dat");
            ArrayList tabelaT = ManipulaDB.recuperarArquivo("banco/transporte.dat");
            ArrayList tabelaP = ManipulaDB.recuperarArquivo("banco/plano.dat");
            
            // Local
            
            if(tabelaL != null){
                ArrayList<LocalModel> tLocal = new ArrayList<LocalModel>();
                
                for (Object o : tabelaL) {
                    LocalModel lcl = (LocalModel) o;
                    
                    tLocal.add(lcl);
                }
                
                /* Atualiza o codigo conforme recupera os dados para que nao
                   haja problema na geracao de novos codigos e eles nao se repitam */
                if((tLocal.size()) > 0){
                    BancoDeDados.setProximoCodigoLocal(tLocal.get(tLocal.size()-1).getCodigo() + 1);
                }
                else{
                    BancoDeDados.setProximoCodigoLocal(BancoDeDados.getProximoCodigoLocal());
                }
                
                BancoDeDados.setTabelaLocal(tLocal);
            }
            
            // Funcionario
            
            if(tabelaF != null){
                ArrayList<FuncionarioModel> tFuncionario = new ArrayList<FuncionarioModel>();
                
                for (Object o : tabelaF) {
                    FuncionarioModel f = (FuncionarioModel) o;
                    
                    tFuncionario.add(f);
                }
                
                /* Atualiza o codigo conforme recupera os dados para que nao
                   haja problema na geracao de novos codigos e eles nao se repitam */
                if((tFuncionario.size()) > 0){
                    BancoDeDados.setProximoCodigoFuncionario(tFuncionario.get(tFuncionario.size()-1).getCodigo() + 1);
                }
                else{
                    BancoDeDados.setProximoCodigoFuncionario(BancoDeDados.getProximoCodigoFuncionario());
                }
                
                BancoDeDados.setTabelaFuncionario(tFuncionario);
            }
            
            // Cliente
            
            if(tabelaC != null){
                ArrayList<ClienteModel> tCliente = new ArrayList<ClienteModel>();
                
                for (Object o : tabelaC) {
                    ClienteModel c = (ClienteModel) o;
                    
                    tCliente.add(c);
                }
                
                /* Atualiza o codigo conforme recupera os dados para que nao
                   haja problema na geracao de novos codigos e eles nao se repitam */
                if((tCliente.size()) > 0){
                    BancoDeDados.setProximoCodigoCliente(tCliente.get(tCliente.size()-1).getCodigo() + 1);
                }
                else{
                    BancoDeDados.setProximoCodigoCliente(BancoDeDados.getProximoCodigoCliente());
                }
                
                BancoDeDados.setTabelaCliente(tCliente);
            }
            
            // Hotel
            
            if(tabelaH != null){
                ArrayList<HotelModel> tHotel = new ArrayList<HotelModel>();
                
                for (Object o : tabelaH) {
                    HotelModel h = (HotelModel) o;
                    
                    tHotel.add(h);
                }
                
                /* Atualiza o codigo conforme recupera os dados para que nao
                   haja problema na geracao de novos codigos e eles nao se repitam */
                if((tHotel.size()) > 0){
                    BancoDeDados.setProximoCodigoHotel(tHotel.get(tHotel.size()-1).getCodigo() + 1);
                }
                else{
                    BancoDeDados.setProximoCodigoHotel(BancoDeDados.getProximoCodigoHotel());
                }
                
                BancoDeDados.setHotelTable(tHotel);
            }
            
            // Transporte
            
            if(tabelaT != null){
                ArrayList<TransporteModel> tTransporte = new ArrayList<TransporteModel>();
                
                for (Object o : tabelaT) {
                    TransporteModel t = (TransporteModel) o;
                    
                    tTransporte.add(t);
                }
                
                /* Atualiza o codigo conforme recupera os dados para que nao
                   haja problema na geracao de novos codigos e eles nao se repitam */
                if((tTransporte.size()) > 0){
                    BancoDeDados.setProximoCodigoTransporte(tTransporte.get(tTransporte.size()-1).getCodigo() + 1);
                }
                else{
                    BancoDeDados.setProximoCodigoTransporte(BancoDeDados.getProximoCodigoTransporte());
                }
                
                BancoDeDados.setTransporteTable(tTransporte);
            }
            
            // Plano
            
            if(tabelaP != null){
                ArrayList<PlanoModel> tPlano = new ArrayList<PlanoModel>();
                
                for (Object o : tabelaP) {
                    PlanoModel p = (PlanoModel) o;
                    
                    tPlano.add(p);
                }
                
                /* Atualiza o codigo conforme recupera os dados para que nao
                   haja problema na geracao de novos codigos e eles nao se repitam */
                if((tPlano.size()) > 0){
                    BancoDeDados.setProximoCodigoPlano(tPlano.get(tPlano.size()-1).getCodigo() + 1);
                }
                else{
                    BancoDeDados.setProximoCodigoPlano(BancoDeDados.getProximoCodigoPlano());
                }
                
                BancoDeDados.setPlanoTable(tPlano);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
