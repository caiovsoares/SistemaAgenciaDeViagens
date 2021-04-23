package sistemaagenciaviagens.dao;

import java.util.ArrayList;

import sistemaagenciaviagens.model.LocalModel;
import sistemaagenciaviagens.model.PlanoModel;
import sistemaagenciaviagens.model.FuncionarioModel;
import sistemaagenciaviagens.model.ClienteModel;
import sistemaagenciaviagens.model.HotelModel;
import sistemaagenciaviagens.model.TransporteModel;

public class BancoDeDados {

    private static ArrayList<LocalModel> tabelaLocal = null;
    private static ArrayList<FuncionarioModel> tabelaFuncionario = null;
    private static ArrayList<ClienteModel> tabelaCliente = null;
    private static ArrayList<HotelModel> hotelTable = null;
    private static ArrayList<TransporteModel> transporteTable = null;
    private static ArrayList<PlanoModel> planoTable = null;
    
    private static int proximoCodigoLocal = 1;
    private static int proximoCodigoFuncionario = 1;
    private static int proximoCodigoCliente = 1;
    private static int proximoCodigoHotel = 1;
    private static int proximoCodigoTransporte = 1;
    private static int proximoCodigoPlano = 1;
    
    // Local
    
    public static int getProximoCodigoLocal(){
        return proximoCodigoLocal;
    }
    
    public static ArrayList<LocalModel> getTabelaLocal(){
        if(tabelaLocal == null){
            tabelaLocal = new ArrayList<LocalModel>();
        }
        
        return tabelaLocal;
    }
    
    public static void setProximoCodigoLocal(int codigo){
        proximoCodigoLocal = codigo;
    }
    
    public static void setTabelaLocal(ArrayList<LocalModel> tabelaL){
        tabelaLocal = tabelaL;
    }
    
    public static void atualizaProximoCodigoLocal(){
        proximoCodigoLocal++;
    }
    
    
    // Funcionario
    
    public static int getProximoCodigoFuncionario(){
        return proximoCodigoFuncionario;
    }
    
    public static ArrayList<FuncionarioModel> getTabelaFuncionario(){
        if(tabelaFuncionario == null){
            tabelaFuncionario = new ArrayList<FuncionarioModel>();
        }
       
        return tabelaFuncionario;
    }
    
    public static void setProximoCodigoFuncionario(int codigo){
        proximoCodigoFuncionario = codigo;
    }
    
    public static void setTabelaFuncionario(ArrayList<FuncionarioModel> tabelaF){
        tabelaFuncionario = tabelaF;
    }
    
    public static void atualizaProximoCodigoFuncionario(){
        proximoCodigoFuncionario++;
    }
    
    
    // Cliente
    
    public static int getProximoCodigoCliente(){
        return proximoCodigoCliente;
    }
    
    public static ArrayList<ClienteModel> getTabelaCliente(){
        if(tabelaCliente == null){
            tabelaCliente = new ArrayList<ClienteModel>();
        }
        
        return tabelaCliente;
    }
    
    public static void setProximoCodigoCliente(int codigo){
        proximoCodigoCliente = codigo;
    }
    
    public static void setTabelaCliente(ArrayList<ClienteModel> tabelaC){
        tabelaCliente = tabelaC;
    }
    
    public static void atualizaProximoCodigoCliente(){
        proximoCodigoCliente++;
    }
    
    
    // Hotel
    
    public static int getProximoCodigoHotel() {
        return proximoCodigoHotel;
    }
    
    public static ArrayList<HotelModel> getHotelTable() {
        if(hotelTable == null){
            hotelTable = new ArrayList<HotelModel>();
        }
        
        return hotelTable;
    }
    
    public static void setProximoCodigoHotel(int cod) {
        proximoCodigoHotel = cod;
    }

    public static void setHotelTable(ArrayList<HotelModel> hotelT) {
        hotelTable = hotelT;
    }

    public static void atualizaProximoCodigoHotel() {
        proximoCodigoHotel++;
    }
    
    
    // Transporte
    
    public static int getProximoCodigoTransporte() {
        return proximoCodigoTransporte;
    }
    
    public static ArrayList<TransporteModel> getTransporteTable() {
        if(transporteTable == null){
            transporteTable = new ArrayList<TransporteModel>();
        }
        
        return transporteTable;
    }
    
    public static void setProximoCodigoTransporte(int cod) {
        proximoCodigoTransporte = cod;
    }

    public static void setTransporteTable(ArrayList<TransporteModel> transporteT) {
        transporteTable = transporteT;
    }

    public static void atualizaProximoCodigoTransporte() {
        proximoCodigoTransporte++;
    }
    
    // Plano
	
    public static void setPlanoTable(ArrayList<PlanoModel> pT) {
        planoTable = pT;
    }

    public static void setProximoCodigoPlano(int cod) {
        proximoCodigoPlano = cod;
    }

    public static int getProximoCodigoPlano() {
        return proximoCodigoPlano;
    }

    public static ArrayList<PlanoModel> getPlanoTable() {
        if (planoTable == null) {
            planoTable = new ArrayList<PlanoModel>();
        }
        
        return planoTable;
    }

    public static void atualizaProximoCodigoPlano() {
        proximoCodigoPlano++;
    }
    
}
