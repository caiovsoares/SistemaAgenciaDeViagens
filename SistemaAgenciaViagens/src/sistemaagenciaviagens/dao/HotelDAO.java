package sistemaagenciaviagens.dao;

import java.util.ArrayList;

import sistemaagenciaviagens.model.HotelModel;

public class HotelDAO implements BD {

    @Override
    public void salvar(Object o) {
        HotelModel h = (HotelModel) o; //cast
        
        h.setCodigo(BancoDeDados.getProximoCodigoHotel());
        
        BancoDeDados.getHotelTable().add(h); //salvando
        
        BancoDeDados.atualizaProximoCodigoHotel();
    }

    @Override
    public void alterar(Object o) {
        HotelModel h = (HotelModel) o; //cast

        for (int i = 0; i < BancoDeDados.getHotelTable().size(); i++) {
            HotelModel hM = BancoDeDados.getHotelTable().get(i);

            if (h.getCodigo() == hM.getCodigo()) {
                BancoDeDados.getHotelTable().set(i, h);
            }
        }
    }

    @Override
    public void excluir(int cod) throws Exception {
        if (BancoDeDados.getHotelTable().size() == 0) {
            throw new Exception("Nenhum item cadastrado");
        }
        for (int i = 0; i < BancoDeDados.getHotelTable().size(); i++) {
            HotelModel h = BancoDeDados.getHotelTable().get(i);

            if (h.getCodigo() == cod) {
                BancoDeDados.getHotelTable().remove(i);
                break;
            }
            else if((h.getCodigo() != cod) && (i == BancoDeDados.getHotelTable().size()-1)){
                Exception msg = new Exception("Item nao encontrado");
                throw msg;
            }
        }
    }

    @Override
    public Object buscar(int cod) {
        Object h = new Object();
        
        for (HotelModel hotel : BancoDeDados.getHotelTable()) {
            if (hotel.getCodigo() == cod) {
                h = hotel;
                return h;
            }
        }
        
        return null;
    }
	
    @Override
    public ArrayList<Object> buscarTodos() {
        ArrayList<Object> listaH = new ArrayList<Object>();

        for (Object o : BancoDeDados.getHotelTable()) {
            listaH.add(o);
        }
        
        return listaH;
    }

}
