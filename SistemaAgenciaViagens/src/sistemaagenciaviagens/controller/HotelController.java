package sistemaagenciaviagens.controller;

import java.util.ArrayList;

import sistemaagenciaviagens.model.HotelModel;
import sistemaagenciaviagens.dao.HotelDAO;
import sistemaagenciaviagens.dao.BD;

public class HotelController {

    private HotelModel hotel;
    private ArrayList<HotelModel> listaHotel;

    private BD db;
	
    public HotelController() {
        this.db = new HotelDAO();
    }
    
    public HotelModel getHotel(){
        return hotel;
    }
    
    public ArrayList<HotelModel> getListaHotel(){
        return listaHotel;
    }
        
    public void salvar(int codigo, String nomeHotel, String classificacao, 
            String bairro, String rua, String numero) throws Exception {
        HotelModel h = new HotelModel();
        
        h.setNomeHotel(nomeHotel);
        h.setClassificacao(classificacao);
        h.setBairro(bairro);
        h.setRua(rua);
        h.setNumero(numero);

        if(codigo == 0){
            this.db.salvar(h);
        }
        else{
            h.setCodigo(codigo);
            
            this.db.alterar(h);
        }
    }

    public void excluir(int codigo) throws Exception {
        this.db.excluir(codigo);
    }

    public void buscar(int codigo) {
        Object object = this.db.buscar(codigo);
        
        this.hotel = (HotelModel) object;
    }

    public void buscaTodos() {
        this.listaHotel = new ArrayList<HotelModel>();

        for (Object o : this.db.buscarTodos()) {
            HotelModel hM = (HotelModel) o;
            
            this.listaHotel.add(hM);
        }
    }

}
