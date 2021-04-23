package sistemaagenciaviagens.controller;

import java.util.ArrayList;

import sistemaagenciaviagens.dao.BD;
import sistemaagenciaviagens.dao.TransporteDAO;
import sistemaagenciaviagens.model.TransporteModel;

public class TransporteController {

    private TransporteModel transporte;
    private ArrayList<TransporteModel> listaTransporte;
    private BD db;
	
    public TransporteController(){
        this.db = new TransporteDAO();
    }
    
    public TransporteModel getTransporte(){
        return transporte;
    }
    
    public ArrayList<TransporteModel> getListaTransporte(){
        return listaTransporte;
    }
    
    public void salvar(int codigo, String nomeEmpresa, String veiculo) throws Exception {
        TransporteModel t = new TransporteModel();

        t.setNomeEmpresa(nomeEmpresa);
        t.setVeiculo(veiculo);
        
        if(codigo == 0){
            this.db.salvar(t);
        }
        else{
            t.setCodigo(codigo);
            
            this.db.alterar(t);
        }
    }

    public void excluir(int codigo) throws Exception {
        this.db.excluir(codigo);
    }

    public void buscar(int codigo) {
        Object object = this.db.buscar(codigo);
        
        this.transporte = (TransporteModel) object;
    }

    public void buscarTodos() {
        this.listaTransporte = new ArrayList<TransporteModel>();

        for (Object o : this.db.buscarTodos()) {
            TransporteModel tM = (TransporteModel) o;
            
            this.listaTransporte.add(tM);
        }
    }
    
}
