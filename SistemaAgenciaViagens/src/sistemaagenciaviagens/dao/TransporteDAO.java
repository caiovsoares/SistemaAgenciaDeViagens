package sistemaagenciaviagens.dao;

import java.util.ArrayList;

import sistemaagenciaviagens.model.TransporteModel;

public class TransporteDAO implements BD{

    @Override
    public void salvar(Object o) {
        TransporteModel t = (TransporteModel) o;
        
        t.setCodigo(BancoDeDados.getProximoCodigoTransporte());
        
        BancoDeDados.getTransporteTable().add(t);
        
        BancoDeDados.atualizaProximoCodigoTransporte();
    }

    @Override
    public void alterar(Object o) {
        TransporteModel t = (TransporteModel) o;

        for (int i = 0; i < BancoDeDados.getTransporteTable().size(); i++) {
            TransporteModel tM = BancoDeDados.getTransporteTable().get(i);

            if (tM.getCodigo() == t.getCodigo()) {
                BancoDeDados.getTransporteTable().set(i, t);
            }
        }
    }

    @Override
    public void excluir(int cod) throws Exception {
        if (BancoDeDados.getTransporteTable().size() == 0) {
            throw new Exception("Nao existem transportes cadastrados");
        }
        for (int i = 0; i < BancoDeDados.getTransporteTable().size(); i++) {
            TransporteModel tM = BancoDeDados.getTransporteTable().get(i);

            if (tM.getCodigo() == cod) {
                BancoDeDados.getTransporteTable().remove(i);
                break;
            }
            else if((tM.getCodigo() != cod) && (i == BancoDeDados.getTransporteTable().size()-1)){
                Exception msg = new Exception("Transporte não encontrado");
                throw msg;
            }
        }
    }

    @Override
    public Object buscar(int cod) {
        Object t = new Object();

        for (TransporteModel transp : BancoDeDados.getTransporteTable()) {
            if (transp.getCodigo() == cod) {
                t = transp;
                return t;
            }
        }

        return null;
    }

    @Override
    public ArrayList<Object> buscarTodos() {
        ArrayList<Object> listaT = new ArrayList<Object>();

        for (Object o : BancoDeDados.getTransporteTable()) {
            listaT.add(o);
        }
        
        return listaT;
    }

}
