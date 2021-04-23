package sistemaagenciaviagens.controller;

import java.util.ArrayList;

import sistemaagenciaviagens.dao.BD;
import sistemaagenciaviagens.model.LocalModel;
import sistemaagenciaviagens.dao.LocalDAO;

public class LocalController{

    private LocalModel local;
    private ArrayList<LocalModel> listaDeLocais;
    private BD db;
    
    public LocalController(){
        this.db = new LocalDAO();
    }
    
    public LocalModel getLocal(){
        return this.local;
    }
    
    public ArrayList<LocalModel> getListaDeLocais(){
        return this.listaDeLocais;
    }
    
    public void salvar(int codigo, String cepDestino, String paisDestino, 
            String estadoDestino, String cidadeDestino) throws Exception{
        LocalModel lc = new LocalModel();
        
        lc.setCepDestino(cepDestino);
        lc.setPaisDestino(paisDestino);
        lc.setEstadoDestino(estadoDestino);
        lc.setCidadeDestino(cidadeDestino);
        
        if(codigo == 0){
            this.db.salvar(lc);
        }
        else{
            lc.setCodigo(codigo);
            
            this.db.alterar(lc);
        }
    }
    
    public void excluir(int codigo) throws Exception{
        this.db.excluir(codigo);
    }
    
    public void buscar(String cep){
        Object o = this.db.buscar(Integer.parseInt(cep));
        
        this.local = (LocalModel) o;
    }
    
    public void buscarTodos(){
        this.listaDeLocais = new ArrayList<LocalModel>();
        
        for (Object o : this.db.buscarTodos()) {
            LocalModel lc = (LocalModel) o;
            this.listaDeLocais.add(lc);
        }
    }
    
}
