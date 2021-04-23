package sistemaagenciaviagens.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import sistemaagenciaviagens.dao.BD;

import sistemaagenciaviagens.dao.PlanoDao;
import sistemaagenciaviagens.dao.FuncionarioDAO;
import sistemaagenciaviagens.dao.LocalDAO;
import sistemaagenciaviagens.dao.HotelDAO;
import sistemaagenciaviagens.dao.TransporteDAO;

import sistemaagenciaviagens.model.PlanoModel;
import sistemaagenciaviagens.model.FuncionarioModel;
import sistemaagenciaviagens.model.LocalModel;
import sistemaagenciaviagens.model.HotelModel;
import sistemaagenciaviagens.model.TransporteModel;

public class PlanoController {

    private PlanoModel plano;
    private ArrayList<PlanoModel> listaDePlanos;
    private BD db;
    
    private FuncionarioDAO funcionarioDAO;
    private LocalDAO localDAO;
    private HotelDAO hotelDAO;
    private TransporteDAO transporteDAO;
    
    private FuncionarioModel funcionario;
    private LocalModel local;
    private HotelModel hotel;
    private TransporteModel transporte;

    public PlanoController() {
        this.funcionarioDAO = new FuncionarioDAO();
        this.localDAO = new LocalDAO();
        this.hotelDAO = new HotelDAO();
        this.transporteDAO = new TransporteDAO();
        
        this.db = new PlanoDao();
    }
    
    public PlanoModel getPlano(){
        return this.plano;
    }

    public ArrayList<PlanoModel> getListaDePlanos() {
        return this.listaDePlanos;
    }
    
    public FuncionarioModel getFuncionario(){
        return this.funcionario;
    }
    
    public LocalModel getLocal(){
        return this.local;
    }
    
    public HotelModel getHotel(){
        return this.hotel;
    }
    
    public TransporteModel getTransporte(){
        return this.transporte;
    }
    
    public void buscaFuncionarioCodigo(int codigo){
        Object o = this.funcionarioDAO.buscar(codigo);
        
        this.funcionario = (FuncionarioModel) o;
    }
    
    public void buscarLocalCEP(int cep){
        Object o = this.localDAO.buscar(cep);
        
        this.local = (LocalModel) o;
    }
    
    public void buscarHotelCodigo(int codigo){
        Object o = this.hotelDAO.buscar(codigo);
        
        this.hotel = (HotelModel) o;
    }
    
    public void buscarTransporteCodigo(int codigo){
        Object o = this.transporteDAO.buscar(codigo);
        
        this.transporte = (TransporteModel) o;
    }

    public void salvar(int codigo, double valor, String dataIda, String dataVolta, 
            FuncionarioModel funcionario, LocalModel local, HotelModel hotel, 
            TransporteModel transporte) throws Exception {
        SimpleDateFormat formatacao = new SimpleDateFormat("dd/MM/yyyy");
        
        PlanoModel p = new PlanoModel();
        
        p.setValor(valor);
        p.setFuncionario(funcionario);
        p.setLocal(local);
        p.setHotel(hotel);
        p.setTransporte(transporte);
        
        Calendar dataI = Calendar.getInstance();
        Calendar dataV = Calendar.getInstance();
        
        dataI.setTime(formatacao.parse(dataIda));
        dataV.setTime(formatacao.parse(dataVolta));
        
        p.setDataIda(dataI);
        p.setDataVolta(dataV);

        if(codigo == 0){
            this.db.salvar(p);
        }
        else{
            p.setCodigo(codigo);
            
            this.db.alterar(p);
        }
    }

    public void excluir(int codigo) throws Exception {
        this.db.excluir(codigo);
    }

    public void buscar(int cod) {
        Object o = this.db.buscar(cod);

        this.plano = (PlanoModel) o;
    }

    public void buscarTodos() {
        this.listaDePlanos = new ArrayList<PlanoModel>();

        for (Object o : this.db.buscarTodos()) {
            PlanoModel p = (PlanoModel) o;
            this.listaDePlanos.add(p);
        }
    }

}
